package simvita.core;

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

    /**
     * Set up.
     */
    public void setUp()
    {
        p = new Position(5, 4);
        name = "Test";
        frequency = 5;
        creature = new Creature(p, name, frequency);
    }

    /**
     * Test the constructor.
     */
    public void testConstructor()
    {
        assertEquals("Test", creature.getName());
        assertEquals(p, creature.getPosition());
        assertEquals(5, creature.getActFrequency());
        assertEquals(0, creature.value);
    }

    /**
     * Test setter functions.
     */
    public void testSetters()
    {
        Position px = new Position(20, 20);
        TurtleA t = new TurtleA();

        creature.setPosition(px);
        creature.setFoodCreature(t);

        assertEquals(px, creature.getPosition());
        assertEquals(t, creature.getFoodCreature());
    }

    /**
     * Test toString
     */
    public void testToString()
    {
        assertEquals("Test", creature.toString());
    }

}