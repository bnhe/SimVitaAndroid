package simvita.core;

import android.graphics.RectF;
import sofia.graphics.ImageShape;
import sofia.util.Random;

/**
 *
 * This is a Vine that can replicate and die.
 *
 * @author Bin He
 * @author Nate Craun
 * @version 2012.11.30
 *
 */
public class Vine extends Creature {

    private Random rand = new Random();
    private int life;
    private int replicateCount;

    /**
     * Create a Vine at the origin of the world.
     */
    public Vine()
    {
        this(new Position(0, 0));
    }

    /**
     * Create a Vine at a given position.
     * @param x the Position to put the Vine at.
     */
    public Vine(Position x) {
        this(x, 5);
    }

    /**
     * Create a Vine at a given position, name and description.
     * @param x Position of the Vine
     * @param f Frequency of action
     */
    public Vine(Position x, int f) {
        super(x, "Vine",  5);

        shape = new ImageShape("plantbigzh", new RectF(0, 0, 10, 10));
        life = 30;
        replicateCount = 0;
        value = 10;
    }


    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     */
    public void act(TimeLogic tl)
    {
        if (life <= 0)
        {
            tl.removeCreature(this);
        }
        else
        {
            replicate(tl);
            life -= 1;
            tl.addMoney(2);
        }
    }

    /**
     * Replicate this class and put is at a random position beside the mother.
     *
     * Replicate every 10 turns.
     * @param tl The TimeLogic
     */
    private void replicate(TimeLogic tl)
    {
        if (replicateCount > 10)
        {
            replicateCount = 0;
            Position daughterPosition =
                new Position(getPosition().x + rand.nextInt(3) - 1,
                    getPosition().y + rand.nextInt(3) - 1);

            tl.addCreature(new Vine(daughterPosition));
        }
        replicateCount += rand.nextInt(2);
    }


}
