import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

// implements KeyListener: Guarantees that KeyListenerDemo provides the
// keyTyped, keyReleased, and keyPressed methods
public class KeyListenerDemo implements KeyListener {
    public static final int BALL_START_RADIUS = 25,
                            BALL_START_X = 100,
                            BALL_START_Y = 100,
                            STEP_SIZE = 10;
    // Instance variables
    private Ball b;
    private KeyListenerDemoView window;

    // Constructors
    public KeyListenerDemo() {
        b = new Ball(BALL_START_X, BALL_START_Y, 0, 0, BALL_START_RADIUS, Color.BLUE);

        window = new KeyListenerDemoView(b);

        // The addKeyListener method attaches to this KeyListener object
        // an object that implements the KeyListener interface (i.e. supplies the keyTyped, keyReleased, and keyPressed methods)
        // By passsing the parameter "this"
        // we are saying that this specific KeyListenerDemo object
        // supplies its own KeyListener functionality (contains the 3 required KeyListener methods).
        window.addKeyListener(this);               // #4 Required for KeyListener
    }

    public static void main(String[] args) {
        KeyListenerDemo klDemo = new KeyListenerDemo();
    }

    //////////////////////////////////////////////////////////////
    /*
     * Methods all KeyListeners must supply
     */
    //////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // The keyCode lets you know which key was pressed
        switch(e.getKeyCode())
        {
            case KeyEvent.VK_LEFT:
                b.shiftX(-STEP_SIZE, 0, KeyListenerDemoView.SCREEN_WIDTH);
                break;
            case KeyEvent.VK_RIGHT:
                b.shiftX(STEP_SIZE, 0, KeyListenerDemoView.SCREEN_WIDTH);
                break;
            case KeyEvent.VK_UP:
                int topOfPane = window.getInsets().top;
                b.shiftY(-STEP_SIZE, topOfPane, KeyListenerDemoView.SCREEN_HEIGHT);
                break;
            case KeyEvent.VK_DOWN:
                b.shiftY(STEP_SIZE, 0, KeyListenerDemoView.SCREEN_HEIGHT);
                break;
            case KeyEvent.VK_Z:
                b.shiftX((int)((Math.random() * 400) - 200), 0 ,KeyListenerDemoView.SCREEN_WIDTH);
                b.shiftY((int)((Math.random() * 400) - 200),0, KeyListenerDemoView.SCREEN_HEIGHT);
                break;
            case KeyEvent.VK_S:
                b.setRadius(b.getRadius()/2);
                break;
            case KeyEvent.VK_B:
                b.setRadius(b.getRadius() * 2);
                break;
            case KeyEvent.VK_C:
                Color c = new Color((int) (Math.random() * 255), (int) (Math.random() * 255),(int) (Math.random() * 255));
                b.setColor(c);
                break;
        }
        window.repaint();
    }
}

