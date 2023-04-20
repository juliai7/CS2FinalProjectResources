import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;			

/******************************************************************************
 * 
 * OnePlayerTwoPlayer.java
 * Example of how to create different "states" of the game.
 * 
 *****************************************************************************/
public class OnePlayerTwoPlayer extends JFrame
implements ActionListener, KeyListener
{
	private static final int WINDOW_WIDTH = 700;
	private static final int WINDOW_HEIGHT = 500;
	private static final int TOP_OF_WINDOW = 23;
	private static final int DELAY_IN_MILLISEC = 20;
	
	private static final int WELCOME_SCREEN = 37;
	private static final int ONE_PLAYER = 12;
	private static final int TWO_PLAYER = 40;
	private static final int GAME_OVER_ONE_PLAYER = 56;
	private static final int GAME_OVER_RED_WINS = 9;
	private static final int GAME_OVER_BLUE_WINS = 10;
	
	private static int state = WELCOME_SCREEN; // state of the game
	
	private static int lives = 3; // let's imagine you start with 3 lives


	/**
	 * MAIN METHOD -----------------
	 * @param args
	 */
	public static void main(String args[])
	{

		// Set up the window
		OnePlayerTwoPlayer window = new OnePlayerTwoPlayer();
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
		else if (state == ONE_PLAYER)
		{
			// all animation code for my one-player version

		
		}
		else if (state == TWO_PLAYER)
		{
			// all animation code for my two-player version
			
			// (animation code = the code you typically put in actionPerformed())
			
		}
		else if (state == GAME_OVER_ONE_PLAYER)
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
			if (e.getKeyCode() == KeyEvent.VK_1)
			{
				state = ONE_PLAYER;
			}
			else if (e.getKeyCode() == KeyEvent.VK_2)
			{
				state = TWO_PLAYER;
			}

		}
		else if (state == ONE_PLAYER)
		{
			// all keyboard-related code for your one-player game would go in here
			
			// let's imagine they lose the game if they press the 'l' key
			if (e.getKeyCode() == KeyEvent.VK_L)
			{
				state = GAME_OVER_ONE_PLAYER;
			}
		}
		else if (state == TWO_PLAYER)
		{
			// all keyboard-related code for your two-player game would go in here
			
			// let's imagine they lose the game if they press the 'l' key
			if (e.getKeyCode() == KeyEvent.VK_K)
			{
				state = GAME_OVER_RED_WINS;
			}
			else if (e.getKeyCode() == KeyEvent.VK_F)
			{
				state = GAME_OVER_BLUE_WINS;
			}
		}
		else if (state == GAME_OVER_ONE_PLAYER || state == GAME_OVER_RED_WINS || state == GAME_OVER_BLUE_WINS)
		{
			// they can press 't' to play again
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
			g.drawString("Welcome.  Press 1 for one-player mode, and 2 for two-player mode.", 100, 300);
		}
		else if (state == ONE_PLAYER)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			// all the drawing you'd usually do in the game... do it here
			g.setColor(Color.red);
			g.fillOval(100, 200, 50, 50);
		
		}
		else if (state == TWO_PLAYER)
		{
			g.setColor(Color.white);
			g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			// all the drawing you'd usually do in the game... do it here
			g.setColor(Color.red);
			g.fillOval(100, 200, 50, 50);
			g.setColor(Color.blue);
			g.fillOval(400, 200, 50, 50);
			
			
		}
		else if (state == GAME_OVER_ONE_PLAYER)
		{
			g.setColor(Color.gray);
			g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			g.setColor(Color.WHITE);
			g.drawString("Game over.  Press 't' to play again.", 100, 300);
		}
		else if (state == GAME_OVER_RED_WINS)
		{
			g.setColor(Color.red);
			g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			g.setColor(Color.WHITE);
			g.drawString("RED WINS!  Press 't' to play again.", 100, 300);
		}
		else if (state == GAME_OVER_BLUE_WINS)
		{
			g.setColor(Color.blue);
			g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
			
			g.setColor(Color.WHITE);
			g.drawString("BLUE WINS!  Press 't' to play again.", 100, 300);
		}

		
	}




} 


