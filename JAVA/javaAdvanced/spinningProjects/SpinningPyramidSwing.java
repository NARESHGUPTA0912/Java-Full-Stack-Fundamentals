package javaAdvanced.spinningProjects;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SpinningPyramidSwing extends JPanel implements ActionListener {

    // Pyramid vertices
    double[][] vertices = {
            {0, -100, 0},     // Top
            {-100, 100, -100}, // Front-left
            {100, 100, -100},  // Front-right
            {100, 100, 100},   // Back-right
            {-100, 100, 100}   // Back-left
    };

    // Pyramid edges
    int[][] edges = {
            {0,1}, {0,2}, {0,3}, {0,4},
            {1,2}, {2,3}, {3,4}, {4,1}
    };

    double angle = 0;

    Timer timer;

    public SpinningPyramidSwing() {
        timer = new Timer(16, this); // ~60 FPS
        timer.start();
        setBackground(Color.BLACK);
    }

    // Rotate Y-axis
    private double[] rotateY(double x, double y, double z, double angle) {
        double newX = x * Math.cos(angle) - z * Math.sin(angle);
        double newZ = x * Math.sin(angle) + z * Math.cos(angle);
        return new double[]{newX, y, newZ};
    }

    // Perspective projection
    private Point project(double x, double y, double z) {
        double distance = 400;
        double scale = distance / (distance + z);

        int projectedX = (int)(x * scale) + getWidth() / 2;
        int projectedY = (int)(y * scale) + getHeight() / 2;

        return new Point(projectedX, projectedY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.CYAN);
        g2.setStroke(new BasicStroke(2));

        Point[] points = new Point[vertices.length];

        // Rotate + project vertices
        for (int i = 0; i < vertices.length; i++) {

            double[] rotated = rotateY(
                    vertices[i][0],
                    vertices[i][1],
                    vertices[i][2],
                    angle
            );

            points[i] = project(rotated[0], rotated[1], rotated[2]);
        }

        // Draw edges
        for (int[] edge : edges) {
            Point p1 = points[edge[0]];
            Point p2 = points[edge[1]];

            g2.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        angle += 0.02;
        repaint();
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("3D Spinning Pyramid");

        SpinningPyramidSwing panel = new SpinningPyramidSwing();

        frame.add(panel);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}