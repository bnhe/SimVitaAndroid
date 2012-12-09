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
    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param aName the name of the creature
     */
    public void setName(String aName)
    {
        name = aName;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return name of the creature
     */
    public String getName()
    {
        return name;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param detail information about the creature
     */
    public void setDetails(String detail)
    {
        details = detail;
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return details of a specified creature
     */
    public String getDetails()
    {
        return details;
    }
}
