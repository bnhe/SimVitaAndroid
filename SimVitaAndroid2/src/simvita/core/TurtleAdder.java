package simvita.core;

import android.graphics.RectF;
import sofia.graphics.Color;
import sofia.graphics.ImageShape;
import sofia.graphics.OvalShape;
import java.util.Random;

public class TurtleAdder
    extends Creature
{

    Random rand = new Random();

    /**
     * Create a TurtleA at the origin of the world.
     */
    public TurtleAdder()
    {
        this(new Position(0, 0));
    }

    /**
     * Create a TurtleA at a given position.
     * @param x The position to put the TurtleA at.
     */
    public TurtleAdder(Position x) {
        this(x, "TurtleAdder",
                new Description("TurtleAdder",
                        "Adds turtles"));

    }

    /**
     * Create a TurtleA at with a position, name and description.
     * @param x The position.
     * @param aName A name for the TurtleA
     * @param desc The description.
     */
    public TurtleAdder(Position x, String aName, Description desc) {
        super(x, aName, desc, Color.greenYellow, null, 20, new OvalShape(0, 0, 1, 1));

        shape.setAlpha(0);
        value = 20;

        //setFoodCreature(new Vine());

    }

    public void act(TimeLogic tl)
    {
        //Position newPosition = new Position(rand.nextInt(tl.getWidth()),
        //    rand.nextInt(tl.getHeight()));
        Position randomPosition =
            new Position(rand.nextInt(19), rand.nextInt(19));


    tl.addCreature(new TurtleA(randomPosition));

        //tl.addCreature(new TurtleA(newPosition));
    }
}
