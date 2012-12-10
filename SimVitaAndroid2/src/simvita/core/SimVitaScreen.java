package simvita.core;

import sofia.graphics.ImageShape;
import android.widget.TextView;
import android.graphics.RectF;
import java.util.ArrayList;
import android.view.MotionEvent;
import sofia.graphics.Color;
import sofia.app.ShapeScreen;
import sofia.util.Random;


// -------------------------------------------------------------------------
/**
 * This is the main screen of the game.
 * Also includes several helper functions to interact with the TimeLogic
 * (a mini Controller, if you will).
 *
 * Testing Note: Unfortunately there were complications in using the provided
 * testing framework. All of our screens make heavy use of both Multiple Screens
 * and Screen with parameters to initialize, which are not supported in the
 * framework (see posts on piazza). Removing this from our screens would strip
 * out too much functionality, so we have omitted automated Screen tests for
 * this submission. However, we have tested all our Screens manually.
 *
 *  @author Nate Craun (ncraun)
 *  @version 2012.12.09
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
    private Random rand = new Random();

    //~Setup --------------------------------------------------
    /**
     * This creates a new screen.
     * A background image is added, the player starts with 100 money, and given
     * random plants, and turtleadder. Also the textdisplays are set up.
     *
     * @param addc The default type of creature to add.
     * @param gameLength the Length of the game.
     */
    public void initialize(CreatureAdd addc, Long gameLength)
    {
        this.addCreature = addc;
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

    /**
     * Randomize the start state. Give the player 20 plants, and a couple turtle
     * adders that will kick in a few turns.
     */
    public void randomizeStart()
    {
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

    //~ UI---------------------------------
    /**
     * Player clicked end, so show the game over screen.
     */
    public void endClicked()
    {
        presentScreen(GameOverScreen.class, game.getMoney());
        finish();
    }

    /**
     * Progress the action forward by 100 turns.
     */
    public void hundredClicked()
    {
        doTurns(100);
    }

    /**
     * Progress the action forward by 10 turns.
     */
    public void tenClicked()
    {
        doTurns(10);
    }

    /**
     * Progress the action forward by 1 turns.
     */
    public void oneClicked()
    {
        doTurns(1);
    }

    /**
     * Show the statistics screen.
     */
    public void statClicked()
    {
        presentScreen(StatsScreen.class, game.getWorld().getListOfCreatures());
    }

    /**
     * Let the user select which kind of creature to add to the world.
     */
    public void selectCreatureClicked()
    {
        presentScreen(AddCreatureScreen.class, addCreature);
        updateScreen();
    }

    /**
     * Add the current addType of creature to the screen if the user can afford
     * it, and deduct them accordingly.
     *
     * @param event Where the user touched the screen.
     */
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

    //~Helper Methods--------------------

    /**
     * Keep ticking the TimeLogic until the clock has proceeded by the given
     * time. A way to provide an approximation of going forward in specific
     * time intervals in a strictly event driven simulation.
     *
     * There is a delay of 10ms added between each tick, so the user can see
     * what is happening.
     *
     * If the game ends, switch to the game over screen, and end the game.
     *
     * @param n The number of turns to advance by.
     */
    public void doTurns(int n)
    {
        long currClock = game.getClock();

        while (game.getClock() < currClock + n)
        {
            try
            {
                //Thread.currentThread();
                Thread.sleep(10);
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

    /**
     * Update the display text display fields of money and turns with values
     * retrieved from the TimeLogic.
     */
    public void updateText()
    {
        textTurns.setText("Turns: "+Long.toString(game.getClock()));
        textMoney.setText("Money: "+Long.toString(game.getMoney()));
    }

    /**
     * Update the shapes for all the creatures on the screen.
     * Retrieve the values from the fields of the world to move, add, and delete
     * the creatures and shapes of the creatures that need it.
     *
     * Additionally, remove any shapes that go off screen, as they will have
     * fallen off the sky island.
     */
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

    /**
     * Add a creature to the world, and it's shape to the screen.
     *
     * @param c The creature.
     */
    public void addCreatureAndShape(Creature c)
    {
        game.addCreature(c);
        addShape(c);
    }

    /**
     * Add a creature's shape to the screen.
     *
     * @param c The creature.
     */
    public void addShape(Creature c)
    {
        float startx = cellSize * c.getPosition().x;
        float starty = cellSize * c.getPosition().y;

        c.shape.setBounds(new RectF(0, 0, cellSize, cellSize / 4 * 3));
        c.shape.setPosition(startx, starty);
        add(c.shape);
    }

    /**
     * Remove a creature's shape from the screen.
     *
     * @param c The Creature.
     */
    public void removeShape(Creature c)
    {
        remove(c.shape);
    }

    /**
     * Remove a creature and it's shape from the screen.
     *
     * @param c The Creature.
     */
    public void removeCreatureAndShape(Creature c)
    {
        game.removeCreature(c);
        removeShape(c);
    }

    /**
     * Construct a new Creature type based on the String in addType at a given
     * position.
     *
     * @param p The position to add it at.
     * @return The new creature at that position.
     */
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

}
