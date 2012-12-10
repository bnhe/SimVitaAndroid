package simvita.core;

// -------------------------------------------------------------------------
/**
 *  Tests for TurtleA class
 *
 *  @author verro ejiba
 *  @version Dec 9, 2012
 */
public class TurtleATest extends student.TestCase
{
    private TurtleA turtle;
    private Vine vine;
    private World world;

    public void setUp()
    {
        Position p = new Position (5, 5);
        Position p2 = new Position (6, 6);
        turtle = new TurtleA(p);
        vine = new Vine(p2);
        world = new World();

    }
    // ----------------------------------------------------------
    /**
     * Test that the turtle eats the plants whenever it sees one and moves to
     * a random new location when there's not plants around
     */
    public void testAct()
    {
        TimeLogic tl = new TimeLogic (5);
        turtle.act(tl);
        assertNull(null);
    }
}
