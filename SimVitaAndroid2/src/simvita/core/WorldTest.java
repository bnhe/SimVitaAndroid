package simvita.core;

import java.util.ArrayList;
import sofia.graphics.OvalShape;
import sofia.graphics.Shape;
import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 *  Test cases for the World class. Makes sure that all the methods implemented
 *  work properly.
 *
 *  @author verro ejiba
 *  @version Dec 6, 2012
 */
public class WorldTest extends student.TestCase
{
    private World world;
    private Thing plant;
    private ArrayList<Thing> things;
    private OvalShape s;
    private Position p;
    private Description d;
    private String name;

    public void setUp()
    {
        this.world = new World();
        plant = new Thing(p, name, d, Color.green, s);
        things = new ArrayList<Thing>() ;
    }

    // ----------------------------------------------------------
    /**
     * Test addThing method by adding a plant at position (10, 50) in world.
     */
    public void testAddThing()
    {
        p = new Position(10, 50);
        world.addThing(plant, p);
        assertEquals(true, world.isCreaturePresent());

    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testRemoveThing()
    {
        p = new Position(10, 50);
        world.addThing(plant, p);
        world.removeThing(plant);
        assertEquals(true, world.creatureNotPresent());
    }

    // ----------------------------------------------------------
    /**
     * Test that the creature has been cleared when clear() method was called
     */
    public void testClear()
    {
        world.addThing(plant, p);
        world.clearThings();
        assertNull(null);
    }

    // ----------------------------------------------------------
    /**
     * tests the getListOfThings
     */
    public void testGetListOfThings()
    {
        assertEquals(things, world.getListOfThings());
    }

    // ----------------------------------------------------------
    /**
     * Test the getToBERemoved list
     */
    public void testGetToBeRemoved()
    {
        p = new Position(10, 50);
        world.addThing(plant, p);
        assertEquals(things, world.getToBeRemoved());
    }
    // ----------------------------------------------------------
    /**
     * test the getToBeDrawn fir the thing that is to be added.
     */
    public void testGetToBeDrawn()
    {
        p = new Position(10, 50);
        assertEquals(things, world.getToBeDraw());
    }
}
