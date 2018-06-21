package simulator;


import javafx.animation.Transition;
import model.*;
import exceptions.*;
import states.State;


import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.awt.Color;
import java.util.concurrent.TimeUnit;

/**
 * A simple predator-prey simulator, based on a rectangular field containing
 * rabbits and foxes.
 *
 * @author David J. Barnes and Michael Kölling
 * @author ZHANG YUXIN
 * @version 25/05/2018
 */
public class Simulator {
    // Constants representing configuration information for the simulation.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 100;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 100;
    // The probability that a person will be created in any given grid position.
    private static final double PERSON_CREATION_PROBABILITY = 0.08;
    // The probability that a animal will be created in any given grid position.
    private static final double CHICKEN_CREATION_PROBABILITY = 0.02; // 0.02
    private static final double DUCK_CREATION_PROBABILITY = 0.01; // 0.04
    private static final double PIG_CREATION_PROBABILITY = 0.03; // 0.06


    // List of living beings in the field.
    private List<LivingBeings> livingBeings;
    private Duck duck;
    private Chicken chicken;
    private Pig pig;
    // The current state of the field.
    private Field field;
    // The current step of the simulation.
    private int step;
    // A graphical view of the simulation.
    private List<SimulatorView> views;
    // speed
    private int speed;

    /**
     * Construct a simulation field with default size.
     */
    public Simulator() {
        this(DEFAULT_DEPTH, DEFAULT_WIDTH);
    }


    public Simulator(int depth, int width) {
        try {
            if (width <= 0 || depth <= 0)
                throw new DimensionNegativeException("The dimensions must be greater than zero.");
        } catch (DimensionNegativeException e) {
            e.printStackTrace();
        } finally {
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
        }

        speed = 10;
        livingBeings = new ArrayList<>();
        field = new Field(depth,width);

        views = new ArrayList<>();

        SimulatorView view = new GridView(depth, width);
        view.setColor(Person.class, Color.BLACK);
        view.setColor(Chicken.class, Color.BLUE);
        view.setColor(Pig.class, Color.RED);
        view.setColor(Duck.class, Color.ORANGE);
        views.add(view);

        startGraphView(view);

        // Setup a valid starting point.
        reset();
    }

    /**
     * Launches the busy GUI in a separate thread.
     */
    private void startGraphView(SimulatorView view) {
        // creates a new thread to run the busy GUI
        view = new GraphView(500, 150, 500);
        view.setColor(Person.class, Color.BLACK);
        view.setColor(Chicken.class, Color.BLUE);
        view.setColor(Pig.class, Color.RED);
        view.setColor(Duck.class, Color.ORANGE);
        views.add(view);
    }

    /**
     * Run the simulation from its current state for a reasonably long period,
     * (4000 steps).
     */
    public void runLongSimulation() {
        simulate();
    }

    /**
     * Run the simulation from its current state for the given number of steps.
     * Stop before the given number of steps if it ceases to be viable.
     *
     */
    public void simulate() {
        for (step = 1; views.get(0).isViable(field) && canContinue(); step++) {
            try {
                TimeUnit.MILLISECONDS.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            simulateOneStep();
        }
    }

    /**
     * Run the simulation from its current state for a single step. Iterate over
     * the whole field updating the state of each animal and people.
     */
    public void simulateOneStep() {
        step++;
        for (int i = 0; i < livingBeings.size() - 1; i++) {
            LivingBeings being = livingBeings.get(i);
            being.act();
//            duck.act();
//            if (duck.isAlive()) {
//                livingBeings.set(i, being);
//            }
//            chicken.act();
//            pig.act();
            if (being.isAlive()) {
                livingBeings.set(i, being);
            }
        }
        updateViews();
    }

    /**
     * Reset the simulation to a starting position.
     */
    public void reset() {
        step = 0;
        livingBeings.clear();
        for (SimulatorView view : views) {
            view.reset();
        }
        populate();
        updateViews();
    }

    /**
     * Update all existing views.
     */
    private void updateViews() {
        for (SimulatorView view : views) {
            view.showStatus(step, field);
        }
    }

    /**
     * Randomly populate the field with animals and people.
     */
    private void populate() {
        Random rand = Randomizer.getRandom();
        field.clear();
        for (int row = 0; row < field.getDepth(); row++) {
            for (int col = 0; col < field.getWidth(); col++) {
                if (rand.nextDouble() <= DUCK_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    LivingBeings duck = new Duck(field, location);
                    livingBeings.add(duck);
                } else if (rand.nextDouble() <= CHICKEN_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    LivingBeings chicken = new Chicken(field, location);
                    livingBeings.add(chicken);
                } else if (rand.nextDouble() <= PIG_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    LivingBeings pig = new Pig(field, location);
                    livingBeings.add(pig);
                } else if (rand.nextDouble() <= PERSON_CREATION_PROBABILITY) {
                    Location location = new Location(row, col);
                    LivingBeings person = new Person(field, location);
                    livingBeings.add(person);
                }
            }
        }
    }

    public boolean canContinue() {
        boolean stop = true;
        for (LivingBeings being: livingBeings) {
            if ((being.getState() != State.DEAD) && (being.getState() != State.HEALTHY)) {
                stop = false;
            }
        }
        if (stop)
            return false;
        return true;
    }
}