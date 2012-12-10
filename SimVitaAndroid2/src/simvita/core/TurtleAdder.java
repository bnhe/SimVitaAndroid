package simvita.core;

import sofia.graphics.OvalShape;
import sofia.util.Random;

/**
 * An invisible creature that will add turtles to the World. This enables us to
 * have constantly spawning turtles, without getting exponential growth.
 *
 *  @author Nate Craun (ncraun)
 *  @version 2012.12.09
 */
public class TurtleAdder
extends Creature
{

    private Random rand = new Random();

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
     */
    public TurtleAdder(Position x, String aName) {
        super(x, aName, 20, new OvalShape(0, 0, 1, 1));

        shape.setAlpha(0);
        value = 20;
    }

    /**
     * This creature's action is to add more turtles to the world.
     *
     * @param tl The TimeLogic.
     */
    public void act(TimeLogic tl)
    {
        Position randomPosition =
            new Position(rand.nextInt(19), rand.nextInt(19));


        tl.addCreature(new TurtleA(randomPosition));
    }
}
