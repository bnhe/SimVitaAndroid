package simvita.core;

import sofia.graphics.OvalShape;
import sofia.graphics.Shape;
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
public class SimpleCreature extends Thing
{

    //~Fields------------------------------------------------------------------

    private ArrayList<StatusEffect<SimpleCreature>> statusEffects;
    private int actFrequency;
    private boolean dead;


    //~Constructors------------------------------------------------------------
    /**
     * @param x The position in the world.
     * @param c
     * @param f
     */
    public SimpleCreature(Position x, Color c, int f)
    {
        this(x, "aName", new Description("",""), c, null, 1, new OvalShape(0, 0, 1, 1));
    }






    /**
     * Create a Creature with a list of StatusEffect and act frequency.
     * @param x The position in the world.
     * @param aName The name of the creature.
     * @param desc The detailed description of the creature.
     * @param c color of the creature
     * @param stEffects A list of StatusEffect.
     * @param frequency a frequency of act.
     * @param s
     */
    public SimpleCreature(Position x, String aName, Description desc, Color c,
        ArrayList<StatusEffect<SimpleCreature>> stEffects, int frequency, Shape s)
    {
        super(x, aName, desc, c, s);

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
    public void addStatusEffect(StatusEffect<SimpleCreature> s)
    {
        statusEffects.add(s);
    }


    // ----------------------------------------------------------
    /**
     * Remove a StatusEffect.
     * @param s a StatusEffect.
     */
    public void removeStatusEffect(StatusEffect<SimpleCreature> s)
    {
        statusEffects.remove(s);
    }


    // ----------------------------------------------------------
    /**
     * Remove all StatusEffect.
     */
    public void clearStatusEffects()
    {
        statusEffects = new ArrayList<StatusEffect<SimpleCreature>>();
    }


    // ----------------------------------------------------------
    /**
     * Determine if a StatusEffect is available.
     * @param s a StatusEffect.
     * @return true if a StatusEffect is available false otherwise.
     */
    public boolean hasStatusEffect(StatusEffect<SimpleCreature> s)
    {
        return !(statusEffects.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Return the list of StatusEffect.
     * @return the list of StatusEffect
     */
    public ArrayList<StatusEffect<SimpleCreature>> getStatusEffects()
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
