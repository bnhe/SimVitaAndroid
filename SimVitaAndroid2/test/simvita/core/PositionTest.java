package simvita.core;

// -------------------------------------------------------------------------
/**
 * Test cases for Position class.
 *
 * @author verro ejiba
 * @author Nate Craun
 * @version Nov 3, 2012
 */
public class PositionTest
    extends student.TestCase
{
    private Position p;
    private Position p2;

    public PositionTest()
    {

    }

    /**
     * Set up
     */
    public void setUp()
    {
        p = new Position(3, 4);
        p2 = new Position(0, 0);
    }

    /**
     * Test Constructor.
     */
    public void testConstructor()
    {
        assertEquals(3, p.x);
        assertEquals(4, p.y);
    }

    /**
     * Test Equals
     */
    public void testEquals()
    {
        assertTrue(p.equals(new Position(3, 4)));
    }

    /**
     * Test distanceTo
     */
    public void testDistanceTo()
    {
        assertEquals(5, (int)p.distanceTo(p2));
    }
}
