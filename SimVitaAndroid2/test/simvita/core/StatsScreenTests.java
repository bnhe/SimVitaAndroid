package simvita.core;

import android.widget.Button;

// -------------------------------------------------------------------------
/**
 *  Test cases for statsScreen class.
 *
 *  @author verro ejiba
 *  @version Dec 9, 2012
 */
public class StatsScreenTests extends student.AndroidTestCase<StatsScreen>
{
    private Button returnButton;
    // ----------------------------------------------------------
    /**
     * Create a new StatsScreenTests object.
     */
    public StatsScreenTests()
    {
        super(StatsScreen.class);
    }

    // ----------------------------------------------------------
    /**
     * Tests return button
     */
    public void testReturnButtonClicked()
    {
        click(returnButton);
        //Can't test if the screen switches up

    }
}
