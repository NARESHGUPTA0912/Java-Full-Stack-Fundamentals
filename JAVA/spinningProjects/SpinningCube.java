package spinningProjects;

/**
 * Spinning 3D Cube Animation in Java
 *
 * Renders a 3D ASCII cube rotating in the terminal.
 * Each face is filled with a distinct character for visual depth.
 *
 * Run with: javac SpinningCube.java && java SpinningCube
 */
public class SpinningCube {

    // Screen dimensions
    static final int   WIDTH       = 80;
    static final int   HEIGHT      = 44;
    static final float FOV         = 60;          // perspective field-of-view factor
    static final float CAMERA_Z    = 18.0f;       // camera distance from origin
    static final float CUBE_SIZE   = 4.5f;        // half-edge length of the cube
    static final float STEP        = 0.04f;       // surface scan step (smaller = denser fill)

    // One character per face
    static final char[] FACE_CHARS = { '#', '@', '+', '=', '*', '.' };
    // Face names (for reference): +X, -X, +Y, -Y, +Z, -Z

    public static void main(String[] args) throws InterruptedException {

        float   A = 0, B = 0, C = 0;   // rotation angles: X, Y, Z axes
        float[] zBuf    = new float[WIDTH * HEIGHT];
        char[]  screen  = new char[WIDTH * HEIGHT];

        // ANSI: hide cursor, clear screen
        System.out.print("\033[?25l\033[2J");

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
            System.out.print("\033[?25h\033[0m\033[2J\033[H")
        ));

        while (true) {

            // Clear buffers
            for (int i = 0; i < WIDTH * HEIGHT; i++) {
                screen[i] = ' ';
                zBuf[i]   = 0f;
            }

            float sinA = (float) Math.sin(A), cosA = (float) Math.cos(A);
            float sinB = (float) Math.sin(B), cosB = (float) Math.cos(B);
            float sinC = (float) Math.sin(C), cosC = (float) Math.cos(C);

            float s = CUBE_SIZE;

            // Scan all 6 faces of the cube.
            // For each face we fix one coordinate to ±s and sweep the other two.
            for (float u = -s; u <= s; u += STEP) {
                for (float v = -s; v <= s; v += STEP) {

                    // Face 0: +X  (right)
                    plotPoint( s,  u,  v, FACE_CHARS[0], sinA, cosA, sinB, cosB, sinC, cosC, screen, zBuf);
                    // Face 1: -X  (left)
                    plotPoint(-s,  u,  v, FACE_CHARS[1], sinA, cosA, sinB, cosB, sinC, cosC, screen, zBuf);
                    // Face 2: +Y  (top)
                    plotPoint( u,  s,  v, FACE_CHARS[2], sinA, cosA, sinB, cosB, sinC, cosC, screen, zBuf);
                    // Face 3: -Y  (bottom)
                    plotPoint( u, -s,  v, FACE_CHARS[3], sinA, cosA, sinB, cosB, sinC, cosC, screen, zBuf);
                    // Face 4: +Z  (front)
                    plotPoint( u,  v,  s, FACE_CHARS[4], sinA, cosA, sinB, cosB, sinC, cosC, screen, zBuf);
                    // Face 5: -Z  (back)
                    plotPoint( u,  v, -s, FACE_CHARS[5], sinA, cosA, sinB, cosB, sinC, cosC, screen, zBuf);
                }
            }

            // Build & flush the frame
            StringBuilder frame = new StringBuilder("\033[H");
            for (int row = 0; row < HEIGHT; row++) {
                for (int col = 0; col < WIDTH; col++) {
                    frame.append(screen[col + row * WIDTH]);
                }
                frame.append('\n');
            }
            System.out.print(frame);

            // Advance rotation — different speeds on each axis for an organic tumble
            A += 0.030f;
            B += 0.020f;
            C += 0.015f;

            Thread.sleep(28); // ~35 fps
        }
    }

    /**
     * Rotates a 3-D point (x,y,z) using Euler angles A (X-axis), B (Y-axis), C (Z-axis),
     * applies perspective projection, then writes the character to the screen buffer
     * using a z-buffer test so nearer faces overwrite farther ones.
     */
    static void plotPoint(
            float x, float y, float z, char ch,
            float sinA, float cosA,
            float sinB, float cosB,
            float sinC, float cosC,
            char[] screen, float[] zBuf) {

        // --- Rotate around X axis ---
        float y1 = y * cosA - z * sinA;
        float z1 = y * sinA + z * cosA;

        // --- Rotate around Y axis ---
        float x2 =  x * cosB + z1 * sinB;
        float z2 = -x * sinB + z1 * cosB;

        // --- Rotate around Z axis ---
        float x3 = x2 * cosC - y1 * sinC;
        float y3 = x2 * sinC + y1 * cosC;

        // Translate away from camera
        float zDepth = z2 + CAMERA_Z;
        if (zDepth <= 0) return;          // behind the camera

        // Perspective divide
        float ooz = 1.0f / zDepth;
        int xp = (int) (WIDTH  / 2 + FOV * ooz * x3 * 2); // *2: terminal chars are tall
        int yp = (int) (HEIGHT / 2 - FOV * ooz * y3);

        if (xp < 0 || xp >= WIDTH || yp < 0 || yp >= HEIGHT) return;

        int idx = xp + yp * WIDTH;
        if (ooz > zBuf[idx]) {          // z-buffer test: closer point wins
            zBuf[idx]  = ooz;
            screen[idx] = ch;
        }
    }
}
