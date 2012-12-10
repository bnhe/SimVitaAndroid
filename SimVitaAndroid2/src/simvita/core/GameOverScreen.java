package simvita.core;

import android.widget.TextView;
import sofia.app.Screen;

public class GameOverScreen extends Screen
{
    private TextView textView1;

    public void initialize(Long money)
    {
        //add(new TextShape("Game Over You made: "+money.toString()));
        textView1.setText("Score: "+money.toString());
    }

    public void playAgainClicked()
    {
        presentScreen(TitleScreen.class);
        finish();
    }
}
