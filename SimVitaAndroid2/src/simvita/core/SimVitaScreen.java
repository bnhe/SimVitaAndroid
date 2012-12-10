package simvita.core;

import sofia.graphics.ImageShape;
import android.widget.TextView;
import android.graphics.RectF;
import java.util.ArrayList;
import android.view.MotionEvent;
import sofia.graphics.Color;
import sofia.app.ShapeScreen;
import java.util.Random;


// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author verro ejiba
 *  @author Nate Craun
 *  @author Bin He
 *  @version Dec 1, 2012
 */
public class SimVitaScreen extends ShapeScreen
{

    private float cellSize;
    private int numBoxWidth;
    private int numBoxHeight;
    private TimeLogic game;
    private TextView textMoney;
    private TextView textTurns;
    private CreatureAdd addCreature;
    Random rand = new Random();

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void initialize(CreatureAdd addCreature, Long gameLength)
    {
        this.addCreature = addCreature;
        setBackgroundColor(Color.white);
        //set the background
        add(new ImageShape("background", new RectF(0, 0, getWidth(), getHeight())));

        float boardSize = Math.min(getWidth(), getHeight());
        cellSize = boardSize / 20;
        numBoxWidth = (int) (getWidth() / cellSize);
        numBoxHeight = (int) (getHeight() / cellSize);

        //Set up the game
        game = new TimeLogic(gameLength);

        //add text
        game.setMoney(100);

        randomizeStart();
        textMoney.setText("Money: 100");
        textTurns.setText("Turns: 0");
    }

    public void randomizeStart()
    {
        //Turtle Adder
        for (int i = 0; i < 3; i++)
        {
            int xCell = rand.nextInt(numBoxWidth);
            int yCell = rand.nextInt(numBoxHeight);
            addCreatureAndShape(new TurtleAdder((new Position(xCell, yCell))));
            updateScreen();
        }

        //Plants
        addCreature.addType = "simvita.core.Vine";
        for (int i = 0; i < 20; i++)
        {
            int xCell = rand.nextInt(numBoxWidth);
            int yCell = rand.nextInt(numBoxHeight);
            addCreatureAndShape(new Vine((new Position(xCell, yCell))));
            updateScreen();
        }

    }

    public void updateMoney()
    {
        textMoney.setText("Money: "+Long.toString(game.getMoney()));
    }

    public void updateTurnCount()
    {
        textTurns.setText("Turns: "+Long.toString(game.getClock()));
    }

    public void addCreatureAndShape(Creature c)
    {
        game.addCreature(c);
        addShape(c);
    }

    public void addShape(Creature c)
    {
        float startx = cellSize * c.getPosition().x;
        float starty = cellSize * c.getPosition().y;

        c.shape.setBounds(new RectF(0, 0, cellSize, cellSize / 4 * 3));
        c.shape.setPosition(startx, starty);
        add(c.shape);
    }

    public void removeShape(Creature c)
    {
        remove(c.shape);
    }

    public void removeCreatureAndShape(Creature c)
    {
        game.removeCreature(c);
        removeShape(c);
    }

    public Creature generateCreature(Position p)
    {
        Creature c = null;
        try
        {
            c = (Creature)Class.forName(addCreature.addType).newInstance();
        }
        catch (IllegalAccessException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (InstantiationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        c.setPosition(p);
        return c;
    }

    public void endClicked()
    {
        presentScreen(GameOverScreen.class, game.getMoney());
        finish();
    }

    public void hundredClicked()
    {
        doTurns(100);
    }

    public void tenClicked()
    {
        doTurns(10);
    }

    public void oneClicked()
    {
        doTurns(1);
    }

    public void statClicked()
    {
        presentScreen(StatsScreen.class, game.getWorld().getListOfCreatures());
    }

    public void selectCreatureClicked()
    {
        presentScreen(AddCreatureScreen.class, addCreature);
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

    public void doTurns(int n)
    {
        long currClock = game.getClock();

        while (game.getClock() < currClock + n)
        {
            try
            {
                Thread.currentThread().sleep(10);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            if (!game.isOver())
            {
                game.tick();
                updateScreen();
            }
            else
            {
                break;
            }
        }

        if (game.isOver())
        {
            presentScreen(GameOverScreen.class, game.getMoney());
            finish();
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
            finish();
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
        ArrayList<Creature> outOfBounds = new ArrayList<Creature>();

        for (Creature c : game.getWorld().getToBeRemoved())
        {
            removeShape(c);
        }
        //All removed, reset toRemove
        game.getWorld().getToBeRemoved().clear();

        //Add New Shapes
        if (game.getWorld().getToBeDraw() != null)
        {
            for (Creature c : game.getWorld().getToBeDraw())
            {
                int x = c.getPosition().x;
                int y = c.getPosition().y;
                if (x >= 0 && y >= 0 && x < numBoxWidth && y < numBoxHeight)
                {
                    addShape(c);
                }
                else //Remove shapes that go offscreen
                {
                    outOfBounds.add(c);
                }
            }
            //All drawn, reset toBeDraw
            game.getWorld().getToBeDraw().clear();
        }

        //Update existing Shapes
        //Move shapes that are moving.
        for (Creature c : game.getWorld().getToBeMoved())
        {
            int x = c.getPosition().x;
            int y = c.getPosition().y;
            if (x >= 0 && y >= 0 && x < numBoxWidth && y < numBoxHeight)
            {
                c.shape.setPosition(cellSize * x, cellSize * y);
            }
            else //Remove shapes that go offscreen
            {
                outOfBounds.add(c);
            }
        }
        game.getWorld().getToBeMoved().clear();

        //Remove out of bounds shapes
        for (Creature c : outOfBounds)
        {
            removeCreatureAndShape(c);
        }
    }
}
