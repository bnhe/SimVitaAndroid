package simvita.core;

import android.widget.TextView;
import sofia.app.Screen;

/**
 * Display the Game Over Screen.
 * Shows the ending image, the player's final score, and the option to try
 * again.
 *
 *  @author Nate Craun (ncraun)
 *  @version 2012.12.09
 */
public class GameOverScreen extends Screen
{
    private TextView textView1;

    /**
     * Set the users score and display it.
     *
     * @param money The final amount of money (score) of the player.
     */
    public void initialize(Long money)
    {
        textView1.setText("Score: "+money.toString());
    }

    /**
     * User clicked play again, go back to TitleScreen.
     */
    public void playAgainClicked()
    {
        presentScreen(TitleScreen.class);
        finish();
    }
}
