
import javax.swing.*;
import java.awt.*;

/**
 * MouseDemo and MouseDemoView
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * This demo implements the MouseListener and MouseMotionListener interfaces. The front-end listens for the
 * mouse events, which in turn call the methods that are implemented in the back-end.
 */

public class MouseDemoView extends JFrame {


    public static final int DEMO_WIDTH = 700;
    public static final int DEMO_HEIGHT = 500;

    // Configuration constants: Used to configure the location of the information box and the Strings inside of it.
    public static final int INFO_RECT_TOP_LEFT_X = 85;
    public static final int INFO_RECT_TOP_LEFT_Y = 85;
    public static final int INFO_RECT_WIDTH = 220;
    public static final int INFO_RECT_HEIGHT = 60;
    public static final int INFO_STR_X = 100;
    public static final int INFO_STR_1_Y = 100;
    public static final int INFO_STR_2_Y = 120;
    public static final int INFO_STR_3_Y = 140;

    private Ball b;

    public MouseDemoView(Ball b) {
        this. b = b;

        this.setSize(DEMO_WIDTH, DEMO_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Mouse Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g)
    {
        // Set the background of the Frame to LIGHT_GRAY
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, getInsets().top, getWidth(), getHeight());
        // Note: getInsets().top just finds where the Title Bar ends and the usable area starts

        // Set the Color of the information box to WHITE
        g.setColor(Color.WHITE);
        g.fillRect(INFO_RECT_TOP_LEFT_X, INFO_RECT_TOP_LEFT_Y,
                INFO_RECT_WIDTH, INFO_RECT_HEIGHT);

        // Set the Color of information Strings to Black
        g.setColor(Color.BLACK);

        // Draw the Strings onto the Frame (inside of the information box)
        g.drawString("\tBall center is at [" + b.getX() + ", " + b.getY() + "]",
                INFO_STR_X, INFO_STR_1_Y);
        g.drawString("Click to change ball color", INFO_STR_X, INFO_STR_2_Y);
        g.drawString("Click and drag to move the ball.", INFO_STR_X, INFO_STR_3_Y);

        // Have the ball draw itself
        b.draw(g);
    }
}
