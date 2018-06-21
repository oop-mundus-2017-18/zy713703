package virus;

public class H5N1 extends Virus {

    public H5N1() {
        this.name = TypeVirus.H5N1;
        this.virulenceRate = 0.4;
        this.mortalityRate = 0.33;
        this.incubationTime = 2;
        this.contagious = 2;
        this.recover = 3;
        }
    }