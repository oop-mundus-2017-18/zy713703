package Beings;

import java.beans.PropertyVetoException;

/**
 * @Author: Zhang Yuxin
 * @Date: 2018/2/23
 */
public enum Virus {
    H5N1("h3n2",0.5,2,0.1),H1N1("h1n1",0.5,2,0.1),H0N0("h0n0",1,2,0.9);
    private String name;
    private double contag_rate;
    private int incu_period;
    private double death_rate;
    public String getName() {
        return name;
    }

    public double getDeath_rate() {
        return death_rate;
    }

    public void setDeath_rate(double death_rate) {
        this.death_rate = death_rate;
    }



    public void setName(String name) {
        this.name = name;
    }

    public double getContag_rate() {
        return contag_rate;
    }

    public void setContag_rate(double contag_rate) {
        this.contag_rate = contag_rate;
    }


    Virus(String name,double contag_rate,int time,double death_rate) {
        this.name = name;
        this.contag_rate = contag_rate;
        this.incu_period = time;
        this.death_rate = death_rate;
    }
}
