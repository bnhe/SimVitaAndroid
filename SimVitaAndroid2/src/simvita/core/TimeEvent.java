package simvita.core;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Nate Craun
 *  @version Dec 6, 2012
 */
public class TimeEvent implements Comparable<TimeEvent>
{
    public long time;
    public Creature creature;

    // ----------------------------------------------------------
    /**
     * Create a new TimeEvent object.
     * @param time
     * @param creature
     */
    public TimeEvent(long time, Creature creature)
    {
        this.time = time;
        this.creature = creature;
    }

    public int compareTo(TimeEvent t)
    {
        return Long.valueOf(this.time).compareTo(t.time);
    }

    public String toString()
    {
        return time+": "+creature;
    }

}
