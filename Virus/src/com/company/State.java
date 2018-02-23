package com.company;

public enum State {
    Health("Health"), Infection("Infection"), Sick("Sick"),
    Contagious("contagious"), Recover("Recover"), Death("Death");

    private final String stateName;

    State(String name){
        this.stateName = name;
    }
    public String getName(){
        return stateName;
    }
    public boolean isEquals(State state) {
        return this.stateName.equalsIgnoreCase(state.getName());
    }
    public static State fromString(String status){
        if (status != null){
            for (State d : State.values()){
                if (d.getName().equalsIgnoreCase(status))
                    return d;
            }
        }
        return null;
    }
}
