package simvita.core;

// -------------------------------------------------------------------------
/**
 *  Interface that specifies the type of reproduction creatures have. some are
 *  asexual, others are sexual, and others are barren.
 *
 *  @author verro ejiba
 *  @version Nov 6, 2012
 */
public interface Reproduce
{
    // ----------------------------------------------------------
    /**
     * Reproductive method for those creatures that don't need partners to
     * reproduce
     * @param c the name of the creature
     */
    void asexual(Creature c);

    // ----------------------------------------------------------
    /**
     * Creatures who depend on other creature to make new creatures of the same
     * type
     * @param c the name of the creature
     */
    void sexual(Creature c);

    // ----------------------------------------------------------
    /**
     * Creature that can't reproduce
     * @param c the name of the creature
     */
    void barren(Creature c);


}
