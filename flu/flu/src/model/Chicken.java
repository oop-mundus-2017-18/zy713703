package model;

import simulator.Field;
import simulator.Location;
import virus.H5N1;

public class Chicken extends Animal {
    public Chicken(Field field, Location location){
        super(Being.CHICKEN, field, location);
        this.virus = new H5N1();
    }
}