package simvita.core;

import sofia.graphics.Shape;
import sofia.graphics.OvalShape;

/**
 * Creature are things that have life or life-like behavior;
 *
 */

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Art
 *  @version Dec 9, 2012
 */
/**
 * @author Sihui Zhang
 * @auther Bin He
 * @version 2012.11.1
 *
 */
public class Creature
{

    //~Fields------------------------------------------------------------------

    private int actFrequency;
    private Creature foodCreature;
    private Position    curPosition;
    private String      name;
    /**
     * The shape of the creature
     */
    public Shape shape;
    /**
     * The cost of the creature;
     */
    public int value;



    //~Constructors------------------------------------------------------------

    // ----------------------------------------------------------
    /**
     * Create a new Creature object.
     * @param p The position of the creature;
     */
    public Creature(Position p)
    {
        this(p, "a Name");
    }

    /**
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param freq The frequency.
     */
    public Creature(Position x, String aName, int freq)
    {
        this(x, aName, freq, null);
    }


    /**
     * Create a Creature with a list of StatusEffect.
     * @param x The position in the world.
     * @param aName The name of the creature.

     */
    public Creature(Position x, String aName)
    {
        this(x, aName, 5, null);
    }


    /**
     * Create a Creature with a list of StatusEffect and act frequency.
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param frequency a frequency of act.
     * @param s The shape of the creature.
     */
    public Creature(Position x, String aName, int frequency, OvalShape s)
    {
        curPosition = x;
        name = aName;
        shape = s;
        actFrequency = frequency;
        /*
        try
        {
            foodCreature =   (Creature) Class.forName("simvita.core.Vine").newInstance();
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        */

        foodCreature = null;
    }


    //~ Methods -----------------------------------------

    // ----------------------------------------------------------
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return actFrequency.
     */
    public int getActFrequency()
    {
        return actFrequency;
    }


    // ----------------------------------------------------------
    /**
     * Get the food creature type
     * @return The food creature of the current creature.
     */
    public Creature getFoodCreature()
    {
        return foodCreature;
    }

    // ----------------------------------------------------------
    /**
     * Set the food creature type.
     * @param food What this creature eat.
     */
    public void setFoodCreature(Creature food)
    {
        foodCreature = food;
    }
    /**
     * Set the position of the thing in the world.
     *
     * @param x
     *            the position in the world.
     */
    public void setPosition(Position x)
    {
        curPosition = x;
    }


    // ----------------------------------------------------------
    /**
     * Get the current position of this thing.
     *
     * @return current position
     */
    public Position getPosition()
    {
        return curPosition;
    }

    /**
     * Get the name of the type of the Thing.
     *
     * @return The name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     * @param tl The time logic it act on.
     */
    public void act(TimeLogic tl)
    {
        //
    }

    public String toString()
    {
        return name;
    }
}
