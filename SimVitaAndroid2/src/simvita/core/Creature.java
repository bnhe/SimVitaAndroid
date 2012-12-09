package simvita.core;

import sofia.graphics.Shape;
import sofia.graphics.OvalShape;
import sofia.graphics.Color;
import java.util.ArrayList;

/**
 * Creature are things that have life or life-like behavior;
 *
 */

/**
 * @author Sihui Zhang
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
    public Shape shape;
    public int value;



    //~Constructors------------------------------------------------------------

    public Creature(Position p)
    {
        this(p, "a Name");
    }

    /**
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param desc The detailed description of the creature.
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
     * @param desc The detailed description of the creature.
     * @param stEffects A list of StatusEffect.

     */
    public Creature(Position x, String aName)
    {
        this(x, aName, 5, null);
    }


    /**
     * Create a Creature with a list of StatusEffect and act frequency.
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param desc The detailed description of the creature.
     * @param stEffects A list of StatusEffect.
     * @param frequency a frequency of act.
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


    public Creature getFoodCreature()
    {
        return foodCreature;
    }

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
     *
     * @param w The world the creature acts upon.
     */
    public void act(TimeLogic tl)
    {

    }

    public String toString()
    {
        return name;
    }
}
