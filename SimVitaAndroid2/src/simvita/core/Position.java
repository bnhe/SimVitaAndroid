package simvita.core;

// -------------------------------------------------------------------------
/**
 * A class to store the x and y values for the position of the creature and
 * scenery in the world.
 *
 * @author Verro Ejiba (verroe)
 * @version 2012.12.09
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
     * Calculate the distance between two points.
     *
     * @param toP The "to" point.
     * @return The distance between the two points.
     */
    public double distanceTo(Position toP)
    {
        return Math.sqrt((toP.x - x)*(toP.x - x) + (toP.y - y)*(toP.y - y));
    }
}
