package Virus;

public class Virus {
    protected VirusType virusName;
    protected int infectionTime;
    protected int contagiousTime;
    protected int recoverTime;
    protected double infectionRate;
    protected double mortalityRate;

    public int getInfectionTime() {
        return infectionTime;
    }
    public int getContagiousTime() {
        return contagiousTime;
    }
    public int getRecoverTime() {
        return recoverTime;
    }
    public double getInfectionRate() {
        return infectionRate;
    }
    public double getMortalityRate() {
        return mortalityRate;
    }
}
