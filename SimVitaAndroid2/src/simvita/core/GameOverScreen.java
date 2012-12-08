package simvita.core;

import android.widget.TextView;
import sofia.graphics.TextShape;
import sofia.app.ShapeScreen;
import sofia.app.Screen;

public class GameOverScreen extends ShapeScreen
{
    private TextView textView1;

    public void initialize(Long money)
    {
        //add(new TextShape("Game Over You made: "+money.toString()));
        textView1.setText("Game Over Score: "+money.toString());
    }

    public void playAgainClicked()
    {
        presentScreen(SimVitaScreen.class, CreatureType.TURTLE);
        finish();
    }
}
