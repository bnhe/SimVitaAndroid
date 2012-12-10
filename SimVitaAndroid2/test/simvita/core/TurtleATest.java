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
@SuppressWarnings("unused")
public class TurtleATest extends TestCase
{

    private Vine v1;
    private Vine v2;
    private Vine v3;
    private TurtleA tt;
    private Eagle eg;


    /**
     * Set up this test.
     */
    public void setUp()
    {

        v1 = new Vine(new Position(19, 19));
        v2 = new Vine(new Position(1, 1));
        v3 = new Vine(new Position(6, 6));

        tt = new TurtleA(new Position(6, 6));
        eg = new Eagle(new Position(12, 12));

        Random.setNextInts(2, 2, 2, 2, 2, 2, 2, 2);
    }
    // ----------------------------------------------------------
    /**
     * Test that the turtle eats the plants whenever it sees one and moves to
     * a random new location when there's not plants around
     */
    public void testActEat()
    {
        TimeLogic tl = new TimeLogic (5);

        tl.getWorld().addCreature(v1, v1.getPosition());
        tl.getWorld().addCreature(v2, v2.getPosition());
        tl.getWorld().addCreature(v3, v3.getPosition());
        tl.getWorld().addCreature(tt, tt.getPosition());
        tl.getWorld().addCreature(eg, eg.getPosition());

        //Test Eat the plant when they at the same positon.
        assertEquals(5, tl.getWorld().getListOfCreatures().size());
        tt.act(tl);
        assertEquals(4, tl.getWorld().getListOfCreatures().size());


        //Test moving to the direction of nearest food
        tt.act(tl);
        assertEquals(5, tt.getPosition().x);
        assertEquals(5, tt.getPosition().y);

        //Test moving randomly when there is no food in the world
        tl.getWorld().clearThings();
        tt.setPosition(new Position(5, 5));
        tl.getWorld().addCreature(tt, tt.getPosition());
        tl.getWorld().addCreature(eg, eg.getPosition());

        tt.act(tl);
        assertEquals(6, tt.getPosition().x);
        assertEquals(6, tt.getPosition().y);
    }

}