package simvita.core;

public class TimeEvent implements Comparable<TimeEvent>
{
    public long time;
    public Creature creature;

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
