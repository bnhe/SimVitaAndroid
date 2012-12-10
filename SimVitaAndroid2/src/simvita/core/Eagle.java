/**
 *
 */
package simvita.core;

import android.graphics.RectF;
import sofia.graphics.ImageShape;
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

    private Random rand = new Random();
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
        this(x, 4);
    }

    /**
     * Create a Eagle at a given position, name and discription.
     * @param x Position of the eagle
     * @param f Frequency of action.
     */
    public Eagle(Position x, int f) {
        super(x, "Eagle",  1);

        shape = new ImageShape("eaglebigbh", new RectF(0, 0, 1, 1));

        life = 50;
        stomachSpace = 4;
        value = 50;

        setFoodCreature(new TurtleA());
    }


    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     *
     * @param tl The TimeLogic.
     */
    public void act(TimeLogic tl)
    {
        new TurtleA(
            new Position(rand.nextInt(20),
                rand.nextInt(20)));

        if (life <= 0 || stomachSpace <= 0)
        {
            tl.removeCreature(this);
        }
        else
        {
            Creature aFood = tl.getWorld().getNearestFood(this);
            if (aFood != null)
            {
                if (aFood.getPosition().equals(this.getPosition()))
                {
                    tl.removeCreature(aFood);
                }
                else
                {
                    int ex = this.getPosition().x;
                    int ey = this.getPosition().y;

                    int tx = aFood.getPosition().x;
                    int ty = aFood.getPosition().y;

                    int newX = ex + (int) Math.signum((double)(tx - ex));
                    int newY = ey + (int) Math.signum((double)(ty - ey));

                    tl.moveCreature(this, new Position(newX, newY));
                }
            }

            life -= 2;
        }

    }

}