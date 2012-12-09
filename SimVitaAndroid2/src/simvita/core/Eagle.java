/**
 *
 */
package simvita.core;

import android.graphics.RectF;
import sofia.graphics.ImageShape;
import sofia.graphics.FillableShape;
import sofia.graphics.OvalShape;
import java.util.ArrayList;
import sofia.graphics.Color;
import java.util.Random;
import java.lang.Math;

/**
 *
 * This is a Eagle that chaseing turtle.
 *
 * @author Bin He
 * @version 2012.12.06
 *
 */
public class Eagle extends Creature {

    Random rand = new Random();
    private int life;
    private int stomachSpace;

    /**
     * Create a Eagle at the origin of the world.
     */
    public Eagle()
    {
        this(new Position(0, 0));
    }

    /**
     * Create a Eagle at a given position.
     * @param x the Position to put the Eagle at.
     */
    public Eagle(Position x) {
        this(x, Color.brown, 4);
    }

    /**
     * Create a Eagle at a given position, name and discription.
     * @param x
     * @param aName
     * @param desc
     * @param c
     */
    public Eagle(Position x, Color c, int f) {
        super(x, "Eagle", new Description("Eagle",
            "A Eagle that trying to eat turtle"), c, 1);

        shape = new ImageShape("bacteriabigsz", new RectF(0, 0, 1, 1));

        life = 20;
        stomachSpace = 4;

        setFoodCreature(new TurtleA());
    }


    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     *
     * @param tl The TimeLogic.
     * @return
     */
    public void act(TimeLogic tl)
    {
        TurtleA nearTurtle = new TurtleA(
            new Position(rand.nextInt(20),
                rand.nextInt(20)));

        if (life <= 0 || stomachSpace <= 0)
        {
            tl.removeCreature(this);
        }
        else
        {
            Creature aFood = tl.getWorld().getNearestFood(this);

            if (aFood.getPosition().equals(this.getPosition()))
            {
                 tl.removeCreature(tl.getWorld().getNearestFood(this));
            }
            else
            {
                int ex = this.getPosition().x;
                int ey = this.getPosition().y;

                int tx = aFood.getPosition().x;
                int ty = aFood.getPosition().y;

                int newX = ex + (int) Math.signum((double)(tx - ex));
                int newY = ey + (int) Math.signum((double)(ty - ey));

                this.setPosition(new Position(newX, newY));
            }

            life -= 2;
        }

    }

}