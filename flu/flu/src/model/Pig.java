package model;


import simulator.Field;
import simulator.Location;
import virus.H1N1;

public class Pig extends Animal {
    public Pig(Field field, Location location){
        super(Being.PIG, field, location);
        this.type = Being.PIG;
        this.virus = new H1N1();
    }
}
