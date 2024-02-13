import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
/**
 * SampleGameModes & SampleGameModesView
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * Example of how to create different "states" of the game.
 */
public class SampleGameModesView extends JFrame {

    public static final int WINDOW_WIDTH = 700,
                            WINDOW_HEIGHT = 500,
                            TOP_OF_WINDOW = 23;

    private SampleGameModes s;
    private Ball b;

    public SampleGameModesView(SampleGameModes s, Ball b) {
        this.s = s;
        this.b = b;
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setTitle("GAME MODES DEMO");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.createBufferStrategy(2);
    }

    public void paint(Graphics g) {
        BufferStrategy bf = this.getBufferStrategy();
        if (bf == null)
            return;

        Graphics g2 = null;

        try {
            g2 = bf.getDrawGraphics();

            // myPaint does the actual drawing
            myPaint(g2);
        }
        finally {
            // It is best to dispose() a Graphics object when done with it.
            g2.dispose();
        }

        // Shows the contents of the backbuffer on the screen.
        bf.show();

        // Tell the System to do the Drawing now, otherwise it can take a few extra ms until
        // Drawing is done which looks very jerky
        Toolkit.getDefaultToolkit().sync();
    }

    public void myPaint(Graphics g)
    {
        switch(s.getState())
        {
            case SampleGameModes.WELCOME_SCREEN:
                g.setColor(Color.black);
                g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
                g.setColor(Color.GREEN);
                g.drawString("Welcome.  Press SPACE to play.", 100, 300);
                break;

            case SampleGameModes.PLAYING:
                g.setColor(Color.white);
                g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

                // All the drawing you'd usually do in the game... do it here
                b.draw(g);
                break;

            case SampleGameModes.GAME_OVER:
                g.setColor(Color.blue);
                g.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

                g.setColor(Color.WHITE);
                g.drawString("Game over.  Press 't' to play again.", 100, 300);
                break;
        }
    }
}
