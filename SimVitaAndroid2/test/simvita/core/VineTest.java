package simvita.core;

import sofia.util.Random;

/**
 * Test the Vine class.
 *
 * @author Nate Craun
 * @version Dec 9, 2012
 */

public class VineTest
    extends student.TestCase
{
    private TimeLogic game;
    private Vine      v;


    /**
     * Set up.
     */
    public void setUp()
    {
        game = new TimeLogic(20);
        v = new Vine();
    }


    /**
     * Test replication of the Vine.
     */
    public void testReplicate()
    {
        Random.setNextInts(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2);
        game.addCreature(v);
        assertEquals(1, game.getWorld().getListOfCreatures().size());

        for (int i = 0; i < 12; i++)
        {
            game.tick();
        }

        assertEquals(2, game.getWorld().getListOfCreatures().size());
    }


    /**
     * Test that the vine will die.
     */
    public void testDie()
    {
        Random.setNextInts(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        game.addCreature(v);
        assertEquals(1, game.getWorld().getListOfCreatures().size());

        for (int i = 0; i < 31; i++)
        {
            game.tick();
        }

        assertEquals(0, game.getWorld().getListOfCreatures().size());

    }

}