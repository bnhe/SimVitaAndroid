package simvita.core;

/**
 * Add a specified amount of life from the creature, for a certain amount
 * of time.
 * To function as a healer, set life to a positive amount. To function as a
 * poison, set life to a negative amount.
 *
 * @author Nate Craun
 */
public class LifeChanger implements StatusEffect<NaturalCreature>
{
    private int life;
    private int times;

    /**
     * Creates a new LifeChanger object with the specified parameters.
     *
     * @param life The amount of life to add each time.
     * @param times The number of times to take life away.
     */
    public LifeChanger(int life, int times)
    {
        this.life = life;
        this.times = times;
    }

    /**
     * When the energy of a creature decreases.
     */
    public void effect(NaturalCreature c)
    {
        if (times >= 0)
        {
            c.setEnergyLevel(c.getEnergyLevel() - life);
            times--;
        }
    }
    /**
     * isDone
     * @return true when the time is zero
     */
    public boolean isDone()
    {
        return times == 0;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param s
     * @return
     */
    public boolean equals(StatusEffect<NaturalCreature> s)
    {
        LifeChanger lc = (LifeChanger)s;
        return lc.life == this.life && lc.times == this.times;
    }

}
