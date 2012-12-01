package simvita.core;

// -------------------------------------------------------------------------
/**
 *  Contains different methods that a natural creature can have and their
 *  descriptions.
 *
 *  @author verro ejiba
 *  @version Nov 7, 2012
 */
public interface NaturalCreature
{
    // ----------------------------------------------------------
    /**
     * Tells us how much energy a given creature has
     * @return the energy level of the creature
     */
    public int getEnergyLevel();
    
    /**
     * Tells us how much energy a given creature has
     * @return the energy level of the creature
     */
    public void setEnergyLevel(int level);

    // ----------------------------------------------------------
    /**
     * Tells how old the creature is and if the creature is so old it's easier
     * for it to die and/or to get sick
     * @return age of the creature
     */
    public int age();

    // ----------------------------------------------------------
    /**
     * Tells if a given creature had been affected by a poison or
     * if it's a poisonous creature
     * @return true if a given creature has poison and false if otherwise
     */
    public boolean poison();

    // ----------------------------------------------------------
    /**
     * A creature dies when it has low energy, it's advanced in age, and when
     * it's affected with a poison that its body can't handle.
     */
    public void die();

    // ----------------------------------------------------------
    /**
     * Tells the move of the creature
     * @param p the position to which a creature is moving.
     */
    public void move(Position p);

    // ----------------------------------------------------------
    /**
     * When a creature eats another one its level of energy increases when
     * the food wasn't poisoned but if the food was poisoned the energy
     * decreases and returns true for the method poison
     * @param c the creature that has been eaten
     */
    public void eat(Creature c);

    // ----------------------------------------------------------
    /**
     * This is the ability for a creature to see
     * @param p the extent to which this creature can see
     */
    public void sensors(Position p);

    // ----------------------------------------------------------
    /**
     * A creature sleeps only after eating. A creature whose asleep can be
     * eaten at any moment by the preys.
     * @return true if the creature is sleeping and false if otherwise
     */
    public boolean sleep();


}
