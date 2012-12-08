package simvita.core;

import sofia.graphics.TextShape;
import android.graphics.RectF;
import java.util.ArrayList;
import android.view.MotionEvent;
import sofia.graphics.Color;
import sofia.app.ShapeScreen;


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
    private CreatureAdd add;
    private TextShape displayMoney;
    private TextShape displayTurnCount;


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
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

        //add text
        displayMoney = new TextShape("");
        //displayMoney.setPosition(0, 0);
        displayMoney.setTypeSize(10);
        displayTurnCount = new TextShape("");
        //displayMoney.setPosition(0, 0);
        displayTurnCount.setTypeSize(10);
        game.setMoney(100);
        add(displayMoney);
        add(displayTurnCount);
        //displayMoney.setPosition(0, 0);
        displayMoney.setBounds(new RectF(0, 0, cellSize, cellSize / 4 * 3));
        displayTurnCount.setBounds(new RectF(0, 30, cellSize, cellSize / 4 * 3));

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
    }

    public void updateMoney()
    {
        displayMoney.setText("Money: "+Long.toString(game.getMoney()));
    }

    public void updateTurnCount()
    {
        displayTurnCount.setText("Turns: "+Long.toString(game.getClock()));
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

    public void removeShape(Thing t)
    {
        remove(t.shape);
    }

    public void removeCreatureAndShape(Creature c)
    {
        game.removeCreature(c);
        removeShape(c);
    }

    public Creature generateCreature(Position p)
    {
        if (add.addType == CreatureType.TURTLE)
        {
            return new TurtleA(p);
        }
        else
            if (add.addType == CreatureType.BACTERIA)
            {
                return new BacteriaA(p);
            }

        return new DoNothingCreature(p);
    }

    public void startGameClicked()
    {
        doTicks(100);
    }

    public void selectCreatureClicked()
    {
        presentScreen(AddCreatureScreen.class, add);
        updateScreen();
    }

    public void onTouchDown(MotionEvent event)
    {
        if (game.getMoney() > 0)
        {
            int xCell = (int)(event.getX() / cellSize);
            int yCell = (int)(event.getY() / cellSize);
            Creature c = generateCreature(new Position(xCell, yCell));
            if (game.getMoney() - c.value >= 0)
            {
                addCreatureAndShape(c);
                game.subtractMoney(c.value);
                updateScreen();
            }
        }
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
        if (!game.isOver())
        {
            game.tick();
            updateScreen();
        }
        else
        {
            presentScreen(GameOverScreen.class, game.getMoney());
        }
    }

    public void updateText()
    {
        updateMoney();
        updateTurnCount();
    }

    public void updateScreen()
    {
        updateText();
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
