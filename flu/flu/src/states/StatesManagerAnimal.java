package states;

import java.util.Random;

import model.Being;
import model.LivingBeings;
import simulator.Field;
import simulator.Location;
import simulator.Randomizer;
import virus.Virus;


public class StatesManagerAnimal extends StatesManager {
    private Being animalType;

    public StatesManagerAnimal(State stateType, Being animal, Field field, Location location) {
        super(stateType, field, location);
        this.animalType = animal;
    }

    @Override
    public State getState(Virus virus, int timeInfection, int timeContagious) {
        if (currentState.isEquals(State.HEALTHY)) {
            currentState = analyseStateHealthy();
        } else if (currentState.isEquals(State.SICK)) {
            currentState = analyseStateSick(virus, timeInfection);
        } else if (currentState.isEquals(State.CONTAGIOUS)) {
            currentState = analyseStateContagious(virus, timeContagious);
        }
        return currentState;
    }

    @Override
    public State getState(boolean healthyPerson, Virus virus, int timeInfection, int timeContagious, int timeRecover) {
        return null;
    }

    @Override
    public State analyseStateSick(Virus virus, int timeInfection) {
        if (timeInfection >= virus.getIncubationTime())
            return State.CONTAGIOUS;
        return State.SICK;
    }

    @Override
    protected State analyseStateContagious(Virus virus, int timeContagious) {
        if (timeContagious == virus.getContagious())
            return State.DEAD;
        return State.CONTAGIOUS;
    }

    @Override
    public State analyseStateContagious(boolean healthyPerson, Virus virus, int timeContagious) {
        return null;
    }

    @Override
    public State analyseStateHealthy() {
        for (Location loc : field.adjacentLocations(location)) {
            LivingBeings beings = (LivingBeings) field.getObjectAt(loc);
            Random rand = Randomizer.getRandom();
            if (beings != null && beings.getState().isEquals(State.CONTAGIOUS) && rand.nextDouble() <= beings.getVirus().getRecover()) {
                if (animalType.isEquals(beings.getType())){
                    currentVirus = beings.getVirus();
                    return State.SICK;
                }
                else if((animalType.isEquals(Being.DUCK) && beings.getType().isEquals(Being.CHICKEN)) ||
                        (animalType.isEquals(Being.CHICKEN) && beings.getType().isEquals(Being.DUCK))){
                    currentVirus = beings.getVirus();
                    return State.SICK;
                }
            }
        }
        return State.HEALTHY;
    }
}