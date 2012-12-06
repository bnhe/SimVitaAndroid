package simvita.core;

import sofia.graphics.FillableShape;
import android.graphics.RectF;
import sofia.graphics.Color;
import sofia.graphics.ImageShape;
import sofia.graphics.OvalShape;
import sofia.graphics.RectangleShape;


/**
 *  Does nothing but sit there
 *
 *  @author Nate Craun
 *  @version Dec 3, 2012
 */
public class DoNothingCreature extends Creature
{
    /**
     * Create a TurtleA at the origin of the world.
     */
    public DoNothingCreature()
    {
        this(new Position(0, 0));
    }

    /**
     * Create a TurtleA at a given position.
     * @param x The position to put the TurtleA at.
     */
    public DoNothingCreature(Position x) {
        this(x, "DoNothing",
                new Description("DoNothing",
                        "Does nothing"));

    }

    /**
     * Create a TurtleA at with a position, name and description.
     * @param x The position.
     * @param aName A name for the TurtleA
     * @param desc The description.
     */
    public DoNothingCreature(Position x, String aName, Description desc) {
        super(x, aName, desc, Color.greenYellow, null, 10, new OvalShape(0, 0, 1, 1));

        shape = new RectangleShape(0, 0, 1, 1);
        ((FillableShape)shape).setFilled(true);
        shape.setColor(Color.beige);
    }

    public void act()
    {

    }
}
