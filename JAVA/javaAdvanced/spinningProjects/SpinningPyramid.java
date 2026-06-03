package javaAdvanced.spinningProjects;

/**
 * Smooth Spinning 3D Wireframe Pyramid — Java Terminal Animation
 *
 * Square-base pyramid: 5 vertices, 8 edges.
 * Wireframe rendering with z-buffer for correct depth ordering.
 *
 * Run with: javac SpinningPyramid.java && java SpinningPyramid
 */
public class SpinningPyramid {

    static final int   WIDTH  = 60;
    static final int   HEIGHT = 30;
    static final float CAM_Z  = 14.0f;  // camera distance
    static final float FOV    = 20.0f;  // projection scale
    static final float S      = 2.6f;   // base half-size
    static final float H      = 2.8f;   // pyramid height (apex above base)
    static final int   STEPS  = 150;    // interpolation steps per edge

    //  Vertices:
    //   0-3  → base corners (counter-clockwise from above)
    //   4    → apex
    static final float[][] V = {
        { -S,  S/2,  -S },   // 0 back-left
        {  S,  S/2,  -S },   // 1 back-right
        {  S,  S/2,   S },   // 2 front-right
        { -S,  S/2,   S },   // 3 front-left
        {  0, -H,     0 },   // 4 apex (below centre)
    };

    //  8 edges
    static final int[][] E = {
        {0,1},{1,2},{2,3},{3,0},   // base square
        {0,4},{1,4},{2,4},{3,4},   // sides to apex
    };

    public static void main(String[] args) throws InterruptedException {

        float   A = 0.4f, B = 0.4f, C = 0f;
        char[]  screen = new char[WIDTH * HEIGHT];
        float[] zBuf   = new float[WIDTH * HEIGHT];

        System.out.print("\033[?25l\033[2J");

        Runtime.getRuntime().addShutdownHook(new Thread(() ->
            System.out.print("\033[?25h\033[2J\033[H")
        ));

        while (true) {

            for (int i = 0; i < WIDTH * HEIGHT; i++) {
                screen[i] = ' ';
                zBuf[i]   = 0f;
            }

            float sinA = (float)Math.sin(A), cosA = (float)Math.cos(A);
            float sinB = (float)Math.sin(B), cosB = (float)Math.cos(B);
            float sinC = (float)Math.sin(C), cosC = (float)Math.cos(C);

            for (int[] edge : E) {
                float[] p0 = V[edge[0]];
                float[] p1 = V[edge[1]];

                for (int s = 0; s <= STEPS; s++) {
                    float t = (float) s / STEPS;

                    float x = p0[0] + t * (p1[0] - p0[0]);
                    float y = p0[1] + t * (p1[1] - p0[1]);
                    float z = p0[2] + t * (p1[2] - p0[2]);

                    // Rotate X-axis
                    float y1 = y * cosA - z * sinA;
                    float z1 = y * sinA + z * cosA;
                    // Rotate Y-axis
                    float x2 =  x * cosB + z1 * sinB;
                    float z2 = -x * sinB + z1 * cosB;
                    // Rotate Z-axis
                    float x3 = x2 * cosC - y1 * sinC;
                    float y3 = x2 * sinC + y1 * cosC;

                    float zd = z2 + CAM_Z;
                    if (zd <= 0) continue;

                    float ooz = 1.0f / zd;

                    // Pick character by edge orientation for crispness
                    float dx = Math.abs(p1[0] - p0[0]);
                    float dy = Math.abs(p1[1] - p0[1]);
                    float dz = Math.abs(p1[2] - p0[2]);
                    char ch;
                    if (dy > dx && dy > dz)      ch = '|';   // steep vertical
                    else if (dx > dz)            ch = '-';   // horizontal base
                    else                         ch = '/';   // diagonal side

                    int xp = (int)(WIDTH  / 2 + FOV * ooz * x3 * 2.2f);
                    int yp = (int)(HEIGHT / 2 - FOV * ooz * y3);

                    if (xp < 1 || xp >= WIDTH-1 || yp < 1 || yp >= HEIGHT-1) continue;

                    int idx = xp + yp * WIDTH;
                    if (ooz > zBuf[idx]) {
                        zBuf[idx]  = ooz;
                        screen[idx] = ch;
                    }
                }
            }

            // Flush frame
            StringBuilder frame = new StringBuilder("\033[H");
            for (int row = 0; row < HEIGHT; row++) {
                for (int col = 0; col < WIDTH; col++) {
                    frame.append(screen[col + row * WIDTH]);
                }
                frame.append('\n');
            }
            System.out.print(frame);

            // Slow, smooth rotation — different speeds per axis
            A += 0.020f;
            B += 0.014f;
            C += 0.008f;

            Thread.sleep(28);
        }
    }
}
