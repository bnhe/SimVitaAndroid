package simvita.core;

import android.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import sofia.graphics.FillableShape;
import sofia.graphics.OvalShape;
import android.graphics.RectF;
import sofia.graphics.Shape;
import java.util.ArrayList;
import android.view.MotionEvent;
import android.widget.CheckBox;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
import sofia.app.ShapeScreen;
import java.util.HashMap;


// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author verro ejiba
 *  @version Dec 1, 2012
 */
public class SimVitaScreen extends ShapeScreen
{

    private float cellSize;
    private int numBoxWidth;
    private int numBoxHeight;
    private TimeLogic game;
    private BacteriaA ba;
    private CreatureType addType;


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void initialize(CreatureType addType)
    {
        this.addType = addType;
        setBackgroundColor(Color.black);
        float boardSize = Math.min(getWidth(), getHeight());
        cellSize = boardSize / 20;
        numBoxWidth = (int) (getWidth() / cellSize);
        numBoxHeight = (int) (getHeight() / cellSize);


        //Set up the game
        game = new TimeLogic();

        //add stuff
        //ba = new BacteriaA();
        //Position baPosition = new Position(5, 5);
        //ba.shape.setBounds(new RectF(0, 0, cellSize, cellSize));
        //ba.shape.setPosition(cellSize * 5, cellSize * 5);
        //add(ba.shape);
        //game.getWorld().addThing(ba, new Position(5, 50));

//        game.getWorld().addThing(ba, new Position(10, 10));

        float startx = cellSize * 10;
        float starty = cellSize * 10;
        Position turtlePosition = new Position(10, 10);

        TurtleA t = new TurtleA(turtlePosition);
        addCreatureAndShape(t);
//        t.shape.setBounds(new RectF(0, 0, cellSize, cellSize / 4 * 3));
//        t.shape.setPosition(startx, starty);
//        add(t.shape);

        //add a turtle
        //game.getWorld().addThing(t, new Position(10, 10));
        //game.addCreature(t);
        //addShape(t);

        // Set up the screen
        game.init();
    }

    public void addCreatureAndShape(Creature c)
    {
        game.addCreature(c);
        addShape(c);
    }

    public void addShape(Thing t)
    {
        float startx = cellSize * t.getPosition().x;
        float starty = cellSize * t.getPosition().y;

        t.shape.setBounds(new RectF(0, 0, cellSize, cellSize / 4 * 3));
        t.shape.setPosition(startx, starty);
        add(t.shape);
    }



    public void startGameClicked()
    {
       doTicks(100);
    }

    public void addCreatureClicked()
    {
        presentScreen(AddCreatureScreen.class, this.game, cellSize);
        updateScreen();
    }

    public void onTouchDown()
    {

    }

    public void addItClicked()
    {
        showAlertDialog("World", game.getWorld().getListOfThings().toString());
    }

    public void doTicks(int n)
    {
        for (int i = 0; i < n; i++)
        {
            doOneTick();
            try
            {
                Thread.currentThread().sleep(20);
            }
            catch (InterruptedException e)
            {

                e.printStackTrace();
            }
        }
    }


    public void doOneTick()
    {
        game.tick();
        updateScreen();
    }

    public void updateScreen()
    {
        //Add New Shapes
        if (game.getWorld().getToBeDraw() != null)
        {
            for (Thing t : game.getWorld().getToBeDraw())
            {
                int x = t.getPosition().x;
                int y = t.getPosition().y;
                if (x >= 0 && y >= 0 && x < numBoxWidth && y < numBoxHeight)
                {
                    addShape(t);
                }
            }
            //All drawn, reset toBeDraw
            game.getWorld().getToBeDraw().clear();
        }

        //Update existing Shapes
        if (game.getWorld().getListOfThings() != null)
        {
            for (Thing t : game.getWorld().getListOfThings())
            {
                int x = t.getPosition().x;
                int y = t.getPosition().y;
                if (x >= 0 && y >= 0 && x < numBoxWidth && y < numBoxHeight)
                {
                    t.shape.setPosition(cellSize * x, cellSize * y);
                }
            }
        }
    }
}
