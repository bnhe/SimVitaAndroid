package simvita.core;

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
    private World world;
    private float cellSize;
    private int numBoxWidth;
    private int numBoxHeight;
    private CheckBox addCreatureMode;
    private TimeLogic game;
    private BacteriaA ba;
    private Color normalColor;
    private Controller control;
//    //private ArrayList<Shape> shapes;
//    private HashMap<Creature, Shape> shapes;

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void initialize()
    {

        setBackgroundColor(Color.black);
        float boardSize = Math.min(getWidth(), getHeight());
        cellSize = boardSize / 40;
        numBoxWidth = (int) (getWidth() / cellSize);
        numBoxHeight = (int) (getHeight() / cellSize);

//        shapes = new HashMap<Creature, Shape>();
        //Set up the game
        game = new TimeLogic();
        ba = new BacteriaA();
        //add stuff
        game.getWorld().addThing(ba, new Position(10, 10));
        float startx = cellSize * 20;
        float starty = cellSize * 20;

        TurtleA t = new TurtleA(new Position(20, 20));
        t.shape.setBounds(new RectF(startx, starty, startx
            + cellSize, starty + cellSize));
        add(t.shape);
        //add a turtle
        game.getWorld().addThing(t, new Position(20, 20));
        // Set up the screen


//       shapes.put(t, new OvalShape(startx, starty,  cellSize, cellSize));
//       ((FillableShape)shapes.get(t)).setFilled(true);
//       ((FillableShape)shapes.get(t)).setFillColor(t.color);
//        add(shapes.get(t));

        //wait
        //updateScreen();
        game.init();
    }
//
//    public void addShapeCreature(Creature t)
//    {
//        float startx = cellSize * t.getPosition().x;
//        float starty = cellSize * t.getPosition().y;
//
//       shapes.put(t, new OvalShape(startx, starty,  cellSize, cellSize));
//       ((FillableShape)shapes.get(t)).setFilled(true);
//       ((FillableShape)shapes.get(t)).setFillColor(t.color);
//        add(shapes.get(t));
//    }

    public void startGameClicked()
    {
       doTicks(100);
    }

    public void doTicks(int n)
    {
        for (int i = 0; i < n; i++)
        {
            doOneTick();
            try
            {
                Thread.currentThread().sleep(10);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


    public void doOneTick()
    {
        //clearScreen();
        game.tick();
        updateScreen();
       // TurtleA t = (TurtleA)game.getWorld().getListOfThings().get(0);
        //t.act(game.getWorld());

//        for (Thing t :game.getWorld().getListOfThings())
//        {
//            int x = t.getPosition().x;
//            int y = t.getPosition().y;
//                shapes.get(t).setPosition(cellSize*x, cellSize*y);
//        }
    }

    public void updateScreen()
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

    public void clearScreen()
    {
        for (Thing t : game.getWorld().getListOfThings())
        {
            int x = t.getPosition().x;
            int y = t.getPosition().y;
            if (x >= 0 && y >= 0 && x < numBoxWidth && y < numBoxHeight)
            {            }
        }
    }

}
