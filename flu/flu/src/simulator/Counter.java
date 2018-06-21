package simulator;


/**
 * Provide a counter for a participant in the simulation.
 * This includes an identifying string and a count of how
 * many participants of this type currently exist within
 * the simulation.
 *
 * @author Michael Kölling and David J. Barnes
 * @author ZHANG YUXIN
 * @version 25/05/2018
 */
public class Counter
{
    // A name for this type of simulation participant
    private String name;
    // How many of this type exist in the simulation.
    private int count;


    public Counter(String name)
    {
        this.name = name;
        count = 0;
    }


    public String getName()
    {
        return name;
    }


    public int getCount()
    {
        return count;
    }


    public void increment()
    {
        count++;
    }

    public void reset()
    {
        count = 0;
    }
}