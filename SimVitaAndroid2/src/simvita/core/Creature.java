package simvita.core;

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
public class Creature extends Thing
{

    //~Fields------------------------------------------------------------------

    private ArrayList<StatusEffect<Creature>> statusEffects;
    private int actFrequency;
    private boolean dead;


    //~Constructors------------------------------------------------------------
    /**
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param desc The detailed description of the creature.
     */
    public Creature(Position x, String aName, Description desc, Color c)
    {
        this(x, aName, desc, c, new ArrayList<StatusEffect<Creature>>());
    }

    /**
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param desc The detailed description of the creature.
     * @param freq The frequency.
     */
    public Creature(Position x, String aName, Description desc, Color c, int freq)
    {
        this(x, aName, desc, c, new ArrayList<StatusEffect<Creature>>(), freq);
    }


    /**
     * Create a Creature with a list of StatusEffect.
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param desc The detailed description of the creature.
     * @param stEffects A list of StatusEffect.

     */
    public Creature(Position x, String aName, Description desc, Color c,
        ArrayList<StatusEffect<Creature>> stEffects)
    {
        this(x, aName, desc, c, stEffects, 5);
    }


    /**
     * Create a Creature with a list of StatusEffect and act frequency.
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param desc The detailed description of the creature.
     * @param stEffects A list of StatusEffect.
     * @param frequency a frequency of act.
     */
    public Creature(Position x, String aName, Description desc, Color c,
        ArrayList<StatusEffect<Creature>> stEffects, int frequency)
    {
        super(x, aName, desc, c);

        statusEffects = stEffects;

        actFrequency = frequency;
        dead = false;
    }


    //~ Methods -----------------------------------------

    // ----------------------------------------------------------
    /**
     * Add a StatusEffect.
     * @param s a StatusEffect.
     */
    public void addStatusEffect(StatusEffect<Creature> s)
    {
        statusEffects.add(s);
    }


    // ----------------------------------------------------------
    /**
     * Remove a StatusEffect.
     * @param s a StatusEffect.
     */
    public void removeStatusEffect(StatusEffect<Creature> s)
    {
        statusEffects.remove(s);
    }


    // ----------------------------------------------------------
    /**
     * Remove all StatusEffect.
     */
    public void clearStatusEffects()
    {
        statusEffects = new ArrayList<StatusEffect<Creature>>();
    }


    // ----------------------------------------------------------
    /**
     * Determine if a StatusEffect is available.
     * @param s a StatusEffect.
     * @return true if a StatusEffect is available false otherwise.
     */
    public boolean hasStatusEffect(StatusEffect<Creature> s)
    {
        return !(statusEffects.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Return the list of StatusEffect.
     * @return the list of StatusEffect
     */
    public ArrayList<StatusEffect<Creature>> getStatusEffects()
    {
        return statusEffects;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return actFrequency.
     */
    public int getActFrequency()
    {
        return actFrequency;
    }

    /**
     *
     */
    public boolean isDead()
    {
        return dead;
    }

    public void kill()
    {
        dead = true;
        color = Color.gray;
    }
}
