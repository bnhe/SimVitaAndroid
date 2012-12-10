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

    private ArrayList<Creature> things;
    private ArrayList<Creature> toBeRemoved;
    /**
     * The things need to be draw on screen.
     */
    public ArrayList<Creature> toBeDraw;
    /**
     * All the things that will move.
     */
    public ArrayList<Creature> toBeMoved;

    /**
     * Create a new empty world.
     */
    public World()
    {
        things = new ArrayList<Creature>();
        toBeRemoved = new ArrayList<Creature>();
        toBeDraw = new ArrayList<Creature>();
        toBeMoved = new ArrayList<Creature>();
    }

    /**
     * Create a world with a list of things in it.
     * @param things The list of things alread in the world.
     *
     */
    public World(ArrayList<Creature> things)
    {
        this.things = things;
    }

    /**
     * Add a thing in the world.
     * @param c The creature to be added.
     * @param x The position tha the thing been add to the world.
     */
    public void addCreature(Creature c, Position x)
    {
        c.setPosition(x);
        things.add(c);
        toBeDraw.add(c);
    }

    /**
     * Remove a certain thing in the world.
     * @param c The creature to be removed.
     */
    public void removeCreature(Creature c)
    {
        things.remove(c);
        toBeRemoved.add(c);
    }

    /**
     * Clear all things in the world.
     */
    public void clearThings()
    {
        things = new ArrayList<Creature>();
    }

    /**
     * Get all the Creatures in the world.
     * @return All the Creatures in the world.
     */
    public ArrayList<Creature>  getListOfCreatures()
    {
        return things;
    }

    /**
     * getToBeRemoved list.
     * @return A list of things need to be removed.
     */
    public ArrayList<Creature> getToBeRemoved()
    {
        return toBeRemoved;
    }

    /**
     * get Things to be added
     * @return A list of Creatures to be draw on screen.
     */
    public ArrayList<Creature> getToBeDraw()
    {
        return toBeDraw;
    }

    /**
     * get Things to be added
     * @return A list of creatrues to be moved.
     */
    public ArrayList<Creature> getToBeMoved()
    {
        return toBeMoved;
    }

    /**
     * Get the nearest target.
     * @param predator The predator object.
     * @return The nearest food of the predator.
     *
     * @returns The nearest food object that a predator eats, or null if there
     * are none of them in the world.
     */
    public Creature getNearestFood(Creature predator)
    {
        Creature nearestFood = null;
        double nearestDistance = Double.POSITIVE_INFINITY;

        if (this.getListOfCreatures() != null)
        {
            for (Creature c : this.getListOfCreatures())
            {
                if (c.getClass().equals(predator.getFoodCreature().getClass()))
                {
                    double distance = predator.getPosition().distanceTo(c.getPosition());
                    if (distance < nearestDistance)
                    {
                        nearestFood = c;
                        nearestDistance = distance;
                    }
                }
            }
        }

        return nearestFood;
    }
}
