package simvita.core;

import sofia.graphics.OvalShape;
import sofia.graphics.Shape;
import java.util.ArrayList;
import sofia.graphics.Color;

/**
 * Thing represent a entity live or exist in the world. A thing can be a
 * Creature with life or be a inorganic scenery.
 *
 * @author Sihui Zhang
 * @version 2012.10.30
 */

public class Thing
{

    // ~Fields------------------------------------------------------------------

    private Position    curPosition;
    private String      name;
    public Shape shape;
    public int value;


    // ~Constructors------------------------------------------------------------
    /**
     * Create a Thing.
     *
     * @param x
     *            The position in the world.
     * @param aName
     *            The name of the thing.
     * @param desc
     *            The detailed description of the thing.
     */
    public Thing(Position x, String aName, Shape s)
    {
        curPosition = x;
        name = aName;
        shape = s;
    }


    // ----------------------------------------------------------
    /**
     * Set the position of the thing in the world.
     *
     * @param x
     *            the position in the world.
     */
    public void setPosition(Position x)
    {
        curPosition = x;
    }


    // ----------------------------------------------------------
    /**
     * Get the current position of this thing.
     *
     * @return current position
     */
    public Position getPosition()
    {
        return curPosition;
    }

    /**
     * Get the name of the type of the Thing.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     *
     * @param w The world the creature acts upon.
     */
    public void act(TimeLogic tl)
    {

    }

    public String toString()
    {
        return name;
    }

}
