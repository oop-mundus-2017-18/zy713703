package virus;

public abstract class Virus {
    protected TypeVirus name; // The name of Virus
    protected double virulenceRate; // of the virus
    protected double mortalityRate; // To verify if a person will recover from the illness or die
    protected int incubationTime; // days that individuals sick but not contagious
    protected int contagious; // days that individuals contagious
    protected int recover;  // days that individuals recover

    public double getVirulenceRate() {
        return virulenceRate;
        }
    
    public double getMortalityRate() {
        return mortalityRate;
        }
    
    public TypeVirus getName() {
        return name;
        }
    
    public int getIncubationTime() {
        return incubationTime;
        }
    
    public int getContagious() {
        return contagious;
        }
    
    public int getRecover() {
        return recover;
        }
}