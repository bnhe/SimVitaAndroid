package simvita.core;

/**
 * Test for the TimeEvent class.
 *
 * @author verro ejiba
 * @author Nate Craun
 * @version Dec 7, 2012
 */

public class TimeEventTest extends student.TestCase
{
    private TimeEvent event;
    private TimeEvent event2;
    private TurtleA t;
    private Creature c1;
    private Creature c2;

    /**
     * Set up.
     */
    public void setUp()
    {
        c1 = new Creature(new Position(0,0), "t1", 10);
        c2 = new Creature(new Position(0,0), "t1", 20);
        event = new TimeEvent(10, c1);
        event2 = new TimeEvent(20, c2);
    }

    /**
     * Test compareTo
     */
    public void testCompareTo()
    {
        assertTrue(event.compareTo(event2) < 0);
        assertTrue(event2.compareTo(event) > 0);
        assertEquals(0, event.compareTo(event));
    }

    /**
     * Test equals.
     */
    public void testEquals()
    {
        assertTrue(event.equals(event));
        assertTrue(event.equals(new TimeEvent(10, c1)));
        assertFalse(event.equals(event2));
    }


    /**
     * Test to string.
     */
    public void testToString()
    {
        assertEquals("10: t1", event.toString());
    }
}