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

    Random rand = new Random();
    private int life;

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
        this(x, Color.green, 4);
    }

    /**
     * Create a Vine at a given position, name and discription.
     * @param x
     * @param aName
     * @param desc
     * @param c
     */
    public Vine(Position x, Color c, int f) {
        super(x, "Vine", new Description("Vine", "A replicating Vine"), c, 1);

        shape = new ImageShape("plantbigzh", new RectF(0, 0, 10, 10));

        life = 4;
    }


    /**
     * Main action method. Controls how the Thing will
     * interact with the world.
     *
     * @param w The world the BacteriaA acts upon.
     * @return
     */
    public void act(TimeLogic tl)
    {

        if (life <= 0)
        {
            tl.removeCreature(this);
            System.out.println("Removed a bacteria");
        }
        else
        {
            replicate(tl);
            life -= 3;
            tl.addMoney(1);
        }


    }

    /**
     * Replicate this class and put is at a random position beside the mother.
     * @param tl The TimeLogic
     */
    private void replicate(TimeLogic tl)
    {
        Position daughterPosition =
                new Position(getPosition().x + rand.nextInt(3) - 1,
                        getPosition().y + rand.nextInt(3) - 1);


        tl.addCreature(new BacteriaA(daughterPosition));

    }


}
