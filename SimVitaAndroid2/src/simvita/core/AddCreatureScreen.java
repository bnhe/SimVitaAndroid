package simvita.core;

import sofia.app.Screen;

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


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void initialize(CreatureAdd creatureAdd)
    {
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
