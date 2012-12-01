package simvita.core;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * The Main Time Logic. Uses Discrete Event simulation to model the passing of
 * time in the world. At each point in time, all relevant creatures will have
 * their act method called and be requeued at their next acting point. To
 * safeguard against exceeding the limits of a 32bit long, there will be an
 * automatic rollover.
 *
 * Time starts from 0.
 *
 * @author Nate Craun
 */
public class TimeLogic
{
    private PriorityQueue<TimeEvent> timeQueue;
    private PriorityQueue<TimeEvent> rollOverTimeQueue;
    private World world;

    /**
     * Create a new TimeLogic object using new, default world, and queues.
     */
    public TimeLogic()
    {
        this(new PriorityQueue<TimeEvent>(), new PriorityQueue<TimeEvent>(),
            new World());
    }


    /**
     * Create a new TimeLogic object with specified world, and queues.
     *
     * @param timeQueue
     * @param rollOverTimeQueue
     * @param world
     */
    public TimeLogic(PriorityQueue<TimeEvent> timeQueue,
        PriorityQueue<TimeEvent> rollOverTimeQueue, World world)
    {
        this.timeQueue = timeQueue;
        this.rollOverTimeQueue = rollOverTimeQueue;
        this.world = world;
    }

    /**
     * Get the Main Queue.
     *
     * @return The Main Queue.
     */
    public PriorityQueue<TimeEvent> getMainQueue()
    {
        return timeQueue;
    }

    /**
     * Get the Rollover Queue.
     *
     * @return The Rollover Queue.
     */
    public PriorityQueue<TimeEvent> getRollOverQueue()
    {
        return rollOverTimeQueue;
    }

    /**
     * Get the World.
     *
     * @return The world.
     */
    public World getWorld()
    {
        return world;
    }

    /**
     * Initialize the TimeQueue, using creatures from the world.
     */
    public void init()
    {
        for (Thing t : world.getListOfThings())
        {
            if (t instanceof Creature)
            {
                Creature c = (Creature) t;
                timeQueue.add(new TimeEvent(c.getActFrequency(), c));
            }
        }
    }

    /**
     * Process the next TimeEvent. This will call the act method of the next
     * creature who is supposed to act, and then requeue it, possibly using the
     * rollOver buffer if necessary. Note that the next time event does not mean
     * each second will be processed. If nothing is supposed to happen at a
     * certain time, we'll just skip to the point in time where the next event
     * is located.
     *
     * @return The TimeEvent in question, and null if nothing happened.
     */
    public ArrayList<Thing> tick()
    {
        ArrayList<Thing> toRemove = new ArrayList<Thing>();
        TimeEvent t = null;
        // timeQueue
        if (timeQueue.size() > 0)
        {
            t = timeQueue.poll();

            //act
            ArrayList<Thing> newThings = t.creature.act(world);
            if (newThings != null)
            {
                for (Thing th : newThings)
                {
                    if (th instanceof Creature)
                    {
                        Creature c = (Creature) th;
                        timeQueue.add(new TimeEvent(c.getActFrequency() + t.creature.getActFrequency() + t.time, c));
                    }
                }
            }

            //requeue
            // Check for overflow.

            if (!t.creature.isDead())
            {

                if (t.time >= Long.MAX_VALUE - t.creature.getActFrequency())
                {
                    // Go to overflow.
                    t.time = t.creature.getActFrequency() - (Long.MAX_VALUE - t.time); //Long.MAX_VALUE - t.time - t.creature.getActFrequency();
                    rollOverTimeQueue.offer(t);
                }
                else
                {
                    // Change the time to the next time it should be enacted
                    t.time += t.creature.getActFrequency();
                    // Requeue
                    timeQueue.offer(t);
                }
            }
            else
            {
                toRemove.add(t.creature);
            }
        }
        else
        {
            // Main Queue is empty, switch to rollOver
            if (rollOverTimeQueue.size() > 0)
            {
                timeQueue = rollOverTimeQueue;
                rollOverTimeQueue = new PriorityQueue<TimeEvent>();
            }
            else
            {
                // No Events Queued up at all.
                // should anything be done here?
            }
        }

        System.out.println("w:"+world.getListOfThings()+" pq:"+timeQueue);
        return toRemove;
    }


    /**
     * Process the next n time events.
     *
     * @param n
     *            The Number of time events to process.
     */
    public void tick(int n)
    {
        for (int i = 0; i < n; i++)
        {
            tick();
        }
    }

    /**
     * Process all time events in the queue, and continue to process throughout
     * requeueing until and overflow, until there are no events left.
     */
    public void tickAll()
    {
        // Tick until all events exhausted
        while (timeQueue.size() > 0)
        {
            tick();
        }
    }

}
