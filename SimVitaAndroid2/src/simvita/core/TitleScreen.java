package simvita.core;

import sofia.app.Screen;

public class TitleScreen extends Screen
{
    public void playShortClicked()
    {
        startGame(500);
    }

    public void playMediumClicked()
    {
        startGame(1000);
    }

    public void playLongClicked()
    {
        startGame(10000);
    }

    private void startGame(long turns)
    {
        presentScreen(SimVitaScreen.class,
            new CreatureAdd("simvita.core.TurtleA"), turns);
        finish();
    }
}