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
        this(x, "TurtleAdder");

    }

    /**
     * Create a TurtleA at with a position, name and description.
     * @param x The position.
     * @param aName A name for the TurtleA
     * @param desc The description.
     */
    public TurtleAdder(Position x, String aName) {
        super(x, aName, Color.greenYellow, 20, new OvalShape(0, 0, 1, 1));
        shape.setAlpha(255);
        value = 20;
    }

    public void act(TimeLogic tl)
    {
        Position daughterPosition =
            new Position(getPosition().x + rand.nextInt(3) - 1,
                getPosition().y + rand.nextInt(3) - 1);

        tl.addCreature(new TurtleA(daughterPosition));
    }
}
