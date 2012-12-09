package simvita.core;

import java.util.ArrayList;

/**
 * All the creatures in this game live in this expandable world.
 * World class describes the status of the game at a given time point.
 * It holds all the Things including Creatures and Sceneries in this game.
 * Within this world all creature's.
 *
 * This is the game simulate interactions between creatures.
 * All the creatures live in a expandable world.
 */

/**
 * @author Bin He
 * @author Nate Craun
 * @version 2012.11.3
 */
public class World {

	private ArrayList<Creature> creatures;
	private ArrayList<Creature> toBeRemoved;
	public ArrayList<Creature> toBeDraw;
	public ArrayList<Creature> toBeMoved;

	/**
	 * Create a new empty world.
	 */
	public World()
	{
		creatures = new ArrayList<Creature>();
		toBeRemoved = new ArrayList<Creature>();
		toBeDraw = new ArrayList<Creature>();
		toBeMoved = new ArrayList<Creature>();
	}

	/**
	 * Create a world with a list of things in it.
	 * @param things The list of things alread in the world.
	 *
	 */
	public World(ArrayList<Creature> creatures)
	{
		this.creatures = creatures;
	}

	/**
	 * Add a thing in the world.
	 * @param t The thing to be added.
	 * @param x The position tha the thing been add to the world.
	 */
	public void addThing(Creature c, Position p)
	{
		c.setPosition(p);
		creatures.add(c);
		toBeDraw.add(c);
	}

	/**
	 * Remove a certain thing in the world.
	 * @param t The thing been removed.
	 */
	public void removeThing(Creature c)
	{
	    creatures.remove(c);
	    toBeRemoved.add(c);
	}

	/**
	 * Clear all things in the world.
	 */
	public void clearCreatures()
	{
		creatures = new ArrayList<Creature>();
	}

	/**
	 * Get all the things in the world.
	 * @return All the things in the world.
	 */
	public ArrayList<Creature>  getListOfCreatures()
	{
		return creatures;
	}

	/**
	 * getToBeRemoved list.
	 */
	public ArrayList<Creature> getToBeRemoved()
	{
	    return toBeRemoved;
	}

	/**
	 * get Things to be added
	 */
	public ArrayList<Creature> getToBeDraw()
	{
	    return toBeDraw;
	}

	/**
     * get Things to be added
     */
    public ArrayList<Creature> getToBeMoved()
    {
        return toBeMoved;
    }

	/**
	 * Get the nearest target.
	 *
	 * @returns The nearest food object that a predator eats, or null if there
	 * are none of them in the world.
	 */
	public Creature getNearestFood(Creature preditor)
	{
        for (Creature c : getListOfCreatures())
        {
            if (c.getClass().equals(preditor.getFoodCreature().getClass() ))
            {
                return c;
            }
        }

        return null;
	}
}
