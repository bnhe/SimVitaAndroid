package simvita.core;

import android.widget.Button;

// -------------------------------------------------------------------------
/**
 *  Test cases for AddCreatureScreen class
 *
 *  @author verro ejiba
 *  @version Dec 9, 2012
 */
public class AddCreatureScreenTest extends
        student.AndroidTestCase<AddCreatureScreen>
{
    private Button Eagle;
    private Button Vine;
    private Button TurtleA;
    private AddCreatureScreen screen;
    // ----------------------------------------------------------
    /**
     * Create a new AddCreatureScreenTest object.
     */
    public AddCreatureScreenTest()
    {
        super(AddCreatureScreen.class);
    }

    public void setUp()
    {
        screen = new AddCreatureScreen();
    }

    // ----------------------------------------------------------
    /**
     * Tests that a turtle is added on the screen once the button is clicked
     */
    public void testTurtleClicked()
    {
        click(TurtleA);
        //assertEquals();
    }

    // ----------------------------------------------------------
    /**
     * Tests that an eagle is added on the screen when the button is clicked
     */
    public void testEagleClicked()
    {
        click(Eagle);
        //assertEquals();
    }

    // ----------------------------------------------------------
    /**
     * Tests that a plant is added to the world once the button is clicked
     */
    public void testPlantClicked()
    {
        click(Vine);
        //assertEquals();
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testSelectCreature()
    {
        //pass
    }

}
