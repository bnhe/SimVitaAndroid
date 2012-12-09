package simvita.core;

import java.util.ArrayList;

public class Controller
{
    private TimeLogic timeLogic;

    public Controller()
    {
        //this(new TimeLogic(10));
    }

    public Controller(TimeLogic t)
    {
        timeLogic = t;
    }

    public void addCreature(Creature c, Position p)
    {
        timeLogic.getWorld().addThing(c, p);
    }

    public ArrayList<Thing> getListOfThings()
    {
        return timeLogic.getWorld().getListOfThings();
    }

    public void tick(int n)
    {
        for (int i = 0; i < n; i++)
        {
            this.tick();
        }
    }

    public void tick()
    {
        timeLogic.tick();
    }

}
