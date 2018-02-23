package Virus;

public class H5N1 extends Virus {
    H5N1() {
        this.virusName = VirusType.H5N1;
        this.infectionTime = 5;
        this.recoverTime = 2;
        this.contagiousTime = 3;
        this.mortalityRate = 0.80;
        this.infectionRate = 0.70;
    }

}