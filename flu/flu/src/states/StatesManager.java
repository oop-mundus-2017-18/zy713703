package states;

import simulator.*;
import virus.*;

public abstract class StatesManager {
    protected State currentState;
    protected Field field;
    protected Location location;
    protected Virus currentVirus;

    protected StatesManager(State state, Field field, Location location) {
        currentState = state;
        this.field = field;
        this.location = location;
    }

    protected abstract State analyseStateContagious(Virus virus, int timeContagious);

    public abstract State analyseStateContagious(boolean healthyPerson, Virus virus, int timeContagious);

    public abstract State getState(Virus virus, int timeInfection, int timeContagious);

    public abstract State getState(boolean healthyPerson, Virus virus, int timeInfection, int timeContagious, int timeRecover);

    public abstract State analyseStateSick(Virus virus, int timeInfection);

    public abstract State analyseStateHealthy();

    public Virus getCurrentVirus() {
        return currentVirus;
    }
}