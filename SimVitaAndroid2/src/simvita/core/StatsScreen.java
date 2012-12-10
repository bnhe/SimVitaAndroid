package simvita.core;

import java.util.ArrayList;
import sofia.app.Screen;
import android.widget.TextView;

/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author nate
 *  @version Dec 9, 2012
 */
public class StatsScreen extends Screen
{
    private TextView eagleCount;
    private TextView plantCount;
    private TextView turtleCount;

    /**
     * Create this StatsScreen.
     *
     * @param cl A list of all the creatures in the world.
     */
    public void initialize(ArrayList<Creature> cl)
    {
        int eagle = 0;
        int plant = 0;
        int turtle = 0;

        for (Creature c : cl)
        {
            if (c instanceof Vine)
            {
                plant++;
            }
            else if (c instanceof TurtleA)
            {
                turtle++;
            }
            else if (c instanceof Eagle)
            {
                eagle++;
            }
        }

        eagleCount.setText("Eagle: "+Integer.toString(eagle));
        plantCount.setText("Plant: "+Integer.toString(plant));
        turtleCount.setText("Turtle: "+Integer.toString(turtle));
    }

    /**
     * Player clicked return, they're done looking at stats. Back to the Game!
     */
    public void returnButtonClicked()
    {
        finish();
    }
}
