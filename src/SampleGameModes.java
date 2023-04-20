import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;			

/******************************************************************************
 * 
 * SampleGameModes.java
 * Example of how to create different "states" of the game.
 * 
 *****************************************************************************/
public class SampleGameModes extends JFrame
implements ActionListener, KeyListener
{
	private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 500;
	private static final int TOP_OF_WINDOW = 23;
	private static final int DELAY_IN_MILLISEC = 20;
	
	private static final int WELCOME_SCREEN = 37;
	private static final int PLAYING = 12;
	private static final int GAME_OVER = 56;
	
	private static int state = WELCOME_SCREEN; // state of the game
	
	private static int lives = 3; // let's imagine you start with 3 lives


	/**
	 * MAIN METHOD -----------------
	 * @param args
	 */
	public static void main(String args[])
	{

		// Set up the window
		SampleGameModes window = new SampleGameModes();
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setVisible(true);  
		window.createBufferStrategy(2);
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Register the Key Listener
		window.addKeyListener(window);


		Timer clock= new Timer(DELAY_IN_MILLISEC, window);			
		clock.start();							

	}

	// this method gets called again and again, every 20 miliseconds
	// animation things happen here
	public void actionPerformed(ActionEvent e)
	{
		if (state == WELCOME_SCREEN)
		{

		}
		else if (state == PLAYING)
		{
			// b.move();
			// maybe a for loop	
			// other stuff

		
		}
		else if (state == GAME_OVER)
		{

		}

		

		repaint();
	}
	
	public void keyTyped(KeyEvent e) 
	{
		
		
	}


	public void keyPressed(KeyEvent e) 
	{
		if (state == WELCOME_SCREEN)
		{
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				state = PLAYING;
			}

		}
		else if (state == PLAYING)
		{
			// if they presss up, you move the space ship up 
			// etc
			// if they press space, you shoot a bullet
			
			// let's imagine they lose the game if they press the 'l' key
			if (e.getKeyCode() == KeyEvent.VK_L)
			{
				state = GAME_OVER;
			}

		
		}
		else if (state == GAME_OVER)
		{
			if (e.getKeyCode() == KeyEvent.VK_T)
			{
				state = WELCOME_SCREEN;
				lives = 3; // reset the game;
			}
		}
		
	}


	public void keyReleased(KeyEvent e) 
	{

		
	}



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
		if (state == WELCOME_SCREEN)
		{
			g.setColor(Color.black);
			g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			g.setColor(Color.GREEN);
			g.drawString("Welcome.  Press SPACE to play.", 100, 300);
		}
		else if (state == PLAYING)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			// all the drawing you'd usually do in the game... do it here
			g.setColor(Color.red);
			g.fillOval(100, 200, 50, 50);
		
		}
		else if (state == GAME_OVER)
		{
			g.setColor(Color.blue);
			g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			g.setColor(Color.WHITE);
			g.drawString("Game over.  Press 't' to play again.", 100, 300);
		}

		
	}




} 


