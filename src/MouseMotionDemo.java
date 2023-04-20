import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;				// NEW A

/******************************************************************************
 * 
 * MouseMotionDemo.java
 * Example of how to get your program to follow the mouse, even when you DON'T click
 * 
 *****************************************************************************/
public class MouseMotionDemo extends JFrame
implements MouseListener, MouseMotionListener
{
	private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 500;
	private static final int TOP_OF_WINDOW = 23;
	private static final int DELAY_IN_MILLISEC = 20;

	private static final int CIRCLE_RADIUS = 20;
	
	private static int circleCenterX = 0;
	private static int circleCenterY = 0;
	
	private static Color circleColor = Color.blue;




	/**
	 * MAIN METHOD -----------------
	 * @param args
	 */
	public static void main(String args[])
	{

		// Set up the window
		MouseMotionDemo window = new MouseMotionDemo();
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setVisible(true);  
		window.createBufferStrategy(2);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);
		window.repaint();

		
		// in your main() method, make sure to "turn on" mouse listener and mouse motion listener!!
		
		// Register the Mouse Listener and Mouse Motion Listener
		window.addMouseListener(window);
		window.addMouseMotionListener(window);

	}


	/********************************************
	   MouseListener methods

	   (These are the special methods you need
	    whenever you implement MouseListener)
	 ********************************************/	

	public void mousePressed(MouseEvent e)
	{
		// Make the circle green whenever you press the mouse. 
		circleColor = Color.GREEN;
		
		repaint();
	}


	public void mouseReleased(MouseEvent e)
	{
		// Make the circle blue whenever you let go of the mouse
		circleColor = Color.BLUE;
		repaint();
	}


	public void mouseClicked(MouseEvent e)
	{

	}


	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}



	/********************************************
	   MouseMotionListener methods
	   
	   
	   (These are the special methods you need
	    whenever you implement MouseMotionListener)
	 ********************************************/	

	public void mouseDragged(MouseEvent e) { // this method gets called every time you click and drag
		
		// find out where the mouse is
		int xMouse = e.getX();
		int yMouse = e.getY();
		
		// update the location of the circle so that it follows the mouse
		circleCenterX = xMouse;
		circleCenterY = yMouse;
		
		repaint();
		
	}

	public void mouseMoved(MouseEvent e) { // this method gets called everytime you move the mouse
											// EVEN IF YOU DON'T CLICK
		
		// find out where the mouse is
		int xMouse = e.getX();
		int yMouse = e.getY();
		
		// update the location of the circle so that it follows the mouse
		circleCenterX = xMouse;
		circleCenterY = yMouse;
		
		// in your code, do some calculation
		// example: 
		// ship.updateCannonAngle(xMouse, yMouse);
		// ship.updateX(xMouse);
		
		
		// update the screen
		repaint();

		
	}
	
	
	
	
	/********************************************
	   Graphics methods
	 ********************************************/	

	
	/**
	 * paint 		draw the window					// NEW C - Insert exactly this method
	 * 
	 * @param g		Graphics object to draw on - which we won't use
	 */
	public void paint(Graphics g)
	{
		BufferStrategy bf = this.getBufferStrategy();
		if (bf == null)
			return;

		Graphics g2 = null;

		try 
		{
			g2 = bf.getDrawGraphics();

			// myPaint does the actual drawing
			myPaint(g2);
		} 
		finally 
		{
			// It is best to dispose() a Graphics object when done with it.
			g2.dispose();
		}

		// Shows the contents of the backbuffer on the screen.
		bf.show();

		//Tell the System to do the Drawing now, otherwise it can take a few extra ms until 
		//Drawing is done which looks very jerky
		Toolkit.getDefaultToolkit().sync();	
	}



	public void myPaint(Graphics g)
	{
		// Clear the window.
		g.setColor(Color.white);
		g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		
		// calculate the circle corner
		int circleCornerX = circleCenterX - CIRCLE_RADIUS;
		int circleCornerY = circleCenterY - CIRCLE_RADIUS;
		
		// draw the circle
		g.setColor(circleColor);
		g.drawOval(circleCornerX, circleCornerY, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);

	}


} 


