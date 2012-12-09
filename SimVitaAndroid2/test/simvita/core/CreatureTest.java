package simvita.core;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Test cases for the Creature class.
 *
 * @author verro ejiba
 * @author Nate Craun
 * @version Dec 6, 2012
 */
public class CreatureTest extends student.TestCase
{
    private Creature creature;
    private Position p;
    private String name;
    private int frequency;
    private Creature creature2;
    private Position curPosition;

    public void setUp()
    {
        creature = new Creature(p, name, frequency);
        creature2 = new Creature(p, name);
    }


}