package simvita.core;

// -------------------------------------------------------------------------
/**
 *  Test cases for Position class.
 *
 *  @author verro ejiba
 *  @version Nov 3, 2012
 */
public class PositionTest extends student.TestCase
{
    private Position position;

    // ----------------------------------------------------------
    /**
     * Set up
     */
    public void setUp()
    {
        position = new Position (1, 2);
    }

    // ----------------------------------------------------------
    /**
     * Test the equals method.
     */
    public void testEquals()
    {
        assertEquals(1, position.x);
        assertEquals(2, position.y);

        assertEquals(true, position.equals(position));
        Position position2 = new Position (2, 1);
        assertEquals(false, position.equals(position2));
    }

}
