package simvita.core;

// -------------------------------------------------------------------------
/**
 *  Test cases for the screen.
 *
 *  @author verro ejiba
 *  @version 2012.12.06
 */
public class SimVitaScreenTests extends student.AndroidTestCase<SimVitaScreen>
{
    private TimeLogic game;
    private SimVitaScreen screen;
    private Creature c;
    private World world;


    // ----------------------------------------------------------
    /**
     * Create a new SimVitaScreenTests object.
     */
    public SimVitaScreenTests()
    {
        super(SimVitaScreen.class);
    }

    public void setUp()
    {
        this.game = new TimeLogic();
        this.screen = new SimVitaScreen();
        this.world = new World();
    }

    // ----------------------------------------------------------
    /**
     * Tests that a shape and creature were added to the screen
     */
    public void testAddCreatureAndShape()
    {
       screen.addCreatureAndShape(c);
       assertTrue(world.isCreaturePresent());
    }

    // ----------------------------------------------------------
    /**
     * Tests that a shape was added to the screen
     */
    public void testAddShape()
    {
        // not sure how to test it.
    }

    // ----------------------------------------------------------
    /**
     * Tests that a shape was removed
     */
    public void testRemoveShape()
    {
        // not sure how to test this
    }

    // ----------------------------------------------------------
    /**
     * test
     */
    public void testRemoveCreatureAndShape()
    {
        screen.removeCreatureAndShape(c);
        assertTrue(world.creatureNotPresent());
    }
}
