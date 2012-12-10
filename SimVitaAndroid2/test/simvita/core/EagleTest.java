package simvita.core;

import sofia.util.Random;
import student.TestCase;
import sofia.util.Random;


// -------------------------------------------------------------------------
/**
 *  Tests for TurtleA class
 *
 *  @author Verro Ejiba (verroe)
 *  @author Bin He (binhe)
 *  @version 2012.12.09
 */
public class EagleTest extends TestCase
{

    private TurtleA t1;
    private TurtleA t2;
    private TurtleA t3;
    private Vine v1;

    private Eagle eg;


    /**
     * Set up this test.
     */
    public void setUp()
    {

        t1 = new TurtleA(new Position(19, 19));
        t2 = new TurtleA(new Position(1, 1));
        t3 = new TurtleA(new Position(6, 6));

        v1 = new Vine(new Position(10, 10));
        eg = new Eagle(new Position(6, 6));

        Random.setNextInts(2, 2, 2, 2, 2, 2, 2, 2);
    }
    // ----------------------------------------------------------
    /**
     * Test that the Eagle eats the turtleA whenever it sees one
     */
    public void testAct()
    {
        TimeLogic tl = new TimeLogic (5);

        tl.getWorld().addCreature(t1, t1.getPosition());
        tl.getWorld().addCreature(t2, t2.getPosition());
        tl.getWorld().addCreature(t3, t3.getPosition());
        tl.getWorld().addCreature(v1, v1.getPosition());
        tl.getWorld().addCreature(eg, eg.getPosition());

        //Test Eat the turtle when they at the same positon.
        assertEquals(5, tl.getWorld().getListOfCreatures().size());
        eg.act(tl);
        assertEquals(4, tl.getWorld().getListOfCreatures().size());


        //Test moving to the direction of nearest food
        eg.act(tl);
        assertEquals(5, eg.getPosition().x);
        assertEquals(5, eg.getPosition().y);


        //Test stand there when there is no food in the world
        tl.getWorld().clearThings();
        assertEquals(0, tl.getWorld().getListOfCreatures().size());

        eg.setPosition(new Position(5, 5));
        tl.getWorld().addCreature(eg, eg.getPosition());
        tl.getWorld().addCreature(v1, v1.getPosition());
        assertEquals(2, tl.getWorld().getListOfCreatures().size());

        eg.act(tl);
        assertEquals(5, eg.getPosition().x);
        assertEquals(5, eg.getPosition().y);
    }
}