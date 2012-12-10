package simvita.core;

import sofia.graphics.Shape;

/**
 * Creature are things that have life or life-like behavior.
 *
 * They exist in the world to perform actions. All logic is done by the
 * creature, passing world as parameter. In this way we can easily create new
 * creatures to extend functionality, without changing the world class.
 */

/**
 * @author Sihui Zhang (sihuiz07)
 * @author Nate Craun (ncraun)
 * @version 2012.12.09
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
     * The Shape of the creature.
     */
    public Shape shape;
    /**
     * How much the creature costs to add to the world.
     */
    public int value;



    //~Constructors------------------------------------------------------------

    /**
     * Create a new Creature.
     *
     * @param p The Position of the Creature.
     */
    public Creature(Position p)
    {
        this(p, "a Name");
    }

    /**
     * Create a new Creature.
     *
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param freq The frequency.
     */
    public Creature(Position x, String aName, int freq)
    {
        this(x, aName, freq, null);
    }


    /**
     * Create a Creature.
     *
     * @param x The position in the world.
     * @param aName The name of the creature.
     */
    public Creature(Position x, String aName)
    {
        this(x, aName, 5, null);
    }


    /**
     * Create a Creature.
     *
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param frequency a frequency of act.
     * @param s The Shape of the creature.
     */
    public Creature(Position x, String aName, int frequency, Shape s)
    {
        curPosition = x;
        name = aName;
        shape = s;
        actFrequency = frequency;
        foodCreature = null;
    }


    //~ Methods -----------------------------------------

    /**
     * Place a description of your method here.
     * @return actFrequency.
     */
    public int getActFrequency()
    {
        return actFrequency;
    }


    /**
     * Get the Creature type that this creature will eat.
     *
     * @return The food creature.
     */
    public Creature getFoodCreature()
    {
        return foodCreature;
    }

    /**
     * Set the creature type this creature will eat.
     *
     * @param food The food creature.
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
     *
     * @param tl The TimeLogic the creature acts upon.
     */
    public void act(TimeLogic tl)
    {
        //Nothing here, default action is nothing
        //subclasses will extend with their own actions.
    }

    /**
     * Get String representation of this Creature
     *
     * @return The creature's name.
     */
    public String toString()
    {
        return name;
    }
}
