package simvita.core;

import sofia.util.Random;
import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  TurtleAdder test class
 *
 *  @author Bin He (binhe)
 *  @version 2012.12.09
 */
public class TurtleAdderTest
    extends TestCase
{
    private TurtleAdder tAdder;
    private TimeLogic tl;



    /**
     * Set up this test.
     */
    public void setUp()
    {

        tAdder = new TurtleAdder(new Position(6, 6));
        tl = new TimeLogic (5);

    }
    // ----------------------------------------------------------
    /**
     * Test turtleAdder add creatures;
     */
    public void testAct()
    {
        assertEquals(0, tl.getWorld().getListOfCreatures().size());

        tl.getWorld().addCreature(tAdder, tAdder.getPosition());
        assertEquals(1, tl.getWorld().getListOfCreatures().size());

        Random.setNextInts(2, 2, 2, 2, 2, 2, 2, 2);
        tAdder.act(tl);

        assertEquals(2, tl.getWorld().getListOfCreatures().size());
        assertEquals(2, tl.getWorld().getListOfCreatures().get(1).getPosition().x);
        assertEquals(2, tl.getWorld().getListOfCreatures().get(1).getPosition().y);
    }

}