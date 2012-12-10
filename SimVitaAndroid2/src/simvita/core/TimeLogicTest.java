package simvita.core;

import sofia.graphics.Color;
import java.util.PriorityQueue;

// -------------------------------------------------------------------------
/**
 *  Test cases for time logic class.
 *
 *  @author verro ejiba
 *  @version 2012.12.06
 */
public class TimeLogicTest extends student.TestCase
{
    private TimeLogic game;
    private PriorityQueue<TimeEvent> timeQueue;
    private PriorityQueue<TimeEvent> rollOverTimeQueue;
    private World world;
    private Creature c;
    private Position p;
    private String name;
    private Description desc;
    private int frequency;


    // ---------------------------------------------------------
    // ----------------------------------------------------------
    /**
     * Create a new TimeLogicTest object.
     */
    public TimeLogicTest()
    {
        this.game = new TimeLogic();
    }

    public void setUp()
    {
        this.game = new TimeLogic(timeQueue, rollOverTimeQueue, world);
        this.rollOverTimeQueue = new PriorityQueue<TimeEvent>();
        this.timeQueue = new PriorityQueue<TimeEvent>();
        this.world = new World();
        this.c = new Creature(p, name, desc, Color.red, frequency);

    }
    // ----------------------------------------------------------
    /**
     * Tests the addCreature methods that adds creature to the world.
     */
    public void testAddCreature()
    {
        game.addCreature(c);
        assertEquals(true, world.isCreaturePresent());

    }

    // ----------------------------------------------------------
    /**
     * Test that a given creature had been removed.
     */
    public void testRemoveCreature()
    {
        game.addCreature(c);
        game.removeCreature(c);
        assertEquals(true, world.creatureNotPresent());
    }


    // ----------------------------------------------------------
    /**
     * Test the getMainQueue method
     */
    public void testGetMainQueue()
    {
        assertEquals(2, game.getMainQueue());
    }

    /**
     * Tests the getRollOverQueue
     */
    public void testGetRollOverQueue()
    {
        assertEquals(10, game.getRollOverQueue());
    }
}
