package spinningProjects;

import java.util.Arrays;

/**
 *  ASCII Pyramid — Anti-Clockwise Spinning Animation
 *
 *  Compile:  javac SpinningPyramidASCII.java
 *  Run:      java PyramidASCII
 *  Exit:     Ctrl+C
 *
 *  Requires a terminal with ANSI colour support.
 *  macOS / Linux : works out-of-the-box.
 *  Windows       : use Windows Terminal (not legacy cmd.exe).
 *
 *  Technique
 *  ─────────
 *  • 3-D rotation matrices (X-tilt + Y-spin)
 *  • Perspective projection  f = SCALE / (z + DIST)
 *  • Per-triangle rasterisation with barycentric coordinates
 *  • Z-buffer for correct depth ordering
 *  • Back-face culling (normals pointing away from camera are skipped)
 *  • Lambertian shading → ASCII character luminance ramp
 *  • ANSI colours per face
 */
public class SpinningPyramidASCII {

    // ── Terminal dimensions ─────────────────────────────────────────────────
    static final int    W     = 80;    // columns  (adjust to your terminal)
    static final int    H     = 40;    // rows
    static final double SCALE = 52.0;  // projection scale factor
    static final double DIST  = 5.0;   // virtual camera distance

    // ── Pyramid geometry ────────────────────────────────────────────────────
    //   Square base sits at  y = −1.0
    //   Apex sits at         y = +1.5
    static final double[][] V = {
        {-1.0, -1.0, -1.0},   // 0 — base front-left
        { 1.0, -1.0, -1.0},   // 1 — base front-right
        { 1.0, -1.0,  1.0},   // 2 — base back-right
        {-1.0, -1.0,  1.0},   // 3 — base back-left
        { 0.0,  1.5,  0.0},   // 4 — apex
    };

    // Triangular faces  — vertex order chosen so outward normals face *out*
    static final int[][] FACES = {
        {1, 0, 4},   // front  face
        {2, 1, 4},   // right  face
        {3, 2, 4},   // back   face
        {0, 3, 4},   // left   face
        {0, 1, 2},   // base   ▲ 1
        {0, 2, 3},   // base   ▲ 2
    };

    // ANSI colour per face (256-colour bright set)
    static final String[] FACE_COLOR = {
        "\033[91m",   // bright red    — front
        "\033[93m",   // bright yellow — right
        "\033[92m",   // bright green  — back
        "\033[96m",   // bright cyan   — left
        "\033[94m",   // bright blue   — base ▲1
        "\033[94m",   // bright blue   — base ▲2
    };

    // Luminance ramp: index 0 = darkest, last = brightest
    static final char[] RAMP = ".,:~;=!*#$@".toCharArray();

    static final String RST = "\033[0m";   // ANSI reset

    // Light vector pointing FROM the scene TOWARD the light source.
    // (front-above-right)  — fixed in world space so shading changes as pyramid turns.
    static final double[] LIGHT = norm(new double[]{0.3, 0.5, -0.8});

    // ── Rotation state ──────────────────────────────────────────────────────
    static double aX = 0.42;  // X-tilt  (~24 °, fixed – gives a 3/4 view)
    static double aY = 0.00;  // Y-spin  (incremented each frame → anti-clockwise)

    // ── main ────────────────────────────────────────────────────────────────
    public static void main(String[] args) throws InterruptedException {
        // Hide cursor + clear screen
        System.out.print("\033[?25l\033[2J\033[H");

        // Restore terminal on exit (Ctrl+C etc.)
        Runtime.getRuntime().addShutdownHook(new Thread(
            () -> System.out.print("\033[?25h\033[0m\033[2J\033[H")
        ));

        while (true) {
            drawFrame();
            aY += 0.05;          // anti-clockwise Y rotation  (increase → CCW from above)
            Thread.sleep(50);    // ≈ 20 fps
        }
    }

