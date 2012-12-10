package simvita.core;

/**
 * Store the description of a Thing
 *
 * @author Sihui Zhang
 * @version 2012.10.30
 *
 */
public class Description
{
    /**
     * A string for the name.
     */
    public String name;


    /**
     * A string for detailed description.
     */
    public String details;


    // ----------------------------------------------------------
    /**
     * Create a new Description object.
     * @param name a name.
     * @param details detailed description.
     */
    public Description (String name, String details)
    {
        this.name = name;
        this.details = details;
    }
}
