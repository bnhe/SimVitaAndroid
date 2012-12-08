package simvita.core;

import sofia.graphics.TextShape;
import sofia.app.ShapeScreen;
import sofia.app.Screen;

public class GameOverScreen extends ShapeScreen
{
    public void initialize(Long money)
    {
        add(new TextShape("Game Over You made: "+money.toString()));
    }
}
