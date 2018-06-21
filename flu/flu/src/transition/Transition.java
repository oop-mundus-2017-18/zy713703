package transition;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import events.Event;
import states.State;
import virus.Virus;


class Transition {
    private static final State HEALTHY = null;
    private static final Event CONTACT_WITH_CONTAGIOUS_PERSON = null;
    private static final State INFECTED = null;
    double mortality; // dead rate
    double virulence; // infect others rate
    int contagious = 2;
    final Map<State, Map<Event, Supplier<State>>> transitions
            = new HashMap<>();

    Transition(Virus virus) {
        mortality = virus.getMortalityRate();
        virulence = virus.getVirulenceRate();
        put(HEALTHY, CONTACT_WITH_CONTAGIOUS_PERSON,
                () -> happens(virulence)
                    ? INFECTED
                    : HEALTHY);
    }


    private void put(State state, Event event, Supplier<State> fn) {
        if (transitions.get(state) == null) {  // no value for state key
            transitions.put(state, new HashMap<>());
        }
        transitions.get(state).put(event, fn);
    }


    private Supplier<State> get(State state, Event event) {
        return transitions.get(state).get(event);
    }

    State nextState(State currentState, Event event) {
        Supplier<State> fn = get(currentState, event);
        return fn != null ? fn.get() : currentState;
    }

    boolean happens(double chance) {
        return Math.random() < chance;
    }
}
