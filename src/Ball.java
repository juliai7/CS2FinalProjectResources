import java.awt.Color;
import java.awt.Graphics;

/*
 * Ball Class specifically for use with the KeyListenerDemo class
 */

class Ball
{
    // Instance Variables
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private int radius;         // Radius of the ball
    private Color color;

    // Constructors
    public Ball(int xIn, int yIn, int dxIn, int dyIn, int radiusIn, Color colorIn)
    {
        x = xIn;
        y = yIn;
        dx = dxIn;
        dy = dyIn;
        radius = radiusIn;
        color = colorIn;
    }

    // Methods

    /**
     * Shift the ball by the given amount in the x direction.
     * @param shift     How much to shift the ball's location
     */
    public void shiftX(int shift, int xLow, int xHigh)
    {
        if (x - radius + shift <= xLow && shift < 0)
        {
            x = xLow + radius;
        }
        else if (x + radius + shift >= xHigh && shift > 0)
        {
            x = xHigh - radius;
        }
        else
        {
            x += shift;
        }
    }

    /**
     * Shift the ball by the given amount in the y direction.
     * @param shift     How much to shift the ball's location
     */
    public void shiftY(int shift, int yLow, int yHigh)
    {
        if (y - radius + shift <= yLow && shift < 0)
        {
            y = yLow + radius;
        }
        else if (y + radius + shift >= yHigh && shift > 0)
        {
            y = yHigh - radius;
        }
        else
        {
            y += shift;
        }
    }

    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}