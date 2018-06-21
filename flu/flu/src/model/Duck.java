package model;


import simulator.Field;
import simulator.Location;
import virus.H5N1;

public class Duck extends Animal {
    public Duck(Field field, Location location){
        super(Being.DUCK, field, location);
        this.virus = new H5N1();
    }
}