    // ── Render one frame ────────────────────────────────────────────────────
    static void drawFrame() {
        char[]   screen = new char  [W * H];
        String[] colBuf = new String[W * H];
        double[] zBuf   = new double[W * H];
        Arrays.fill(screen, ' ');
        Arrays.fill(zBuf, Double.NEGATIVE_INFINITY);

        // Transform all vertices for the current rotation angles
        double[][] tv = new double[V.length][];
        for (int i = 0; i < V.length; i++)
            tv[i] = xform(V[i][0], V[i][1], V[i][2]);

        // Process each face
        for (int fi = 0; fi < FACES.length; fi++) {
            double[] v0 = tv[FACES[fi][0]];
            double[] v1 = tv[FACES[fi][1]];
            double[] v2 = tv[FACES[fi][2]];

            // Outward surface normal (computed from already-rotated vertices)
            double[] n = norm(cross(sub(v1, v0), sub(v2, v0)));

            // Back-face cull:
            //   Camera sits at z = −DIST, looks in +z direction.
            //   A face points toward the camera when n[2] < 0.
            //   Skip faces whose normal has n[2] ≥ 0 (pointing away).
            if (n[2] >= 0) continue;

            // Lambertian luminance → ASCII character
            double lum = Math.max(0.0, dot(n, LIGHT));
            int    ri  = (int)(lum * (RAMP.length - 1));
            char   c   = RAMP[Math.min(ri, RAMP.length - 1)];

            rasterize(screen, colBuf, zBuf, v0, v1, v2, c, FACE_COLOR[fi]);
        }

        // ── Build output string and flush ───────────────────────────────────
        // Draw a decorative border + title on the last row
        StringBuilder sb = new StringBuilder(W * H * 10);
        sb.append("\033[H");   // cursor to top-left (no flicker clear)

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                int    i  = y * W + x;
                char   ch = screen[i];
                String cl = colBuf[i];
                if (ch != ' ' && cl != null) sb.append(cl).append(ch).append(RST);
                else                         sb.append(' ');
            }
            if (y < H - 1) sb.append('\n');
        }

        // Status line at bottom
        String status = "  \033[90m[ PYRAMID  |  anti-clockwise spin  |  Ctrl+C to exit ]\033[0m  ";
        sb.append("\033[").append(H).append(";1H").append(status);

        System.out.print(sb);
        System.out.flush();
    }

    // ── Triangle rasteriser ─────────────────────────────────────────────────
    //   Barycentric-coordinate fill with z-buffer test.
    static void rasterize(char[] screen, String[] colBuf, double[] zBuf,
                           double[] v0, double[] v1, double[] v2,
                           char c, String color) {

        int[] p0 = project(v0), p1 = project(v1), p2 = project(v2);
        int x0 = p0[0], y0 = p0[1];
        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];

        // Bounding box (clamped to screen)
        int minX = Math.max(0,   Math.min(x0, Math.min(x1, x2)));
        int maxX = Math.min(W-1, Math.max(x0, Math.max(x1, x2)));
        int minY = Math.max(0,   Math.min(y0, Math.min(y1, y2)));
        int maxY = Math.min(H-1, Math.max(y0, Math.max(y1, y2)));

        double denom = (double)(y1-y2)*(x0-x2) + (double)(x2-x1)*(y0-y2);
        if (Math.abs(denom) < 1e-8) return;   // degenerate triangle

        for (int py = minY; py <= maxY; py++) {
            for (int px = minX; px <= maxX; px++) {
                // Barycentric weights
                double w0 = ((double)(y1-y2)*(px-x2) + (double)(x2-x1)*(py-y2)) / denom;
                double w1 = ((double)(y2-y0)*(px-x2) + (double)(x0-x2)*(py-y2)) / denom;
                double w2 = 1.0 - w0 - w1;
                if (w0 < -1e-6 || w1 < -1e-6 || w2 < -1e-6) continue;

                // Interpolated depth
                double z = w0*v0[2] + w1*v1[2] + w2*v2[2];
                int    i = py * W + px;
                if (z > zBuf[i]) {         // passes z-test (closer to camera)
                    zBuf[i]   = z;
                    screen[i] = c;
                    colBuf[i] = color;
                }
            }
        }
    }

    // ── 3-D helpers ─────────────────────────────────────────────────────────

    /** Perspective-project a 3-D point to 2-D screen coordinates.
     *  x is scaled ×2 to compensate for terminal char aspect ratio (~1:2 w:h). */
    static int[] project(double[] v) {
        double f = SCALE / (v[2] + DIST);
        return new int[]{
            (int)(v[0] * f * 2.0) + W / 2,
            (int)(-v[1] * f)      + H / 2
        };
    }

    /** Rotate point (x,y,z) by current angles aX (tilt) and aY (spin). */
    static double[] xform(double x, double y, double z) {
        // X-axis rotation (tilt — kept fixed at aX = 0.42 ≈ 24°)
        double ca = Math.cos(aX), sa = Math.sin(aX);
        double y1 = y*ca - z*sa,  z1 = y*sa + z*ca;

        // Y-axis rotation (anti-clockwise spin — aY increases each frame)
        double cb = Math.cos(aY), sb = Math.sin(aY);
        return new double[]{x*cb + z1*sb, y1, -x*sb + z1*cb};
    }

    static double[] sub  (double[] a, double[] b) {
        return new double[]{a[0]-b[0], a[1]-b[1], a[2]-b[2]};
    }
    static double   dot  (double[] a, double[] b) {
        return a[0]*b[0] + a[1]*b[1] + a[2]*b[2];
    }
    static double[] cross(double[] a, double[] b) {
        return new double[]{
            a[1]*b[2] - a[2]*b[1],
            a[2]*b[0] - a[0]*b[2],
            a[0]*b[1] - a[1]*b[0]
        };
    }
    static double[] norm(double[] v) {
        double l = Math.sqrt(v[0]*v[0] + v[1]*v[1] + v[2]*v[2]);
        if (l > 1e-10) { v[0] /= l; v[1] /= l; v[2] /= l; }
        return v;
    }
}
