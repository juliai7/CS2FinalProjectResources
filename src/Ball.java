import java.awt.Color;
import java.awt.Graphics;

/**
 * Ball
 * Written by Steinberg, Thibodeaux, & Sanden for Intro Programming
 * Modified for CS2 by Zach Blick on Feb. 13, 2024
 *
 * Ball is designed to create a graphical Ball for MouseDemo.
 */

public class Ball
{
    // Instance Variables
    private int x;              // Center x
    private int y;              // Center y
    private int dx;             // delta x in one time unit
    private int dy;             // delta y in one time unit
    private int radius;         // Radius of the ball
    private Color color;

    // Constructors
    public Ball() {
        this(200, 300,5,4, 10, Color.RED);
    }

    public Ball(int xIn, int yIn, int dxIn, int dyIn, int radiusIn, Color colorIn) {
        x = xIn;
        y = yIn;
        dx = dxIn;
        dy = dyIn;
        radius = radiusIn;
        color = colorIn;
    }

    public boolean isClicked(int x, int y) {
        double dx = (this.x - x) * (this.x - x);
        double dy = (this.y - y) * (this.y - y);
        return Math.sqrt(dx + dy) <= radius;
    }

    public void move() {
        x = x + dx;
        y = y + dy;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public boolean bounce(int xLow, int xHigh, int yLow, int yHigh) {
        // Check for an x bounce.  Note that we bounce if the x is too
        //  low or too high AND IS HEADING IN THE WRONG DIRECTION.
        if ((x - radius <= xLow && dx < 0) || (x + radius >= xHigh && dx > 0)) {
            dx = -dx;
            return true;
        }

        // Now check for a y bounce.
        if ((y - radius <= yLow && dy < 0) || (y + radius >= yHigh && dy > 0)) {
            dy = -dy;
            return true;
        }
        return false;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public void setCenter(int xIn, int yIn) {
        x = xIn;
        y = yIn;
    }

    public void setColor(Color colorIn)
    {
        color = colorIn;
    }

    /**
     * Shift the ball by the given amount in the x direction.
     * @param shift     How much to shift the ball's location
     */
    public void shiftX(int shift, int xLow, int xHigh) {
        if (x - radius + shift <= xLow && shift < 0) {
            x = xLow + radius;
        }
        else if (x + radius + shift >= xHigh && shift > 0) {
            x = xHigh - radius;
        }
        else {
            x += shift;
        }
    }

    /**
     * Shift the ball by the given amount in the y direction.
     * @param shift     How much to shift the ball's location
     */
    public void shiftY(int shift, int yLow, int yHigh) {
        if (y - radius + shift <= yLow && shift < 0) {
            y = yLow + radius;
        }
        else if (y + radius + shift >= yHigh && shift > 0) {
            y = yHigh - radius;
        }
        else {
            y += shift;
        }
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
    }
}