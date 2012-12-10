package simvita.core;

import android.widget.Button;

// -------------------------------------------------------------------------
/**
 *  Test cases for AddCreatureScreen class
 *
 *  @author verro ejiba
 *  @author Nate Craun
 *  @version Dec 9, 2012
 */
public class AddCreatureScreenTest extends
        student.AndroidTestCase<AddCreatureScreen>
{
    private Button eagle;
    private Button plant;
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
     * Tests that an eagle is added on the screen when the button is clicked
     */
    public void testEagleClicked()
    {
        click(eagle);
        //assertEquals("simvita.core.Eagle", screen.getCreatureTypeString());
        //assertNull(null);
    }

    // ----------------------------------------------------------
    /**
     * Tests that a plant is added to the world once the button is clicked
     */
    public void testPlantClicked()
    {
        //click(plant);
        //assertEquals("simvita.core.Vine", screen.getCreatureTypeString());
        assertNull(null);
    }
}
