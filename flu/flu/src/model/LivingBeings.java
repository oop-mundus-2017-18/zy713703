package model;

import states.*;
import virus.*;
import simulator.*;

/**
 * @author ZHANG
 * @version 25/05/2018
 */
public abstract class LivingBeings {
    protected State state;
    protected Being type;
    protected Virus virus;
    protected boolean alive;
    protected Field field;
    protected Location location;
    private Integer age;
    private Integer stateAge;
    private Double speedRate;

    public LivingBeings(State state, Being type, Field field, Location location) {
        this.state = state;
        this.type = type;
        this.field = field;
        this.location = location;
        this.alive = true;
        setLocation(location);
    }


    abstract public void act();
    public State getState() {
        return state;
    }
    

    public Being getType() {
        return type;
    }
    

    public Virus getVirus() {
        return virus;
    }


    public boolean isAlive()
    {
        return alive;
    }
    
    protected void setDead() {
        alive = false;
        if (location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    
    protected Location getLocation() {
        return location;
    }
    
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    protected Field getField() {
        return field;
    }
    
    public Virus getName() {
        return virus;
    }
    
    
    abstract protected void updateTime();
    
    public abstract boolean isResist();
    
    public void setResist(boolean resistant) {
        
    }

    protected void changeState(State state) {
        this.state = state;
        stateAge = age;
        if (State.RECOVERING.equals(state))
            speedRate = 0.5;
        if (State.HEALTHY.equals(state))
            speedRate = 1.;
    }

    protected void fallIll(Virus virus) {
        this.virus = virus;
        changeState(State.SICK);
    }

    protected void recover() {
        changeState(State.HEALTHY);
    }


}