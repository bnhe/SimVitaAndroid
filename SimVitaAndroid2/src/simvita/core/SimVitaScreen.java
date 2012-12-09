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
 * Initializes the screen of the simvita game, and places a creature selected
 * by the player in world when he touched down the screen. Removes shapes from
 * the screen when the start button is clicked and  every thing remove action
 * of a creature is done according to the time queue of event.
 *
 *  @author Verro Ejiba
 *  @author Nate Craun
 *  @author Bin He
 *  @version 12.1.12
 */
public class SimVitaScreen extends ShapeScreen
{

    private float cellSize;
    private int numBoxWidth;
    private int numBoxHeight;
    private TimeLogic game;
    private BacteriaA ba;
    private CreatureAdd add;


    // ----------------------------------------------------------
    /**
     * Initializes the new screen
     * @param addType the type of creature to add
     */
    public void initialize(CreatureType addType)
    {
        add = new CreatureAdd(CreatureType.TURTLE);
        setBackgroundColor(Color.black);
        float boardSize = Math.min(getWidth(), getHeight());
        cellSize = boardSize / 20;
        numBoxWidth = (int) (getWidth() / cellSize);
        numBoxHeight = (int) (getHeight() / cellSize);


        //Set up the game
        game = new TimeLogic();
        game.init();

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

        //TurtleA t = new TurtleA(turtlePosition);
        //addCreatureAndShape(t);
//        t.shape.setBounds(new RectF(0, 0, cellSize, cellSize / 4 * 3));
//        t.shape.setPosition(startx, starty);
//        add(t.shape);

        //add a turtle
        //game.getWorld().addThing(t, new Position(10, 10));
        //game.addCreature(t);
        //addShape(t);

        // Set up the screen

    }

    // ----------------------------------------------------------
    /**
     * Adds a shape and a creature to the TimeLogic
     * @param c creature name
     */
    public void addCreatureAndShape(Creature c)
    {
        game.addCreature(c);
        addShape(c);
    }

    // ----------------------------------------------------------
    /**
     * Adds a shape to the thing
     * @param t thing name
     */
    public void addShape(Thing t)
    {
        float startx = cellSize * t.getPosition().x;
        float starty = cellSize * t.getPosition().y;

        t.shape.setBounds(new RectF(0, 0, cellSize, cellSize / 4 * 3));
        t.shape.setPosition(startx, starty);
        add(t.shape);
    }

    // ----------------------------------------------------------
    /**
     * Removes a shape of a thing
     * @param t thing name
     */
    public void removeShape(Thing t)
    {
        remove(t.shape);
    }

    // ----------------------------------------------------------
    /**
     * Removes a shape and a creature to the screen
     * @param c the creature to be removed
     */
    public void removeCreatureAndShape(Creature c)
    {
        game.removeCreature(c);
        removeShape(c);
    }

    // ----------------------------------------------------------
    /**
     * Generate a create at a given position
     * @param p the position
     * @return the creature's position
     */
    public Creature generateCreature(Position p)
    {
        if (add.addType == CreatureType.TURTLE)
        {
            return new TurtleA(p);
        }
        return new DoNothingCreature(p);
    }

    // ----------------------------------------------------------
    /**
     * do ticks once the start game button is clicked
     */
    public void startGameClicked()
    {
       doTicks(100);
    }

    // ----------------------------------------------------------
    /**
     * Brings the player to another screen where he will get to choose the
     * type of creature to add in the screen
     */
    public void selectCreatureClicked()
    {
        presentScreen(AddCreatureScreen.class, add);
        updateScreen();
    }

    // ----------------------------------------------------------
    /**
     * Adds creature and shape to where the user touches down.
     * @param event
     */
    public void onTouchDown(MotionEvent event)
    {
        int xCell = (int)(event.getX() / cellSize);
        int yCell = (int)(event.getY() / cellSize);
        addCreatureAndShape(generateCreature(new Position(xCell, yCell)));
        updateScreen();
    }

    // ----------------------------------------------------------
    /**
     * Does the ticks
     * @param n number of times to do the ticks
     */
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


    // ----------------------------------------------------------
    /**
     * Only does one tick then updates the screen.
     */
    public void doOneTick()
    {
        game.tick();
        updateScreen();
    }

    // ----------------------------------------------------------
    /**
     * Updates the screen and disregard the creatures that are out of bound.
     */
    public void updateScreen()
    {
        //Remove Shapes that need to be removed
        ArrayList<Thing> outOfBounds = new ArrayList<Thing>();

        for (Thing t : game.getWorld().getToBeRemoved())
        {
            removeShape(t);
        }
        //All removed, reset toRemove
        game.getWorld().getToBeRemoved().clear();

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
                else //Remove shapes that go offscreen
                {
                    outOfBounds.add(t);
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
                else //Remove shapes that go offscreen
                {
                    outOfBounds.add(t);
                }
            }
        }

        //Remove out of bounds shapes
        for (Thing t : outOfBounds)
        {
            removeCreatureAndShape((Creature)t);
        }
    }
}
