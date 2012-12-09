package simvita.core;

import java.util.ArrayList;
import sofia.app.Screen;
import android.widget.TextView;



public class StatsScreen extends Screen
{
    TextView eagleCount;
    TextView plantCount;
    TextView turtleCount;

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

    public void returnButtonClicked()
    {
        finish();
    }
}
