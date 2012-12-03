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
 * @version 2012.11.3
 */
public class World {

	private ArrayList<Thing> things;
	private ArrayList<Thing> toBeRemoved;
	public ArrayList<Thing> toBeDraw;

	/**
	 * Create a new empty world.
	 */
	public World()
	{
		things = new ArrayList<Thing>();
		toBeRemoved = new ArrayList<Thing>();
		toBeDraw = new ArrayList<Thing>();
	}

	/**
	 * Create a world with a list of things in it.
	 * @param things The list of things alread in the world.
	 *
	 */
	public World(ArrayList<Thing> things)
	{
		this.things = things;
	}

	/**
	 * Add a thing in the world.
	 * @param t The thing to be added.
	 * @param x The position tha the thing been add to the world.
	 */
	public void addThing(Thing t, Position x)
	{
		t.setPosition(x);
		things.add(t);
		toBeDraw.add(t);
	}

	/**
	 * Remove a certain thing in the world.
	 * @param t The thing been removed.
	 */
	public void removeThing(Thing t)
	{
	    things.remove(t);
	}

	/**
	 * Clear all things in the world.
	 */
	public void clearThings()
	{
		things = new ArrayList<Thing>();
	}


	/**
	 * Get all the things in a region.
	 * @param region A ArrayList of positions representing the region.
	 * @return A ArrayList of things in this region.
	 *
	 */
	public ArrayList<Thing> getRegion(ArrayList<Position> region)
	{
		ArrayList<Thing> thingsInRegion = new ArrayList<Thing>();
		boolean thisThingIsHere = false;

		for (Thing t:things)
		{
			for (Position p:region)
			{
				if (t.getPosition() == p)
				{
					thisThingIsHere = true;
				}
			}

			if (thisThingIsHere)
			{
				thingsInRegion.add(t);
			}
		}

		return thingsInRegion;
	}



	/**
	 * Get all the things in a rectangle region.
	 * @param tl the top left corner of the rectangle region.
	 * @param br the bottom right corner of the rectangle region.
	 *
	 * @return A ArrayList of things in this region.
	 *
	 */
	public ArrayList<Thing> getRectangleRegion(Position tl, Position br)
	{
		ArrayList<Thing> thingsInRegion = new ArrayList<Thing>();

		ArrayList<Position> region = new ArrayList<Position>();

		for (int i = tl.x; i <= br.x; i++)
		{
			for (int j = tl.y; j <= br.y; j++)
			{
				region.add(new Position(i, j));
			}
		}

		thingsInRegion = getRegion(region);


		return thingsInRegion;
	}


	/**
	 * Get all the things in the world.
	 * @return All the things in the world.
	 */
	public ArrayList<Thing>  getListOfThings()
	{
		return things;
	}

	/**
	 * getToBeRemoved list.
	 */
	public ArrayList<Thing> getToBeRemoved()
	{
	    return toBeRemoved;
	}

	/**
	 * get Things to be added
	 */
	public ArrayList<Thing> getToBeDraw()
	{
	    return toBeDraw;
	}


}
