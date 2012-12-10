package simvita.core;

import sofia.app.Screen;
import android.widget.TextView;

// -------------------------------------------------------------------------
/**
 * Allow the user to select which creature type they want to purchase.
 *
 *  @author Verro Ejiba (verroe)
 *  @author Nate Craun (ncraun)
 *  @version 2012.12.09
 */
public class AddCreatureScreen extends Screen
{
    private CreatureAdd creatureAdd;
    private TextView eagleCost;
    private TextView plantCost;


    // ----------------------------------------------------------

    /**
     * Create this Screen, and set the text to the cost of the Creatures.
     *
     * @param cadd The Container class that will hold what type of
     * creature to add.
     */
    public void initialize(CreatureAdd cadd)
    {
        eagleCost.setText(Integer.toString(new Eagle().value));
        plantCost.setText(Integer.toString(new Vine().value));
        this.creatureAdd = cadd;
    }

    /**
     * Player wants to add a Vine (Plant).
     */
    public void plantClicked()
    {
        selectCreature("Vine");
    }

    /**
     * Player wants to add an Eagle.
     */
    public void eagleClicked()
    {
        selectCreature("Eagle");
    }

    /**
     * Add package name and return the type to the mainscreen.
     */
    private void selectCreature(String creatureClass)
    {
        creatureAdd.addType = "simvita.core."+creatureClass;
        finish();
    }
}
