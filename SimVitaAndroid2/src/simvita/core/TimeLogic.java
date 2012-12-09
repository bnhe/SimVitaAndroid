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
    private World world;
    private long clock;
    private ArrayList<Creature> removeOnNextTick;
    private long money;
    private long endTurn;
    private int maxCreatures;
    private int numPlants;

    /**
     * Create a new TimeLogic object using new, default world, and queues.
     */
    public TimeLogic(long endTurn)
    {
        this(new PriorityQueue<TimeEvent>(),
            new World());
        clock = 0;
        this.endTurn = endTurn;
    }


    /**
     * Create a new TimeLogic object with specified world, and queues.
     *
     * @param timeQueue
     * @param rollOverTimeQueue
     * @param world
     */
    public TimeLogic(PriorityQueue<TimeEvent> timeQueue, World world)
    {
        this.timeQueue = timeQueue;
        this.world = world;
        this.removeOnNextTick = new ArrayList<Creature>();
        maxCreatures = 250;
        numPlants = 0;

        for (Creature c : world.getListOfCreatures())
        {
            timeQueue.add(new TimeEvent(c.getActFrequency(), c));
        }
    }

    public boolean isOver()
    {
        Vine v = new Vine();
        return clock >= endTurn || (numPlants == 0 && money < v.value);
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
        if (world.getListOfCreatures().size() < maxCreatures)
        {
            if (c instanceof Vine)
            {
                numPlants++;
            }
            world.addCreature(c, c.getPosition());
            timeQueue.add(new TimeEvent(clock + c.getActFrequency(), c));
        }
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
        if (c instanceof Vine)
        {
            numPlants--;
        }
        world.removeCreature(c);
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
                // Check for overflow.
                if (t.time < Long.MAX_VALUE - t.creature.getActFrequency())
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
