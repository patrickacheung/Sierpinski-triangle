/**
 * Sierpinski Triangle
 *
 * @author Patrick Cheung
 * @version 1.1
 */

import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Triangle extends JComponent
{
    private static final long serialVersionUID = 1L;
    private int level;
    private int width = TriangleViewer.getWidth();
    private int height;

    // Constructor with n levels
    public Triangle(int n)
    {
        level = n;

        // Get the dimensions of the window
        height = TriangleViewer.getHeight() - 50;
    }

    /**
     * Draws the triangle
     * @override paintComponent
     * @param g Graphics context
     */
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        //fill to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);

        //points based on size of window
        int pt1x = width/2;
        int pt2x = width;
        int pt3x = width - width;
        int pt1y = height - height;
        int pt2y = height;
        int pt3y = height;

        drawTriangles(g, level, pt1x, pt2x, pt3x, pt1y, pt2y, pt3y);
    } // paintComponent

    private void drawTriangles(Graphics g, int level, int p1x, int p2x, int p3x, int p1y, int p2y, int p3y)
    {
        if(level == 1)
        {
            Polygon p = new Polygon();
            p.addPoint(p1x, p1y);
            p.addPoint(p2x, p2y);
            p.addPoint(p3x, p3y);
            g.fillPolygon(p);
        }
        else
        {
            //determine midpoints
            int m1x = (p2x + p1x)/2;
            int m2x = (p2x + p3x)/2;
            int m3x = (p1x + p3x)/2;
            int m1y = (p2y + p1y)/2;
            int m2y = (p2y + p2y)/2;
            int m3y = (p3y + p1y)/2;

            //recursive draw
            drawTriangles(g, level - 1, p1x, m1x, m3x, p1y, m1y, m3y);
            drawTriangles(g, level - 1, m1x, p2x, m2x, m1y, p2y, m2y);
            drawTriangles(g, level - 1, m3x, m2x, p3x, m3y, m2y, p3y);
        }
    } //drawTriangles
} // Triangle
