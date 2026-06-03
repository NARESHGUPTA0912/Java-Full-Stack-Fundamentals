package javaAdvanced.spinningProjects;

/**
 * Clean Spinning 3D Wireframe Cube — Java Terminal Animation
 *
 * Draws only the 12 edges of the cube for a crisp, clear look.
 * Run with: javac SpinningCube.java && java SpinningCube
 */
public class SpinningCube2 {

    static final int   WIDTH    = 60;
    static final int   HEIGHT   = 30;
    static final float CAM_Z    = 12.0f;   // camera distance
    static final float FOV      = 18.0f;   // projection scale
    static final float SIZE     = 2.8f;    // half-edge of cube (keep it small)
    static final int   STEPS    = 120;     // points sampled per edge

    // 8 corners of the cube
    static final float[][] VERTS = {
        {-1, -1, -1}, { 1, -1, -1}, { 1,  1, -1}, {-1,  1, -1},  // back  face
        {-1, -1,  1}, { 1, -1,  1}, { 1,  1,  1}, {-1,  1,  1},  // front face
    };

    // 12 edges: each pair is two vertex indices
    static final int[][] EDGES = {
        {0,1},{1,2},{2,3},{3,0},   // back  face
        {4,5},{5,6},{6,7},{7,4},   // front face
        {0,4},{1,5},{2,6},{3,7},   // side  pillars
    };

    public static void main(String[] args) throws InterruptedException {

        float   A = 0.5f, B = 0.5f, C = 0;
        char[]  screen = new char[WIDTH * HEIGHT];
        float[] zBuf   = new float[WIDTH * HEIGHT];

        System.out.print("\033[?25l\033[2J");   // hide cursor, clear screen

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
            System.out.print("\033[?25h\033[2J\033[H")
        ));

        while (true) {

            for (int i = 0; i < WIDTH * HEIGHT; i++) {
                screen[i] = ' ';
                zBuf[i]   = 0;
            }

            float sinA = (float) Math.sin(A), cosA = (float) Math.cos(A);
            float sinB = (float) Math.sin(B), cosB = (float) Math.cos(B);
            float sinC = (float) Math.sin(C), cosC = (float) Math.cos(C);

            // Draw all 12 edges
            for (int[] edge : EDGES) {
                float[] p0 = VERTS[edge[0]];
                float[] p1 = VERTS[edge[1]];

                for (int s = 0; s <= STEPS; s++) {
                    float t = (float) s / STEPS;

                    // Interpolate along the edge, scaled by SIZE
                    float x = (p0[0] + t * (p1[0] - p0[0])) * SIZE;
                    float y = (p0[1] + t * (p1[1] - p0[1])) * SIZE;
                    float z = (p0[2] + t * (p1[2] - p0[2])) * SIZE;

                    // Rotate X
                    float y1 = y * cosA - z * sinA;
                    float z1 = y * sinA + z * cosA;
                    // Rotate Y
                    float x2 =  x * cosB + z1 * sinB;
                    float z2 = -x * sinB + z1 * cosB;
                    // Rotate Z
                    float x3 = x2 * cosC - y1 * sinC;
                    float y3 = x2 * sinC + y1 * cosC;

                    float zd = z2 + CAM_Z;
                    if (zd <= 0) continue;

                    float ooz = 1.0f / zd;

                    // Choose edge character based on orientation
                    float dx = Math.abs(p1[0] - p0[0]);
                    float dy = Math.abs(p1[1] - p0[1]);
                    char  ch;
                    if      (dx > 0.5f && dy < 0.1f) ch = '-';
                    else if (dx < 0.1f && dy > 0.5f) ch = '|';
                    else                              ch = '+';

                    int xp = (int) (WIDTH  / 2 + FOV * ooz * x3 * 2.2f);
                    int yp = (int) (HEIGHT / 2 - FOV * ooz * y3);

                    if (xp < 1 || xp >= WIDTH - 1 || yp < 1 || yp >= HEIGHT - 1) continue;

                    int idx = xp + yp * WIDTH;
                    if (ooz > zBuf[idx]) {
                        zBuf[idx]  = ooz;
                        screen[idx] = ch;
                    }
                }
            }

            // Render frame
            StringBuilder frame = new StringBuilder("\033[H");
            for (int row = 0; row < HEIGHT; row++) {
                for (int col = 0; col < WIDTH; col++) {
                    frame.append(screen[col + row * WIDTH]);
                }
                frame.append('\n');
            }
            System.out.print(frame);

            A += 0.025f;
            B += 0.018f;
            C += 0.010f;

            Thread.sleep(30); // ~33 fps
        }
    }
}
