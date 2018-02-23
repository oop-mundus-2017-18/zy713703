package Virus;

public class H1N1 extends Virus {
    H1N1() {
        this.virusName = Virus.VirusType.H1N1;
        this.infectionTime = 1;
        this.recoverTime = 3;
        this.contagiousTime = 5;
        this.mortalityRate = 0.50;
        this.infectionRate = 0.70;
    }

}
