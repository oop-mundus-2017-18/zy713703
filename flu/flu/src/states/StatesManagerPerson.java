package states;


import model.LivingBeings;
import simulator.Field;
import simulator.Location;
import simulator.Randomizer;
import virus.Virus;

import java.util.Random;

public class StatesManagerPerson extends StatesManager {

    public StatesManagerPerson(State stateType, Field field, Location location) {
        super(stateType, field, location);
    }

    @Override
    protected State analyseStateContagious(Virus virus, int timeContagious) {
        return null;
    }

    @Override
    public State getState(boolean healthyPerson, Virus virus, int timeInfection, int timeContagious, int timeRecover) {
        if (currentState.isEquals(State.HEALTHY)) {
            currentState = analyseStateHealthy();
        } else if (currentState.isEquals(State.SICK)) {
            currentState = analyseStateSick(virus, timeInfection);
        } else if (currentState.isEquals(State.CONTAGIOUS)) {
            currentState = analyseStateContagious(healthyPerson, virus, timeContagious);
        } else if (currentState.isEquals(State.RECOVERING)) {
            currentState = analyseStateRecover(virus, timeRecover);
        }
        return currentState;
    }

    @Override
    public State analyseStateSick(Virus virus, int timeInfection) {
        if (timeInfection >= virus.getIncubationTime())
            return State.CONTAGIOUS;
        return State.SICK;
    }

    private State analyseStateRecover(Virus virus, int timeRecover) {
        if (timeRecover == virus.getRecover())
            return State.HEALTHY;
        return State.RECOVERING;
    }

    @Override
    public State analyseStateContagious(boolean healthyPerson, Virus virus, int timeContagious) {
        Random rand = Randomizer.getRandom();
        if (timeContagious == virus.getContagious()) {
            if (rand.nextDouble() <= virus.getMortalityRate() && !healthyPerson)
                return State.DEAD;
            else
                return State.RECOVERING;
        }
        return State.CONTAGIOUS;
    }

    @Override
    public State getState(Virus virus, int timeInfection, int timeContagious) {
        return null;
    }

    @Override
    public State analyseStateHealthy() {
        for (Location loc : field.adjacentLocations(location)) {
            LivingBeings beings = (LivingBeings) field.getObjectAt(loc);
            Random rand = Randomizer.getRandom();
            if (beings != null) {
                if (beings.getState().isEquals(State.CONTAGIOUS)) {
                    if(rand.nextDouble() <= beings.getVirus().getRecover()){
                        currentVirus = beings.getVirus();
                        return State.SICK;
                    }
                } else if (beings.isResist()) {
                    return State.RECOVERING;
                }
            }
        }
        return State.HEALTHY;
    }

}