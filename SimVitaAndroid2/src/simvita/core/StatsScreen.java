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

        //System.out.println(cl);

        for (Creature c : cl)
        {
            if (c instanceof Vine)
            {
                //System.out.println("plant");
                plant++;
            }
            else if (c instanceof TurtleA)
            {
                //System.out.println("t");
                turtle++;
            }
            else if (c instanceof Eagle)
            {
                System.out.println("e");
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
