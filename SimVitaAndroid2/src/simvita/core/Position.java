package simvita.core;

// -------------------------------------------------------------------------
/**
 * A class to store the x and y values for the position of the creature and
 * scenery in the world.
 *
 * @author Verro Ejiba
 * @version Nov 1, 2012
 */
public class Position
{
    /**
     *  x position
     */
    public int x;

    /**
     * y position
     */
    public int y;


    // ----------------------------------------------------------
    /**
     * Sets the x and y to themself
     *
     * @param x
     *            row
     * @param y
     *            column
     */
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;

    }

    // ----------------------------------------------------------
    /**
     * Compare two x and y  positions and return true if they are equal
     *
     * @param position the x and  y position to compare to
     * @return true if the two positions are equals and false if not equal
     */
    public boolean equals(Position position)
    {

        return (x == position.x) && (y == position.y);
    }

    /**
     *
     */
    public double distanceTo(Position toP)
    {
        return Math.sqrt((toP.x - x)*(toP.x - x) + (toP.y - y)*(toP.y - y));
    }
}
