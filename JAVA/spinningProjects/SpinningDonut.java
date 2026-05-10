package spinningProjects;

/**
 * Spinning Donut Animation in Java
 *
 * Renders a 3D ASCII torus rotating in the terminal.
 * Based on Andy Sloane's classic donut.c algorithm.
 *
 * Run with: javac SpinningDonut.java && java SpinningDonut
 */
public class SpinningDonut {

    // Screen dimensions
    static final int WIDTH  = 80;
    static final int HEIGHT = 24;

    // Luminance characters from darkest to brightest
    static final char[] LUMINANCE = ".,-~:;=!*#$@".toCharArray();

    public static void main(String[] args) throws InterruptedException {

        double A = 0, B = 0; // rotation angles around X and Z axes

        char[]   screen = new char[WIDTH * HEIGHT];
        double[] zBuffer = new double[WIDTH * HEIGHT];

        // Hide cursor (ANSI escape) and clear screen
        System.out.print("\033[?25l");
        System.out.print("\033[2J");

        // Add shutdown hook to restore cursor
        Runtime.getRuntime().addShutdownHook(new Thread(() ->
            System.out.print("\033[?25h\033[0m\n")
        ));

        while (true) {
            // Clear buffers
            for (int i = 0; i < WIDTH * HEIGHT; i++) {
                screen[i]  = ' ';
                zBuffer[i] = 0;
            }

            // Precompute sines and cosines of rotation angles
            double sinA = Math.sin(A), cosA = Math.cos(A);
            double sinB = Math.sin(B), cosB = Math.cos(B);

            // Sweep over the torus surface
            // theta: angle around the tube cross-section circle
            // phi:   angle around the central axis of the torus
            for (double theta = 0; theta < 2 * Math.PI; theta += 0.07) {
                double sinTheta = Math.sin(theta);
                double cosTheta = Math.cos(theta);

                for (double phi = 0; phi < 2 * Math.PI; phi += 0.02) {
                    double sinPhi = Math.sin(phi);
                    double cosPhi = Math.cos(phi);

                    // Circle in the XZ plane: R2 + R1*cos(theta)
                    double circleX = 2 + cosTheta;   // R2=2, R1=1
                    double circleY = sinTheta;

                    // 3-D rotation
                    // x' = circleX*(cosB*cosPhi + sinA*sinB*sinPhi) - circleY*cosA*sinB
                    // y' = circleX*(sinB*cosPhi - sinA*cosB*sinPhi) + circleY*cosA*cosB
                    // z' = cosA*circleX*sinPhi + circleY*sinA
                    double x = circleX * (cosB * cosPhi + sinA * sinB * sinPhi)
                             - circleY * cosA * sinB;
                    double y = circleX * (sinB * cosPhi - sinA * cosB * sinPhi)
                             + circleY * cosA * cosB;
                    double z = 5 + cosA * circleX * sinPhi + circleY * sinA; // offset z=5 (away from camera)
                    double ooz = 1.0 / z; // one-over-z for perspective

                    // Project onto 2-D screen (centre at WIDTH/2, HEIGHT/2)
                    int xp = (int) (WIDTH  / 2 + 30 * ooz * x);
                    int yp = (int) (HEIGHT / 2 - 15 * ooz * y); // y flipped

                    // Bounds check
                    if (xp < 0 || xp >= WIDTH || yp < 0 || yp >= HEIGHT) continue;

                    // Luminance: dot product of surface normal with light direction (0,1,-1)
                    double lum = cosPhi * cosTheta * sinB
                               - cosA  * cosTheta * sinPhi
                               - sinA  * sinTheta
                               + cosB  * (cosA * sinTheta - cosTheta * sinA * sinPhi);

                    int idx = xp + yp * WIDTH;

                    if (ooz > zBuffer[idx]) { // z-buffer test
                        zBuffer[idx] = ooz;
                        int lumIdx = (int) (lum * 8);
                        screen[idx] = lumIdx > 0
                            ? LUMINANCE[Math.min(lumIdx, LUMINANCE.length - 1)]
                            : '.';
                    }
                }
            }

            // Render frame: move cursor to top-left, then print the screen buffer
            StringBuilder frame = new StringBuilder("\033[H"); // cursor home
            for (int j = 0; j < HEIGHT; j++) {
                for (int i = 0; i < WIDTH; i++) {
                    frame.append(screen[i + j * WIDTH]);
                }
                frame.append('\n');
            }
            System.out.print(frame);

            // Advance rotation angles
            A += 0.04;
            B += 0.02;

            Thread.sleep(30); // ~33 fps
        }
    }
}