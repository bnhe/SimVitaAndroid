package simvita.core;

import sofia.app.Screen;

/**
 * The title screen for the app. Displays the title screen image, along with
 * buttons letting the player choose how long their game is.
 *
 * @author Nate Craun (ncraun)
 * @version Dec 9, 2012
 */

public class TitleScreen
    extends Screen
{
    /**
     * User selected a short game, 500 turns.
     */
    public void playShortClicked()
    {
        startGame(500);
    }

    /**
     * User selected a short game, 500 turns.
     */
    public void playMediumClicked()
    {
        startGame(1000);
    }

    /**
     * User selected a short game, 500 turns.
     */
    public void playLongClicked()
    {
        startGame(10000);
    }

    /**
     * This will create the main screen and finish this one.
     *
     * @param turns The length of the game in turns.
     */
    private void startGame(long turns)
    {
        presentScreen(
            SimVitaScreen.class,
            new CreatureAdd("simvita.core.Vine"),
            turns);
        finish();
    }
}
