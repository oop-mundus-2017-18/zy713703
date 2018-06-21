package model;

import states.*;
import simulator.*;
import java.util.Random;

public class Person extends LivingBeings {
    private static final double VACCINATED_RATE = 0.2;

    // manager of the state
    StatesManager statesManager;
    // after infected, the time of infection is increment
    private int timeInfection;
    // after contagious, the time of contagious is increment
    private int timeContagious;
    // after contagious, the time of contagious is increment
    private int timeRecover;
    // if the person is sick or contagious, she will move slowly
    private int moveSlowly;
    // if the person was vaccinated
    private boolean isVaccinated;
    // if the person was infected but recovered
    private boolean isResistant;
    // healthy person
    private boolean healthyPerson;

    public Person(Field field, Location location) {
        super(State.HEALTHY, Being.PERSON, field, location);
        this.statesManager = new StatesManagerPerson(State.HEALTHY, field, location);
        this.timeInfection = 0;
        moveSlowly = 0;
        isVaccinated = false;
        isResistant = false;

        Random random = new Random();
        this.healthyPerson = random.nextBoolean();
    }

    @Override
    public void act() {
        if (isAlive()) {
            updateTime();

            if (!isVaccinated && !isResistant)
                this.state = statesManager.getState(healthyPerson, virus, timeInfection, timeContagious, timeRecover);

            if ((state.equals(State.HEALTHY) || state.equals(State.RECOVERING))) {
                Location newLocation = getField().freeAdjacentLocation(getLocation());

                if (newLocation != null)
                    setLocation(newLocation);

                if (state.equals(State.HEALTHY)) {
                    resetTime();
                    Random random = new Random();
                    if (random.nextDouble() <= VACCINATED_RATE) isVaccinated = true;
                } else {
                    isResistant = true;
                }

            } else if  (state.equals(State.SICK) || state.equals(State.CONTAGIOUS)) {
                if ((moveSlowly % 20) == 0) {
                    Location newLocation = getField().freeAdjacentLocation(getLocation());

                    if (newLocation != null)
                        setLocation(newLocation);
                }
                moveSlowly++;
            } else if (state.equals(State.DEAD)) {
                setDead();
            }
        }
    }

    private void resetTime() {
        timeContagious = 0;
        timeInfection = 0;
        timeRecover = 0;
    }

    @Override
    protected void updateTime() {
        if (state.equals(State.SICK)) {
            virus = statesManager.getCurrentVirus();
            timeInfection++;
        }
        if (state.equals(State.CONTAGIOUS))
            timeContagious++;
        if (state.equals(State.RECOVERING))
            timeRecover++;
    }

    /**
     * Inform if someone is resistant to the virus
     * @return true if the person is resistant by default or was vaccinated against the virus.
     */
    @Override
    public boolean isResist() {
        return isResistant;
    }

    @Override
    public void setResist(boolean resistant) {
        isResistant = resistant;
    }
}