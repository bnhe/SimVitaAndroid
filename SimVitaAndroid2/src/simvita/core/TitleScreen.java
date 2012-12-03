package simvita.core;

import sofia.app.Screen;

public class TitleScreen extends Screen
{
    public void playClicked()
    {
        presentScreen(SimVitaScreen.class, CreatureType.BACTERIA);
        finish();
    }
}
