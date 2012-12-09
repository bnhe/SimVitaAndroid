package simvita.core;

import sofia.app.Screen;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author verro ejiba
 *  @author Nate Craun
 *  @version Dec 1, 2012
 */
public class AddCreatureScreen extends Screen
{
    private CreatureAdd creatureAdd;
    private World world;
    private float cellS;
    private TimeLogic game;
    private TextView eagleCost;
    private TextView plantCost;


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void initialize(CreatureAdd creatureAdd)
    {
        eagleCost.setText(Integer.toString(new Eagle().value));
        plantCost.setText(Integer.toString(new Vine().value));
        this.creatureAdd = creatureAdd;
    }

    public void turtleClicked()
    {
        selectCreature("TurtleA");
    }

    public void plantClicked()
    {
        selectCreature("Vine");
    }

    public void eagleClicked()
    {
        selectCreature("Eagle");
    }

    private void selectCreature(String creatureClass)
    {
        creatureAdd.addType = "simvita.core."+creatureClass;
        finish();
    }
}
