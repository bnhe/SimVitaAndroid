package simvita.core;

import android.view.MotionEvent;
import sofia.app.Screen;

public class TitleScreen extends Screen
{
    public void onTouchDown(MotionEvent event)
    {
        presentScreen(SimVitaScreen.class, CreatureType.BACTERIA);
        finish();
    }
}
