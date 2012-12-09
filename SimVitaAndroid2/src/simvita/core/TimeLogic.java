package simvita.core;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * The Main Time Logic. Uses Discrete Event simulation to model the passing of
 * time in the world. At each point in time, all relevant creatures will have
 * their act method called and be requeued at their next acting point.
 *
 * Time starts from 0.
 *
 * @author Nate Craun
 */
public class TimeLogic
{
    private PriorityQueue<TimeEvent> timeQueue;
    private World world;
    private long clock;
    private ArrayList<Creature> removeOnNextTick;
    private long money;
    private long endTurn;

    /**
     * Create a new TimeLogic object using new, default world, and queues.
     */
    public TimeLogic(long endTurn)
    {
        clock = 0;
        this.timeQueue = new PriorityQueue<TimeEvent>();
        this.world = new World();
        this.removeOnNextTick = new ArrayList<Creature>();
        this.endTurn = endTurn;

        init();
    }

    public boolean isOver()
    {
        return clock >= endTurn;
    }

    public long getClock()
    {
        return clock;
    }

    public void setMoney(long money)
    {
        this.money = money;
    }

    public long getMoney()
    {
        return money;
    }

    public void addMoney(long m)
    {
        money += m;
    }

    public void subtractMoney(long m)
    {
        money -= m;
    }

    /**
     * Adds a Creature the world and to the TimeLogic.
     */
    public void addCreature(Creature c)
    {
        world.addThing(c, c.getPosition());
        timeQueue.add(new TimeEvent(clock + c.getActFrequency(), c));
    }

    /**
     * Adds a Creature the world and to the TimeLogic.
     */
    public void moveCreature(Creature c, Position p)
    {
        c.setPosition(p);
        world.getToBeMoved().add(c);
    }

    /**
     * Removes a Creature the world and to the TimeLogic.
     */
    public void removeCreature(Creature c)
    {
        world.removeThing(c);
        removeOnNextTick.add(c);
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
    private void init()
    {
        for (Creature c : world.getListOfCreatures())
        {
            timeQueue.add(new TimeEvent(c.getActFrequency(), c));
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
    public void tick()
    {
        TimeEvent t = null;
        // timeQueue
        if (timeQueue.size() > 0)
        {
            //advance in time
            t = timeQueue.poll();
            clock = t.time; //+ t.creature.getActFrequency() + 1;

            //See if we should remove it
            if (removeOnNextTick.contains(t.creature))
            {
                //remove it, we won't queue it up.
                removeOnNextTick.remove(t.creature);
            }
            else
            {
                //act
                t.creature.act(this);

                //requeue
                if (t.time >= Long.MAX_VALUE - t.creature.getActFrequency())
                {
                    // Change the time to the next time it should be enacted
                    t.time += t.creature.getActFrequency();
                    // Requeue
                    timeQueue.offer(t);
                }
            }
        }
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

}
