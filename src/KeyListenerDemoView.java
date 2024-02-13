import javax.swing.*;
import java.awt.*;
/**
 * KeyListenerDemo & KeyListenerDemoView
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * WHAT DOES THIS PROGRAM DO?
 *
 *      This program demonstrates how to use keyboard input in java programs.
 *      If you run this program right now, you will create a graphics window
 *      with a blue ball in it. You, as the user, will be able to move the
 *      ball by tapping on the up/down/right/left keys. This works because
 *      the program uses a KeyListener!
 *
 *  YOUR JOB:
 *      Modify this program by adding a few more keystroke commands:
 *
 *      Command:    Key Code:       Description:
 *      z           VK_Z            - Cause the ball to jump to a random new location.
 *      s           VK_S            - Make the ball smaller - multiply its diameter 1/2.
 *      b           VK_B            - Make the ball bigger - multiply its diameter by 2.
 *      c           VK_C            - Change the color (in any way you'd like).
 *
 *  To make these new commands work, you will need to modify two things:
 *      1. the keyPressed() method
 *      2. the Ball Class — you need to add the following new methods to the Ball class:
 *          -public void setNewLocation(int newX, int newY)
 *          -public void getBigger()
 *          -public void getSmaller()
 *          -public void changeColor()
 ***************************************************************************
 *  EXTRAS:
 *  - Be sure the ball never completely disappears by establishing a MINIMUM_RADIUS.
 *  - Allow the user to make the ball as large as possible, while never going off screen.
 *      So, if the user presses 'b' and there's no room to double the diameter,
 *      make the ball JUST big enough to touch the edge of the screen.
 */
public class KeyListenerDemoView extends JFrame {

    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;

    private Ball b;

    public KeyListenerDemoView(Ball b) {
        this.b = b;

        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setLocationRelativeTo(null);
        this.setTitle("Key Listener Demo");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void paint(Graphics g)
    {
        // Color the entire KeyListenerDemo window white
        // First set the Graphics Color "state" to WHITE
        g.setColor(Color.WHITE);

        // Because g.Color was set to WHITE, the rectangle will be WHITE
        g.fillRect(0,  0, SCREEN_WIDTH, SCREEN_HEIGHT);

        // Now have the ball draw itself on top of the White window.
        b.draw(g);
    }
}
