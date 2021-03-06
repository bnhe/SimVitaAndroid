/**
 *
 */
package simvita.core;

import java.util.ArrayList;
import sofia.graphics.Color;
import java.util.Random;

/**
 *
 * This is a very simple Thing which just replicate and die.
 *
 * @author Bin He
 * @version 2012.11.30
 *
 */
public class TurtleA extends Creature {

	Random rand = new Random();

	/**
	 * Create a TurtleA at the origin of the world.
	 */
	public TurtleA()
	{
		this(new Position(0, 0));
	}

	/**
	 * Create a TurtleA at a given position.
	 * @param x The position to put the TurtleA at.
	 */
	public TurtleA(Position x) {
		this(x, "SimpleMoving",
				new Description("SimpleMoving",
						"A simple moving thing"));

	}

	/**
	 * Create a TurtleA at with a position, name and description.
	 * @param x The position.
	 * @param aName A name for the TurtleA
	 * @param desc The description.
	 */
	public TurtleA(Position x, String aName, Description desc) {
		super(x, aName, desc, Color.greenYellow, 10);

	}


    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     *
     * @param w The world the TurtleA acts upon.
     */
    public ArrayList<Thing> act(World w)
    {
        ArrayList<Thing> oldThing = new ArrayList<Thing>();

        Position newPosition =
            new Position(getPosition().x + rand.nextInt(3) - 1,
                    getPosition().y + rand.nextInt(3) - 1);

        TurtleA oldPath = this;
        oldPath.kill();
        oldThing.add(oldPath);

        this.setPosition(newPosition);
        return oldThing;
    }

    /**
     * Move the Turtle to random direction.
     */
    private void move()
    {


    }


}
