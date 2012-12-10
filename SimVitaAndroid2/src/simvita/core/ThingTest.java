package simvita.core;

import sofia.graphics.OvalShape;
import sofia.graphics.Shape;
import sofia.graphics.Color;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author verro ejiba
 *  @version Dec 6, 2012
 */
public class ThingTest extends student.TestCase
{
    private Thing thing;
    private Position    curPosition;
    private String      name;
    private Description description;
    public OvalShape shape;

    public void setUp()
    {
        thing = new Thing(curPosition, name, description, Color.blue, shape);
        this.shape = new OvalShape();
    }
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testSetPosition()
    {
        curPosition = new Position(20, 20);
        thing.setPosition(curPosition);
        assertEquals(20, 20);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetPosition()
    {
        curPosition = new Position(20, 20);
        thing.setPosition(curPosition);
        assertEquals(curPosition, thing.getPosition());
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetName()
    {

        name = new String ("Plant");
        thing.setName(name);
        assertEquals(name, thing.getName());
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetDescription()
    {
        thing.setDescription(description);
        assertEquals(description, thing.getDescription());
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testToString()
    {
        name = new String ("plant");
        thing.setName(name);
        assertEquals("plant", thing.toString());
    }
}
