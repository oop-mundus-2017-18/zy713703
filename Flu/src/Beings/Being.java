package Beings;

import World.Location;
import World.State;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zhang Yuxin
 * @Date: 2018/2/25
 */
public class Being {
    private int age;
    private boolean IsMale;
    private State state;
    public Location location = new Location(0,0);
    private boolean IsVaccinal;
    private List<Virus> DNA_Flaw = new ArrayList<>();
    private List<Virus> Antibody = new ArrayList<>();
    private int inf_time = 0;
    private int recov_time = 0;
    private int conta_time = 0;
    private int sick_time = 0;
    private Virus virus = null;
    public Being(){
        this.state = State.HEALTHY;


    }
    public void say(){
        System.out.println(location.getCol()+" , "+location.getRow());
    }
    public int getSick_time() {
        return sick_time;
    }
    public void setLocation(Location location){
        this.location = location;
    }


    public void setSick_time() {
        this.sick_time++;
    }

    public int getConta_time() {
        return conta_time;
    }

    public void setConta_time() {
        this.conta_time++;
    }

    public Virus getVirus() {
        return virus;
    }

    public void setVirus(Virus virus) {
        this.virus = virus;
    }

    public void setLocation(int col,int row) {
        this.location.setCol(col);
        this.location.setRow(row);
    }

    public List<Virus> getDNA_Flaw() {
        return DNA_Flaw;
    }

    public void setDNA_Flaw(List<Virus> DNA_Flaw) {
        this.DNA_Flaw = DNA_Flaw;
    }

    public List<Virus> getAntibody() {
        return Antibody;
    }

    public void setAntibody(List<Virus> antibody) {
        Antibody = antibody;
    }

    public Being(int age, boolean isMale, State state, Location location, boolean isVaccinal, ArrayList dna, ArrayList antibody, Virus virus) {
        this.age = age;
        this.IsMale = isMale;
        this.state = state;
        this.location = location;
        this.IsVaccinal = isVaccinal;
        this.DNA_Flaw = dna;
        this.Antibody = antibody;
        this.virus = virus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;

    }
    public boolean isMale() {
        return IsMale;
    }

    public void setMale(boolean male) {
        IsMale = male;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isVaccinal() {
        return IsVaccinal;
    }

    public void setVaccinal(boolean vaccinal) {
        IsVaccinal = vaccinal;
    }

    public int getInf_time() {
        return inf_time;
    }

    public void setInf_time() {
        this.inf_time++;
    }

    public int getRecov_time() {
        return recov_time;
    }

    public void setRecov_time() {
        this.recov_time++;
    }
    public void AddAntibody(Virus virus){
        Antibody.add(virus);
    }
    public boolean CheckAntibody(Virus virus){
        for (Virus virus1 : Antibody) {
            if (virus1 == virus){
                return true;
            }
        }
        return false;
    }
}
