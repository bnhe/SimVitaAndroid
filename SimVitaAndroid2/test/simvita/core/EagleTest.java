package simvita.core;

import java.util.PriorityQueue;

// -------------------------------------------------------------------------
/**
 *  Tests the eagle class
 *
 *  @author verro ejiba
 *  @version Dec 9, 2012
 */
public class EagleTest extends student.TestCase
{
    private Eagle eagle;
    private Position p;
    private TurtleA turtle;
    private World world;

    public void setUp()
    {
        eagle = new Eagle(p);
        turtle = new TurtleA(new Position(4, 9));

    }

    // ----------------------------------------------------------
    /**
     * Tests the act() in eagle class
     */
    public void testAct()
    {
        p = new Position(4, 6);
        eagle.act(new TimeLogic(2));
        assertEquals(turtle, world.getNearestFood(eagle));
    }
}
