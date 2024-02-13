import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
/******************************************************************************
 *
 * MouseMotionDemo & MouseMotionDemoView
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * Example of how to get your program to follow the mouse, even when you DON'T click
 *
 *****************************************************************************/
public class MouseMotionDemoView extends JFrame {

    private static final int WINDOW_WIDTH = 700,
                            WINDOW_HEIGHT = 500,
                            CIRCLE_RADIUS = 20;

    private MouseMotionDemo m;

    public MouseMotionDemoView(MouseMotionDemo m) {
        this.m = m;
        this.setTitle("FOLLOW ME!");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.createBufferStrategy(2);
    }

    public void paint(Graphics g)
    {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;

        Graphics g2 = null;

        try {
            g2 = bf.getDrawGraphics();

            // myPaint does the actual drawing
            myPaint(g2);
        }
        finally {
            // It is best to dispose() a Graphics object when done with it.
            g2.dispose();
        }

        // Shows the contents of the backbuffer on the screen.
        bf.show();

        // Tell the System to do the Drawing now, otherwise it can take a few extra ms until
        // Drawing is done which looks very jerky
        Toolkit.getDefaultToolkit().sync();
    }

    public void myPaint(Graphics g)
    {
        // Clear the window.
        g.setColor(Color.white);
        g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        // Draw the circle
        g.setColor(m.getCircleColor());
        g.drawOval(m.getCircleCenterX() - CIRCLE_RADIUS, m.getCircleCenterY() - CIRCLE_RADIUS, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);

    }
}
