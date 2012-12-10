package simvita.core;

/**
 * A wrapper class around a String, so we can pass this String between multiple
 * Screens. This particular one is used to determine the type of creature to add
 * to the screen when the player touches the screen.
 *
 * @author Nate Craun (ncraun)
 * @version 2012.12.09
 */
public class CreatureAdd
{
    /**
     * The name of the class of creature to be added.
     */
    public String addType;

    /**
     * Create a new CreatureAdd.
     *
     * @param addType The type to add.
     */
    public CreatureAdd(String addType)
    {
        this.addType = addType;
    }
}
