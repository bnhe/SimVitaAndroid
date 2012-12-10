package simvita.core;


// -------------------------------------------------------------------------
/**
 *  Interface for status effect holds abstract methods (effect, isDone, and
 *  equals) to give the current status of a creature when an action is done on
 *  it
 *
 *  @author verro ejiba
 *  @author Nate Craun
 *  @version Nov 1, 2012
 */
public interface StatusEffect<C>
{

    // ----------------------------------------------------------
    /**
     * the effect of a given creature on another creature,
     * @param c the name of the creature
     */
    void effect(C c);

    // ----------------------------------------------------------
    /**
     * True if the effect is done and false otherwise
     * @return true is the action is done and false if otherwise.
     */
    boolean isDone();

}
