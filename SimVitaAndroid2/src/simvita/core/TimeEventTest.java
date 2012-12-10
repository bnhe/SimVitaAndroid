package simvita.core;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author verro ejiba
 *  @version Dec 7, 2012
 */
public class TimeEventTest extends student.TestCase
{
    private TimeEvent event;
    private TimeEvent event2;
    private Creature turtle;
    private Creature bacteria;

    public void setUp()
    {
        event = new TimeEvent(20, turtle);
        event2 = new TimeEvent(10, bacteria);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testCompareTo()
    {
        assertEquals(1, event.compareTo(event2));
        assertEquals(0, event.compareTo(event));
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testToString()
    {
        assertEquals("20: turtle", event.toString());
    }
}
