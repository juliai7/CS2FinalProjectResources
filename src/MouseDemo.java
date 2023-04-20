import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;               // # 1: Required for MouseListener and/or MouseMotionListener
import java.awt.event.MouseListener;            // # 2: Required for MouseListener
import java.awt.event.MouseMotionListener;      // # 3" Required for MouseMotionListener

import javax.swing.JFrame;

// implements MouseListener: guarantees this class provides the mousePressed, mouseReleased, mouseClicked, mouseEntered, mouseExited Methods
// implements MouseMotionListener: guarantees this class provides the mouseDragged and mouseMoved methods
public class MouseDemo extends JFrame implements MouseListener, MouseMotionListener     // # 4: implements required for Listeners
{
    // Instance Variables
    private Ball b;
    private Color[] colors = {Color.RED, Color.BLUE, Color.GREEN};
    private int clickNum;


    // Constructors
    public MouseDemo(int fWidth, int fHeight)
    {
        // Create a Ball with the 0 parameter constructor
        // Look at the Ball class to see how this constructor
        // initializes the Ball instance variables
        b = new Ball();
        clickNum = 0;

        // Initialize the User Interface
        setSize(fWidth, fHeight);
        setLocationRelativeTo(null);
        setTitle("Mouse Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // addMouseListener attaches a MouseListener object to MouseDemo
        // addMouseMotionListener attaches a MouseMotionListener object to MouseDemo
        // By passing "this" as the parameter, it makes this specific Instance
        // of MouseDemo its own MouseListener and its own MouseMotionListener
        addMouseListener(this);         // # 5: Required for MouseListeners
        addMouseMotionListener(this);   // # 6: Required for MouseMotionListeners

        setVisible(true);
    }

    // Methods
    public static void main(String[] args)
    {
        // Changing DEMO_WIDTH and DEMO_HEIGHT gives you the ability
        // to change the size of the JFrame that hosts the demo
        final int DEMO_WIDTH = 700;
        final int DEMO_HEIGHT = 500;
        MouseDemo md = new MouseDemo(DEMO_WIDTH, DEMO_HEIGHT);
    }

    @Override
    public void paint(Graphics g)
    {
        // Configuration constants
        // Used to configure the location of the information box
        // and the Strings inside of it
        // These values can be changed to alter the information box
        // and the Strings inside of it
        final int INFO_RECT_TOP_LEFT_X = 85;
        final int INFO_RECT_TOP_LEFT_Y = 85;
        final int INFO_RECT_WIDTH = 220;
        final int INFO_RECT_HEIGHT = 60;
        final int INFO_STR_X = 100;
        final int INFO_STR_1_Y = 100;
        final int INFO_STR_2_Y = 120;
        final int INFO_STR_3_Y = 140;

        // Note: The Graphics object g keeps track of the "state" of several attributes
        // In this case, note that it always has a current value for its Color
        // First, set the Color to LIGHT_GRAY to draw the background
        // Next, set the Color to WHITE to draw the information box
        // Finally, set the Color to BLACK to draw the information strings

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

    /********************************************
     MouseListener event handlers - BEGIN
     ********************************************/

    @Override
    // # 7: Required of a MouseListener
    public void mousePressed(MouseEvent e)
    {
        // Change the color
        clickNum++;
        b.setColor(colors[clickNum % 3]);

        repaint();

        // For demo purposes only
        System.out.println("mousePressed event handler executed.");
    }

    @Override
    // # 8: Required of a MouseListener
    public void mouseReleased(MouseEvent e)
    {
        // For demo purposes only
        System.out.println("mouseReleased event handler executed.");
    }

    @Override
    // # 9: Required of a MouseListener
    public void mouseClicked(MouseEvent e)
    {
        // For demo purposes only
        System.out.printf("mouseClicked event handler executed for click number: %d\n",
                clickNum);
    }

    @Override
    // # 10: Required of a MouseListener
    public void mouseEntered(MouseEvent e)
    {
        // For demo purposes only
        System.out.println("mouseEntered event handler executed.");
    }

    @Override
    // # 11: Required of a MouseListener
    public void mouseExited(MouseEvent e)
    {
        // For demo purposes only
        System.out.println("mouseExited event handler executed.");
    }

    /********************************************
     MouseListener event handlers - END
     ********************************************/

    /********************************************
     MouseMotionListener event handlers - BEGIN
     ********************************************/

    @Override
    // # 12: Required of a MouseMotionListener
    public void mouseDragged(MouseEvent e)
    {
        // Have the ball follow the dragging mouse
        // Print to terminal for demo purposes only
        System.out.println("\t\t\texecuting mouseDragged event handler");

        // Ask the input event the current location (x and y position on the Frame) of the mouse
        int x = e.getX();
        int y = e.getY();

        // Move the ball
        b.setCenter(x, y);

        // Repaint, leads to the system calling MouseDemo.paint()
        repaint();
    }

    @Override
    // #13: Required of a MouseMotionListener
    public void mouseMoved(MouseEvent e)
    {
        // For demo purposes only
        System.out.println("\t\t\texecuting mouseMoved event handler");
    }

    /********************************************
     MouseMotionListener event handlers - END
     ********************************************/
}
