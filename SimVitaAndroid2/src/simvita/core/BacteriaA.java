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
public class BacteriaA extends SimpleCreature {

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
		super(x, c, 1);

		shape = new OvalShape();
        ((FillableShape)shape).setFilled(true);
        ((FillableShape)shape).setFillColor(color);
		life = 2;
	}


    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     *
     * @param w The world the BacteriaA acts upon.
     * @return
     */
    public ArrayList<Thing> act(World w)
    {

//        if (life < 0)
//        {
//            ArrayList<Thing> removeThis = new ArrayList<Thing>();
//            w.getToBeRemoved().add(this);
//            w.removeThing(this);
//        }
//        else
//        {
            replicate(w);
//            life--;
//        }
        return null;
    }

    /**
     * Replicate the BacteriaA and put is at a random position beside the mother BacteriaA.
     * @param w
     * @return
     * @return
     */
    private void replicate(World w)
    {
    	Position daughterPosition =
    			new Position(getPosition().x + rand.nextInt(3) - 1,
    					getPosition().y + rand.nextInt(3) - 1);

    	BacteriaA daughter = new BacteriaA(daughterPosition);
    	w.addThing(daughter, daughterPosition);
    	w.getToBeDraw().add(daughter);

    }


}
