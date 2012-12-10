package simvita.core;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 *  Test the world class
 *
 *  @author Bin He
 *  @version 2012.12.09
 */
public class WorldTest
    extends TestCase
{

    private World w;
    private Creature cr;
    private Position pos;

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
        w = new World();
        cr = new Creature(new Position(1, 1), "CreatureForTest", 1);
        pos = new Position(1, 1);

        v1 = new Vine(new Position(0, 0));
        v2 = new Vine(new Position(10, 10));
        v3 = new Vine(new Position(5, 5));
        tt = new TurtleA(new Position(6, 6));
        eg = new Eagle(new Position(12, 12));
    }

    /**
     * Test the addCreature method.
     */
    public void testAddCreatureRemoveCreature()
    {


        assertEquals(0, w.getListOfCreatures().size());

        w.addCreature(cr, pos);

        assertEquals(1, w.getListOfCreatures().size());

        w.removeCreature(cr);
        assertEquals(0, w.getListOfCreatures().size());

    }

    /**
     * Test the get list method.
     */
    public void testClearThings()
    {
        assertEquals(0, w.getListOfCreatures().size());

        w.addCreature(cr, new Position(1, 1));

        assertEquals(1, w.getListOfCreatures().size());

        w.clearThings();
        assertEquals(0, w.getListOfCreatures().size());
    }

    /**
     * Test getListOfCreature(), and getToBeDraw()
     *
     */
    public void testGetListOfCreature()
    {
        w.addCreature(cr, pos);

        assertEquals("CreatureForTest", w.getListOfCreatures().get(0).getName());
        assertEquals("CreatureForTest", w.getToBeDraw().get(0).getName());
    }


    /**
     * Test removeCreature(), and getToBeRemove()
     *
     */
    public void testRemoveMethods()
    {
        w.addCreature(cr, pos);
        w.removeCreature(cr);

        assertEquals(0, w.getListOfCreatures().size());

        assertEquals("CreatureForTest", w.getToBeRemoved().get(0).getName());
    }

    /**
     * Test the moving methods()
     */
    public void testMovingMethods()
    {
        w.addCreature(cr, pos);
        w.getToBeMoved().add(cr);


        assertEquals(1, w.getListOfCreatures().size());

        assertEquals("CreatureForTest", w.getToBeMoved().get(0).getName());
    }


    /**
     * Test the getNearestFood method.
     */
//    v1 = new Vine(new Position(0, 0));
//    v2 = new Vine(new Position(10, 10));
//    v3 = new Vine(new Position(5, 5));
//    tt = new TurtleA(new Position(6, 6));
    public void testGetNearestFood()
    {
        assertNull(w.getNearestFood(tt));

        w.addCreature(tt, tt.getPosition());
        w.addCreature(eg, eg.getPosition());
        assertNull(w.getNearestFood(tt));

        w.addCreature(v1, v1.getPosition());
        w.addCreature(v3, v3.getPosition());
        w.addCreature(v2, v2.getPosition());
        assertEquals(v3, w.getNearestFood(tt));

    }

}
