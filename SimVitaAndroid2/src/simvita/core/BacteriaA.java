/**
 *
 */
package simvita.core;

import sofia.graphics.FillableShape;
import sofia.graphics.OvalShape;
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
public class BacteriaA extends Creature {

	Random rand = new Random();
	private int life;

	/**
	 * Create a BacteriaA at the origin of the world.
	 */
	public BacteriaA()
	{
		this(new Position(0, 0));
	}

	/**
	 * Create a BacteriaA at a given position.
	 * @param x the Position to put the BacteriaA at.
	 */
	public BacteriaA(Position x) {
	    this(x, Color.red, 1);
	}

	/**
	 * Create a BacteriaA at a given position, name and discription.
	 * @param x
	 * @param aName
	 * @param desc
	 * @param c
	 */
	public BacteriaA(Position x, Color c, int f) {
		super(x, "BacteriaA", new Description("Bac", "A replicating Bacteria"), c, 1);

		shape = new OvalShape();
        ((FillableShape)shape).setFilled(true);
        ((FillableShape)shape).setFillColor(color);
		life = 3;
	}


    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     *
     * @param w The world the BacteriaA acts upon.
     * @return
     */
    public void act(TimeLogic tl)
    {

        if (life <= 0)
        {
            tl.removeCreature(this);
            System.out.println("Removed a bacteria");
        }
        else
        {
            replicate(tl);
            life -= 2;
        }


    }

    /**
     * Replicate the BacteriaA and put is at a random position beside the mother BacteriaA.
     * @param w
     * @return
     * @return
     */
    private void replicate(TimeLogic tl)
    {
    	Position daughterPosition =
    			new Position(getPosition().x + rand.nextInt(3) - 1,
    					getPosition().y + rand.nextInt(3) - 1);


        tl.addCreature(new BacteriaA(daughterPosition));

    }


}
