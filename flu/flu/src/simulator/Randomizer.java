package simulator;

import java.util.Random;

/**
 * Provide control over the randomization of the simulation.
 * 
 * @author ZHANG YUXIN
 * @version 1.0
 */
public class Randomizer
{
    // The default seed for control of randomization.
    private static final int SEED = 1111;
    // A shared Random object, if required.
    private static final Random rand = new Random(SEED);
    // Determine whether a shared random generator is to be provided.
    private static final boolean useShared = true;

    /**
     * Constructor for objects of class Randomizer
     */
    public Randomizer()
    {
    }

    public static Random getRandom()
    {
        if(useShared) {
            return rand;
        }
        else {
            return new Random();
        }
    }

    public static void reset()
    {
        if(useShared) {
            rand.setSeed(SEED);
        }
    }
}