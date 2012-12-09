/**
 *
 */
package simvita.core;

import android.graphics.RectF;
import sofia.graphics.ImageShape;
import sofia.graphics.FillableShape;
import sofia.graphics.OvalShape;
import sofia.graphics.RectangleShape;
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
        super(x, aName, desc, Color.greenYellow, null, 1, new OvalShape(0, 0, 1, 1));

        shape = new ImageShape("turtlebigsz", new RectF(0, 0, 1, 1));
        value = 20;

        setFoodCreature(new Vine());

	}


    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     *
     * @param w The world the TurtleA acts upon.
     */
	public void act(TimeLogic tl)
	{

	    Creature aFood = tl.getWorld().getNearestFood(this);

	    if (aFood.getPosition().equals(this.getPosition()))
	    {
	        tl.removeCreature(tl.getWorld().getNearestFood(this));
	    }
	    else
	    {
	        int ex = this.getPosition().x;
	        int ey = this.getPosition().y;

	        int tx = aFood.getPosition().x;
	        int ty = aFood.getPosition().y;

	        int newX = ex + (int) Math.signum((double)(tx - ex));
	        int newY = ey + (int) Math.signum((double)(ty - ey));

	        this.setPosition(new Position(newX, newY));
	    }

	}



    /**
     * Move the Turtle to random direction.
     */
    private void move()
    {
        Position newPosition =
            new Position(getPosition().x + rand.nextInt(3) - 1,
                    getPosition().y + rand.nextInt(3) - 1);

        this.setPosition(newPosition);

    }


}
