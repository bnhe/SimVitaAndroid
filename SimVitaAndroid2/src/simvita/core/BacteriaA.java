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
public class BacteriaA extends Creature {

	Random rand = new Random();
	private int num;
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
	    this(x, "SimpleBac", new Description("SimpleBac",
						"A simple Bacteria just replicate."), Color.red);
	}

	/**
	 * Create a BacteriaA at a given position, name and discription.
	 * @param x
	 * @param aName
	 * @param desc
	 * @param c
	 */
	public BacteriaA(Position x, String aName, Description desc, Color c) {
		super(x, aName, desc, c, 20);
		num = 0;
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
        //this.setPosition(new Position(5, 7));
        //System.out.println("Bacteria act");
        if (life < 0)
        {
            kill();
            w.removeThing(this);
            return null;
        }
        life--;
        return replicateBac(w);
        //num++;
    }

    /**
     * Replicate the BacteriaA and put is at a random position beside the mother BacteriaA.
     * @param w
     * @return
     */
    private ArrayList<Thing> replicateBac(World w)
    {

    	Position daughterPosition =
    			new Position(getPosition().x + rand.nextInt(3) - 1,
    					getPosition().y + rand.nextInt(3) - 1);

    	//Position daughterPosition = new Position(getPosition().x + 1, getPosition().y + 1);
    	BacteriaA daughter = new BacteriaA(daughterPosition);
    	w.addThing(daughter, daughterPosition);
    	ArrayList<Thing> th = new ArrayList<Thing>();
    	th.add(daughter);
    	return th;
    }


}
