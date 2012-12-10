package simvita.core;

import sofia.app.Screen;
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
public class AddCreatureScreen extends Screen
{
    private CreatureAdd add;
    private World world;
    private float cellS;
    private TimeLogic game;


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void initialize(CreatureAdd c)
    {
        add = c;
    }

    public void turtleClicked()
    {
        add.addType = CreatureType.TURTLE;
        finish();
    }

    public void doNothingClicked()
    {
        add.addType = CreatureType.DONOTHING;
        finish();
    }

    public void bacteriaClicked()
    {
        add.addType = CreatureType.BACTERIA;
        finish();
    }

}
