package states;

public enum State {
    HEALTHY("healthy"),
    SICK("sick"),
    CONTAGIOUS("contagious"),
    RECOVERING("recovering"),
    DEAD("dead");

    private String state;

    State(String state) {
        this.state = state;
    }

    public String toString() {
        return this.state;
    }

    public boolean isEquals(State state) { return this.state.equalsIgnoreCase(state.toString()); }


    public static State fromString(String status){
        if (status != null){
            for (State d : State.values()){
                if (d.toString().equalsIgnoreCase(status)) return d;
            }
        }
        return null;
    }
}