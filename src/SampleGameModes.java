import javax.swing.*;
import java.awt.event.*;
/**
 * SampleGameModes & SampleGameModesView
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * Example of how to create different "states" of the game.
 */
public class SampleGameModes implements ActionListener, KeyListener
{
	public static final int DELAY_IN_MILLISEC = 20,
							WELCOME_SCREEN = 37,
							PLAYING = 12,
							GAME_OVER = 56;
	
	private int state;
	private int lives;
	private Ball b;
	private SampleGameModesView window;

	public SampleGameModes() {
		this.state = WELCOME_SCREEN;
		this.lives = 3;
		b = new Ball();
		window = new SampleGameModesView(this, b);

		window.addKeyListener(this);
		Timer clock = new Timer(DELAY_IN_MILLISEC, this);
		clock.start();
	}

	public static void main(String args[]) {
		SampleGameModes s = new SampleGameModes();
	}

	// This method gets called again and again, every 20 miliseconds. Animation things happen here.
	public void actionPerformed(ActionEvent e)
	{
		if (state == WELCOME_SCREEN) {
			// ETC ETC
		}
		else if (state == PLAYING) {
			b.move();
			if(b.bounce(0, SampleGameModesView.WINDOW_WIDTH,
					SampleGameModesView.TOP_OF_WINDOW, SampleGameModesView.WINDOW_HEIGHT))
				if(--lives == 0)
					state = GAME_OVER;

		}
		else if (state == GAME_OVER) {
			// ETC ETC
		}
		window.repaint();
	}
	
	public void keyTyped(KeyEvent e) {}

	public void keyPressed(KeyEvent e) {
		if (state == WELCOME_SCREEN) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				state = PLAYING;
			}
		}
		else if (state == PLAYING) {
			// Let's imagine they lose the game if they press the 'l' key
			if (e.getKeyCode() == KeyEvent.VK_L) {
				state = GAME_OVER;
			}
		}
		else if (state == GAME_OVER) {
			if (e.getKeyCode() == KeyEvent.VK_T) {
				state = WELCOME_SCREEN;
				lives = 3; // reset the game;
			}
		}
	}

	public void keyReleased(KeyEvent e) {}

	public int getState() {
		return state;
	}
}