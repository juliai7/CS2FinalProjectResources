import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;             // #1: Required for KeyListener
import java.awt.event.KeyListener;          // #2: Required for KeyListener

import javax.swing.JFrame;

// import java.util.Random;                 // You might want this when implementing
// the ability to jump to random locations


/******************************************************************************
 * KeyListenerDemo.java
 *
 *  WHAT DOES THIS PROGRAM DO?
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
 *
 *  -public void setNewLocation(int newX, int newY) // moves the ball to the new location
 *
 *  -public void getBigger() // makes the ball bigger by multiplying the radius by a factor of 2
 *
 *  -public void getSmaller() // makes the ball smaller by multiplying its radius by a factor of 1/2
 *
 *  -public void changeColor() // generates a random color and sets it to be the color of the ball
 *
 *
 ***************************************************************************
 *
 *  EXTRAS:
 *  - When the user presses left/right/up/down, make sure the ball can go all the way
 *      to touch the edge of the screen, but no further. (Hint: this feature is very
 *      similar to your Prog 13 - Moving Icon!  Go steal code from there!)
 *
 *  - Be sure the ball never completely disappears by establishing a MINIMUM_RADIUS.
 *
 *  - Allow the user to make the ball as large as possible, while never going off screen.
 *      So, if the user presses 'b' and there's no room to double the diameter,
 *      make the ball JUST big enough to touch the edge of the screen.
 *
 * **************************************************************************
 *
 * Note: comments #1-7 in the program are the lines of code that would be
 *        necessary to implement a keyListener in another program.
 *
 *****************************************************************************/

// implements KeyListener: Guarantees that KeyListenerDemo provides the
// keyTyped, keyReleased, and keyPressed methods
public class KeyListenerDemo extends JFrame implements KeyListener      // #3 Required for KeyListener
{
    // Instance variables
    public static int SCREEN_WIDTH = 1000;
    public static int SCREEN_HEIGHT = 800;

    private Ball b;
    private int stepSize;

    // Constructors
    public KeyListenerDemo(int ballStartX, int ballStartY, int ballVelX, int ballVelY,
                           int ballStartRadius, Color ballColor, int stepSize)
    {
        b = new Ball(ballStartX, ballStartY, ballVelX, ballVelY, ballStartRadius, ballColor);
        this.stepSize = stepSize;

        // User Interface initialization
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocationRelativeTo(null);
        setTitle("Key Listener Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The addKeyListener method attaches to this KeyListener object
        // an object that implements the KeyListener interface (i.e. supplies the keyTyped, keyReleased, and keyPressed methods)
        // By passsing the parameter "this"
        // we are saying that this specific KeyListenerDemo object
        // supplies its own KeyListener functionality (contains the 3 required KeyListener methods).
        addKeyListener(this);               // #4 Required for KeyListener

        setVisible(true);
    }


    // Methods

    public static void main(String[] args)
    {
        final int BALL_START_RADIUS = 25;
        final int BALL_START_X = 100;
        final int BALL_START_Y = 100;
        final int STEP_SIZE = 10;

        KeyListenerDemo klDemo = new KeyListenerDemo(BALL_START_X, BALL_START_Y, 0, 0, BALL_START_RADIUS, Color.BLUE,
                STEP_SIZE);
    }

    /*
     * KeyListenerDemo's paint method.  Called by the runtime environment in response to repaint()
     * and in response to the system determining this JFrame needs to be painted (updated) for presentation
     */
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

    //////////////////////////////////////////////////////////////
    /*
     * Methods all KeyListeners must supply
     */
    //////////////////////////////////////////////////////////////
    @Override
    public void keyTyped(KeyEvent e)                // #5 Required for KeyListener
    {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyReleased(KeyEvent e)             // #6 Required for KeyListener
    {
        // Nothing required for this program.
        // However, as a KeyListener, this class must supply this method
    }

    @Override
    public void keyPressed(KeyEvent e)              // #7 Required for KeyListener
    {
        // The keyCode lets you know which key was pressed
        int keyCode = e.getKeyCode();

        if(keyCode == KeyEvent.VK_LEFT)
        {
            b.shiftX(-stepSize, 0, SCREEN_WIDTH);
        }
        else if(keyCode == KeyEvent.VK_RIGHT)
        {
            b.shiftX(stepSize, 0, SCREEN_WIDTH);
        }
        else if(keyCode == KeyEvent.VK_UP)
        {
            int topOfPane = getInsets().top;    // This just identifies where the title bar ends and the usable area starts
            b.shiftY(-stepSize, topOfPane, SCREEN_HEIGHT);
        }
        else if(keyCode == KeyEvent.VK_DOWN)
        {
            b.shiftY(stepSize, 0, SCREEN_HEIGHT);
        }
        // Add new else if clauses for additional keyCodes(such as VK_B, VK_C, VK_S, and VK_Z)

        // Items that might help with your implementation tasks
        //Random gen = new Random(System.currentTimeMillis());          // You will want this to implement random ball movement

        /*
        // You might want this array to help implement changing the color of the ball
        Color[] stdCols = {Color.black, Color.BLUE, Color.CYAN,
                    Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY,
                    Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED,
                    Color.WHITE, Color.YELLOW};
        */

        repaint();
    }
    //////////////////////////////////////////////////////////////
    /*
     * End of Methods all KeyListeners must supply
     */
    //////////////////////////////////////////////////////////////

    /*
     * Extras -- If you are implementing extras, you can place any private helper methods here
     */

}

