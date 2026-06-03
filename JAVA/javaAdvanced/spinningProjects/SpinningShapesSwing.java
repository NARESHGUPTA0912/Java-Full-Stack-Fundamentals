package javaAdvanced.spinningProjects;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

/**
 * 3D Spinning Shapes Animation — Donut | Pyramid | Cube
 *
 * Run:  javac SpinningShapesSwing.java && java SpinningShapesSwing
 *
 * Uses Java Swing + 2D Graphics with:
 *   - 3D rotation (X and Y axes)
 *   - Perspective projection
 *   - Painter's algorithm (back-to-front face sorting)
 *   - Per-face depth shading
 */
public class SpinningShapesSwing extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SpinningShapesSwing().setVisible(true));
    }

    SpinningShapesSwing() {
        setTitle("3D Spinning Shapes — Donut | Pyramid | Cube");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(12, 12, 22));
        setLayout(new GridLayout(1, 3, 3, 3));

        add(new DonutPanel());
        add(new PyramidPanel());
        add(new CubePanel());

        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    // ── Base Panel ─────────────────────────────────────────────────────────────

    abstract static class Shape3DPanel extends JPanel {
        double aX = 0.3, aY = 0.0;   // current rotation angles
        final String label;

        Shape3DPanel(String label) {
            this.label = label;
            setPreferredSize(new Dimension(290, 340));
            setBackground(new Color(12, 12, 22));
            // 60 fps timer — increment angles and repaint
            new javax.swing.Timer(16, e -> {
                aX += 0.016;
                aY += 0.024;
                repaint();
            }).start();
        }

        /**
         * Rotate a 3D point by aX (around X-axis) then aY (around Y-axis).
         */
        double[] rot(double x, double y, double z) {
            // Rotate around X
            double ca = Math.cos(aX), sa = Math.sin(aX);
            double y2 = y * ca - z * sa;
            double z2 = y * sa + z * ca;
            // Rotate around Y
            double cb = Math.cos(aY), sb = Math.sin(aY);
            double x3 = x * cb + z2 * sb;
            double z3 = -x * sb + z2 * cb;
            return new double[]{x3, y2, z3};
        }

        /**
         * Perspective-project a 3D point to 2D screen coordinates.
         */
        int[] proj(double x, double y, double z) {
            double f = 195.0 / (z + 4.5);          // focal length / depth
            return new int[]{
                (int) (x * f) + getWidth()  / 2,
                (int) (-y * f) + getHeight() / 2    // flip Y (screen Y grows down)
            };
        }

        /** Average Z of a set of transformed vertices (used for depth sorting). */
        double avgZ(double[][] tv, int[] face) {
            double z = 0;
            for (int v : face) z += tv[v][2];
            return z / face.length;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            drawShape(g2);
            // Draw label at the bottom
            g2.setFont(new Font("Monospaced", Font.BOLD, 13));
            g2.setColor(new Color(170, 170, 210));
            FontMetrics fm = g2.getFontMetrics();
            g2.drawString(label, (getWidth() - fm.stringWidth(label)) / 2, getHeight() - 12);
        }

        abstract void drawShape(Graphics2D g2);
    }

    // ── Donut (Torus) ──────────────────────────────────────────────────────────

    static class DonutPanel extends Shape3DPanel {

        static final int   PHI_STEPS   = 50;   // segments around the ring
        static final int   THETA_STEPS = 26;   // segments around the tube
        static final double R1         = 1.00; // major radius (ring centre → tube centre)
        static final double R2         = 0.38; // minor radius (tube cross-section)

        DonutPanel() { super("DONUT"); }

        @Override
        void drawShape(Graphics2D g2) {
            // Pre-compute all transformed torus points
            double[][][] pts = new double[PHI_STEPS][THETA_STEPS][3];
            for (int i = 0; i < PHI_STEPS; i++) {
                double phi = 2 * Math.PI * i / PHI_STEPS;
                for (int j = 0; j < THETA_STEPS; j++) {
                    double theta = 2 * Math.PI * j / THETA_STEPS;
                    double px = (R1 + R2 * Math.cos(theta)) * Math.cos(phi);
                    double py = R2 * Math.sin(theta);
                    double pz = (R1 + R2 * Math.cos(theta)) * Math.sin(phi);
                    pts[i][j] = rot(px, py, pz);
                }
            }

            g2.setStroke(new BasicStroke(1.05f));

            for (int i = 0; i < PHI_STEPS; i++) {
                for (int j = 0; j < THETA_STEPS; j++) {
                    double[] p  = pts[i][j];
                    double[] pN = pts[(i + 1) % PHI_STEPS][j];              // next ring segment
                    double[] pM = pts[i][(j + 1) % THETA_STEPS];            // next tube segment

                    // Depth-based shading: z ∈ [-1.4, 1.4] → brightness [0.2, 1.0]
                    float t = (float) Math.min(1.0, (p[2] + 2.2) / 3.5);

                    // Orange → yellow gradient based on depth
                    g2.setColor(new Color(1.0f, t * 0.60f + 0.15f, 0.0f));

                    int[] s  = proj(p[0],  p[1],  p[2]);
                    int[] sN = proj(pN[0], pN[1], pN[2]);
                    int[] sM = proj(pM[0], pM[1], pM[2]);

                    g2.drawLine(s[0], s[1], sN[0], sN[1]);   // longitudinal edge
                    g2.drawLine(s[0], s[1], sM[0], sM[1]);   // latitudinal edge
                }
            }
        }
    }

    // ── Pyramid ────────────────────────────────────────────────────────────────

    static class PyramidPanel extends Shape3DPanel {

        // 4 base corners + 1 apex
        static final double[][] V = {
            {-1, -1, -1},   // 0 — base front-left
            { 1, -1, -1},   // 1 — base front-right
            { 1, -1,  1},   // 2 — base back-right
            {-1, -1,  1},   // 3 — base back-left
            { 0,  1.5, 0}   // 4 — apex
        };

        // Each face = indices into V (triangles for sides, quad for base)
        static final int[][] FACES = {
            {0, 1, 4},         // front face
            {1, 2, 4},         // right face
            {2, 3, 4},         // back face
            {3, 0, 4},         // left face
            {3, 2, 1, 0}       // base (quad)
        };

        static final Color[] FACE_COLORS = {
            new Color(255, 100,  50),
            new Color(255, 155,  75),
            new Color(200,  75,  35),
            new Color(175,  55,  25),
            new Color(255, 185,  60)
        };

        PyramidPanel() { super("PYRAMID"); }

        @Override
        void drawShape(Graphics2D g2) {
            // Transform all vertices
            double[][] tv = new double[V.length][3];
            for (int i = 0; i < V.length; i++) tv[i] = rot(V[i][0], V[i][1], V[i][2]);

            // Sort faces back-to-front (painter's algorithm)
            Integer[] order = new Integer[FACES.length];
            for (int i = 0; i < FACES.length; i++) order[i] = i;
            Arrays.sort(order, (a, b) -> Double.compare(avgZ(tv, FACES[a]), avgZ(tv, FACES[b])));

            for (int fi : order) {
                int[]  face = FACES[fi];
                int[]  xs   = new int[face.length];
                int[]  ys   = new int[face.length];
                double z    = avgZ(tv, face);

                for (int k = 0; k < face.length; k++) {
                    int[] p = proj(tv[face[k]][0], tv[face[k]][1], tv[face[k]][2]);
                    xs[k] = p[0];
                    ys[k] = p[1];
                }

                // Depth shading
                float  br   = (float) Math.min(1.0, (z + 2.5) / 4.2);
                Color  base = FACE_COLORS[fi];
                g2.setColor(new Color(
                    (int)(base.getRed()   * br),
                    (int)(base.getGreen() * br),
                    (int)(base.getBlue()  * br)
                ));
                g2.fillPolygon(xs, ys, face.length);

                // Edge outline
                g2.setColor(new Color(255, 255, 255, 110));
                g2.setStroke(new BasicStroke(1.2f));
                g2.drawPolygon(xs, ys, face.length);
            }
        }
    }

    // ── Cube ───────────────────────────────────────────────────────────────────

    static class CubePanel extends Shape3DPanel {

        static final double[][] V = {
            {-1, -1, -1}, { 1, -1, -1}, { 1,  1, -1}, {-1,  1, -1},   // front face (z=-1)
            {-1, -1,  1}, { 1, -1,  1}, { 1,  1,  1}, {-1,  1,  1}    // back  face (z=+1)
        };

        static final int[][] FACES = {
            {0, 1, 2, 3},   // front  (z = -1)
            {4, 5, 6, 7},   // back   (z = +1)
            {0, 1, 5, 4},   // bottom (y = -1)
            {3, 2, 6, 7},   // top    (y = +1)
            {0, 3, 7, 4},   // left   (x = -1)
            {1, 2, 6, 5}    // right  (x = +1)
        };

        static final Color[] FACE_COLORS = {
            new Color(220,  60,  60),   // front  — red
            new Color( 60, 200,  60),   // back   — green
            new Color( 60,  90, 210),   // bottom — blue
            new Color(220, 185,  50),   // top    — yellow
            new Color( 55, 195, 215),   // left   — cyan
            new Color(195,  60, 200)    // right  — magenta
        };

        CubePanel() { super("CUBE"); }

        @Override
        void drawShape(Graphics2D g2) {
            // Transform all vertices
            double[][] tv = new double[V.length][3];
            for (int i = 0; i < V.length; i++) tv[i] = rot(V[i][0], V[i][1], V[i][2]);

            // Sort faces back-to-front
            Integer[] order = new Integer[FACES.length];
            for (int i = 0; i < FACES.length; i++) order[i] = i;
            Arrays.sort(order, (a, b) -> Double.compare(avgZ(tv, FACES[a]), avgZ(tv, FACES[b])));

            for (int fi : order) {
                int[]  face = FACES[fi];
                int[]  xs   = new int[4];
                int[]  ys   = new int[4];
                double z    = avgZ(tv, face);

                for (int k = 0; k < 4; k++) {
                    int[] p = proj(tv[face[k]][0], tv[face[k]][1], tv[face[k]][2]);
                    xs[k] = p[0];
                    ys[k] = p[1];
                }

                // Depth shading
                float  br   = (float) Math.min(1.0, (z + 2.5) / 4.2);
                Color  base = FACE_COLORS[fi];
                g2.setColor(new Color(
                    (int)(base.getRed()   * br),
                    (int)(base.getGreen() * br),
                    (int)(base.getBlue()  * br)
                ));
                g2.fillPolygon(xs, ys, 4);

                // White edge outline
                g2.setColor(new Color(255, 255, 255, 200));
                g2.setStroke(new BasicStroke(1.4f));
                g2.drawPolygon(xs, ys, 4);
            }
        }
    }
}
