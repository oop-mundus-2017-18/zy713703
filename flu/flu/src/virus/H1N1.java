package virus;

public class H1N1 extends Virus {

    public H1N1() {
        this.name = TypeVirus.H1N1;
        this.virulenceRate = 0.2; // infection rate
        this.mortalityRate = 0.1;  // death rate
        this.incubationTime = 1;  // infected but not ill
        this.contagious = 1;  //  to be infected
        this.recover = 2;
        }
    }

//class TestH1N1{
//    public static void main(String [] args) {
//    H1N1 h = new H1N1();
//    System.out.println(h.getName());
//    }
//}