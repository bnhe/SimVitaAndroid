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
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author verro ejiba
 *  @version Dec 1, 2012
 */
public class AddCreatureScreen extends ShapeScreen
{
    private CreatureType addType;
    private World world;
    private float cellS;
    private TimeLogic game;


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void initialize(TimeLogic t, float cellS)
    {
        game = t;
        this.cellS = cellS;
    }

    public void turtleClicked()
    {
        addType = CreatureType.TURTLE;
        TurtleA t = new TurtleA(new Position(5, 4));
        t.shape.setBounds(new RectF(0, 0, cellS, cellS / 4 * 3));
        t.shape.setPosition(cellS*5, cellS*4);
        game.addCreature(t);


        finish(addType);
    }

    public void bacteriaClicked()
    {
        addType = CreatureType.BACTERIA;
        finish(addType);
    }


}
