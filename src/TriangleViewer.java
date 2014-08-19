/**
 * Sierpinski Triangle
 *
 * Prompts user for number of levels and displays the 
 * Sierpinski Triangle
 *
 * @author Patrick Cheung
 * @version 1.0
 */

import javax.swing.*;
import java.awt.Dimension;

public class TriangleViewer
{
    private static final int FRAME_HEIGHT = 600;
    private static final int FRAME_WIDTH = 600;

    public static void main(String[] args)
    {
        String levels = JOptionPane.showInputDialog("Enter level to display: ");
        int n;

        if(levels.length() == 0 || levels == null || levels.equals("0"))
            n = 1;
        else
            n = Integer.parseInt(levels);

        Triangle triangle;
        triangle = new Triangle(n);
        // Create the JFrame and Triangle
        JFrame frame = new JFrame();
        //JPanel panel = new JPanel(); // JPanel for the content to be actually this size

        // Some magical stuff
        // http://stackoverflow.com/questions/6593322/why-does-the-jframe-setsize-method-not-set-the-size-correctly
        //panel.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        //panel.add(triangle);
        //panel.setVisible(true);
        //frame.getContentPane().add(panel);
        //frame.pack();

        // Set the dimensions
        Dimension d = new Dimension(FRAME_WIDTH, FRAME_HEIGHT);

        // Set the dimension of content area ONLY and use setPreferredSize
        frame.getContentPane().setPreferredSize(d);

        // Sets the frame to abs min to fulfill setPreferredSize
        frame.pack();
        frame.setTitle("Sierpinksi Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(triangle);
        frame.setVisible(true);
    } //main

    /**
     * Returns the height of the frame
     * @return Height of the frame
     */
    public static int getHeight()
    {
        return FRAME_HEIGHT;
    } //getHeight

    /**
     * Returns the width of the frame
     * @return Width of the frame
     */
    public static int getWidth()
    {
        return FRAME_WIDTH;
    } //getWidth
} //TriangleViewer
