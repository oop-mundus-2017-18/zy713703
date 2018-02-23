package com.company;

public enum Organism {
    Person("person"),  Chicken("chicken"), Duck("duck"),  Pig("pig");

    private String OrganismName;
    Organism(String name) {
        this.OrganismName = name;
    }
    public String toString() {
        return this.OrganismName;
    }


    public boolean isEquals(Organism organism) {
        return this.OrganismName.equalsIgnoreCase(organism.toString());
    }
}
