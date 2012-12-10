package simvita.core;

/**
 * A wrapper class around a String, so we can pass this String between multiple
 * Screens. This particular one is used to determine the type of creature to add
 * to the screen when the player touches the screen.
 *
 * @author Nate Craun
 * @version Dec 9, 2012
 */
public class CreatureAdd
{
    public String addType;


    public CreatureAdd(String addType)
    {
        this.addType = addType;
    }
}
