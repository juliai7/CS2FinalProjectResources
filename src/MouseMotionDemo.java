import java.awt.*;
import java.awt.event.*;
/******************************************************************************
 * 
 * MouseMotionDemo & MouseMotionDemoView
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * Example of how to get your program to follow the mouse, even when you DON'T click
 * 
 *****************************************************************************/
public class MouseMotionDemo implements MouseListener, MouseMotionListener {

	private int circleCenterX;
	private int circleCenterY;
	
	private Color circleColor;
	private MouseMotionDemoView window;

	public MouseMotionDemo() {

		this.circleCenterX = 0;
		this.circleCenterY = 0;
		this.circleColor = Color.BLUE;
		window = new MouseMotionDemoView(this);

		// Register the Mouse Listener and Mouse Motion Listener
		window.addMouseListener(this);
		window.addMouseMotionListener(this);
	}

	public static void main(String args[]) {
		MouseMotionDemo window = new MouseMotionDemo();
	}

	public void mousePressed(MouseEvent e) {
		// Make the circle green whenever you press the mouse. 
		circleColor = Color.GREEN;
		window.repaint();
	}

	public void mouseReleased(MouseEvent e) {
		// Make the circle blue whenever you let go of the mouse
		circleColor = Color.BLUE;
		window.repaint();
	}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	// This method gets called every time you click and drag
	public void mouseDragged(MouseEvent e) {
		
		// Find out where the mouse is
		int xMouse = e.getX();
		int yMouse = e.getY();

		// Update the location of the circle so that it follows the mouse
		circleCenterX = xMouse;
		circleCenterY = yMouse;

		window.repaint();
	}

	// This method gets called everytime you move the mouse, EVEN IF YOU DON'T CLICK
	public void mouseMoved(MouseEvent e) {
		
		// Find out where the mouse is
		int xMouse = e.getX();
		int yMouse = e.getY();
		
		// Update the location of the circle so that it follows the mouse
		circleCenterX = xMouse;
		circleCenterY = yMouse;
		
		// Update the screen
		window.repaint();
	}

	public int getCircleCenterX() {
		return circleCenterX;
	}

	public int getCircleCenterY() {
		return circleCenterY;
	}

	public Color getCircleColor() {
		return circleColor;
	}
}