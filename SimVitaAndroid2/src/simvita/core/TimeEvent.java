package simvita.core;

/**
 *  The entry for the TimeLogic's priority Queue. Bundles a creature with a Time
 *  and sorts by time.
 *
 *  @author Nate Craun (ncraun)
 *  @version 2012.12.09
 */
public class TimeEvent implements Comparable<TimeEvent>
{
    /**
     * The time of the event.
     */
    public long time;
    /**
     * The creature with the event.
     */
    public Creature creature;

    /**
     * Create a new TimeEvent.
     *
     * @param time The time of the event.
     * @param creature The creature who acts at that time.
     */
    public TimeEvent(long time, Creature creature)
    {
        this.time = time;
        this.creature = creature;
    }

    /**
     * Compare two time events.
     *
     * @param t the event to compare with.
     *
     * @return < 0 if this is less than t, = 0 if they are the same, > 0 if this
     * is greater
     */
    public int compareTo(TimeEvent t)
    {
        return Long.valueOf(this.time).compareTo(t.time);
    }

    /**
     * See if two TimeEvents are Equal.
     *
     * @param t The time event to check.
     * @return true if equal, otherwise false
     */
    public boolean equals(TimeEvent t)
    {
        return time == t.time && creature == t.creature;
    }

    /**
     * Return a String representing the Event.
     *
     * @return String representing Event.
     */
    public String toString()
    {
        return time+": "+creature;
    }

}
