package simvita.core;

import java.util.ArrayList;
import android.view.MotionEvent;
import android.widget.CheckBox;
import sofia.graphics.Color;
import sofia.graphics.RectangleShape;
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
    private RectangleShape[][] rects;
    private RectangleShape bogus;
    private World world;
    private float cellSize;
    private int numBoxWidth;
    private int numBoxHeight;
    private CheckBox addCreatureMode;
    private TimeLogic game;
    private BacteriaA ba;
    private Color normalColor;

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void initialize()
    {
        normalColor = Color.blue;
        bogus = new RectangleShape();
        add(bogus);

        //Set up the game
        game = new TimeLogic();
        ba = new BacteriaA();
        //add stuff
       //game.getWorld().addThing(ba, new Position(10, 10));
        game.getWorld().addThing(new TurtleA(), new Position(20, 21));
        // Set up the screen
        setBackgroundColor(Color.black);
        float boardSize = Math.min(getWidth(), getHeight());
        cellSize = boardSize / 40;
        numBoxWidth = (int) (getWidth() / cellSize);
        numBoxHeight = (int) (getHeight() / cellSize);
        this.rects =
            new RectangleShape[numBoxWidth][numBoxHeight];


        for (int i = 0; i < numBoxWidth; i++)
        {
            for (int j = 0; j < numBoxHeight; j++)
            {
                float startX = this.cellSize * i;
                float startY = this.cellSize * j;

                RectangleShape rectangle =
                    new RectangleShape(
                        startX,
                        startY,
                        startX + this.cellSize,
                        startY + this.cellSize);
                rectangle.setColor(Color.white);
                rectangle.setFilled(true);
                rectangle.setFillColor(normalColor);
                add(rectangle);
                this.rects[i][j] = rectangle;
            }
        }
        //wait
        updateScreen();
        game.init();
    }

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

    public void gameloop()
    {
        double FPS = 10;
        double secPerTick = 1/FPS;
        double unpTime = 0;
        long tickCount = 0;
        long frames = 0;

        long prevTime = System.nanoTime();
        while(true)
        {
            long currTime = System.nanoTime();
            long passTime = currTime - prevTime;
            prevTime = currTime;
            unpTime += passTime / 1000000000.0;

            while (unpTime > secPerTick)
            {
                unpTime -= secPerTick;
                tickCount++;
                if (tickCount % FPS == 0)
                {
                    frames = 0;
                    prevTime += 1000;
                }
                //do code
                doOneTick();
                frames++;
            }
        }
    }

    public void doOneTick()
    {
        //clearScreen();
        ArrayList<Thing> toRemove = game.tick();

        for (Thing t : toRemove)
        {
            int x = t.getPosition().x;
            int y = t.getPosition().y;
            if (x >= 0 && y >= 0 && x < numBoxWidth && y < numBoxHeight)
            {
                rects[x][y].setFillColor(Color.gray);
            }
        }

        updateScreen();
    }

    public void updateScreen()
    {
        for (Thing t : game.getWorld().getListOfThings())
        {
            int x = t.getPosition().x;
            int y = t.getPosition().y;
            if (x >= 0 && y >= 0 && x < numBoxWidth && y < numBoxHeight)
            {
                rects[x][y].setFillColor(t.color);
                //rects[x][y].animate(250).alpha(160).delay(250).play();


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
            {
                rects[x][y].setFillColor(normalColor);
            }
        }
    }

}
