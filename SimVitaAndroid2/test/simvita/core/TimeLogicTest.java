package simvita.core;

import java.util.PriorityQueue;

// -------------------------------------------------------------------------
/**
 * Test cases for time logic class.
 *
 * @author Nate Craun
 * @author verro ejiba
 * @version 2012.12.06
 */
public class TimeLogicTest extends student.TestCase
{
    private TimeLogic game;
    private PriorityQueue<TimeEvent> timeQueue;
    private World world;
    private Creature c;
    private Position p;
    private String name;
    private int frequency;

    /**
     * Create a new TimeLogicTest object.
     */
    public TimeLogicTest()
    {

    }

    public void setUp()
    {
        frequency = 5;

        this.timeQueue = new PriorityQueue<TimeEvent>();
        this.world = new World();
        this.game = new TimeLogic(timeQueue, world, 100);
        this.c = new Creature(p, name, frequency);

    }
    // ----------------------------------------------------------
    /**
     * Tests the addCreature methods that adds creature to the world.
     */
    public void testAddCreature()
    {
        long clock = game.getClock();
        game.addCreature(c);
        assertTrue(world.getListOfCreatures().contains(c));
        TimeEvent te = game.getMainQueue().poll();
        assertEquals(c, te.creature);
        assertTrue(world.getToBeDraw().contains(c));
    }

    // ----------------------------------------------------------
    /**
     * Test that a given creature had been removed.
     */
    public void testRemoveCreature()
    {
        game.addCreature(c);
        game.removeCreature(c);
        assertFalse(world.getListOfCreatures().contains(c));
        assertTrue(world.getToBeRemoved().contains(c));
    }

    /**
     * Test that a given creature had been moved.
     */
    public void testMoveCreature()
    {
        Position p = new Position(5, 9);
        game.addCreature(c);
        game.moveCreature(c, p);
        assertEquals(p, c.getPosition());
        assertTrue(world.getListOfCreatures().contains(c));
        assertTrue(world.getToBeMoved().contains(c));
    }


    // ----------------------------------------------------------
    /**
     * Test the getters
     */
    public void testGetters()
    {
        assertEquals(timeQueue, game.getMainQueue());
        assertEquals(world, game.getWorld());
        assertEquals(0L, game.getClock());
    }

    /**
     * Test money related functions
     */
    public void testMoney()
    {
        assertEquals(0L, game.getMoney());
        game.setMoney(50);
        assertEquals(50L, game.getMoney());
        game.addMoney(50);
        assertEquals(100L, game.getMoney());
        game.subtractMoney(50);
        assertEquals(50L, game.getMoney());
    }

    /**
     * Test game over, for time out
     */
    public void testGameOverTime()
    {
        game = new TimeLogic(3);
        game.setMoney(50);
        assertFalse(game.isOver());
        game.addCreature(c);
        game.tick();
        assertTrue(game.isOver());
    }

    /**
     * Test game over for no money and no plants.
     */
    public void testGameOverMoneyPlant()
    {
        game.setMoney(50);
        assertFalse(game.isOver());
        game.setMoney(0);
        assertTrue(game.isOver());
    }

    /**
     * Test queuing of creatures at different times.
     */
    public void testQueueing()
    {
        Position p = new Position(0, 0);
        Creature c = new Creature(p, "", 5);
        Creature c2 = new Creature(p, "", 7);

        game.addCreature(c);
        game.addCreature(c2);

        TimeEvent t = game.tick();
        assertEquals(10L, t.time);
        assertEquals(c, t.creature);

        t = game.tick();
        assertEquals(14L, t.time);
        assertEquals(c2, t.creature);

        t = game.tick();
        assertEquals(15L, t.time);
        assertEquals(c, t.creature);

        t = game.tick();
        assertEquals(21L, t.time);
        assertEquals(c2, t.creature);
    }
}