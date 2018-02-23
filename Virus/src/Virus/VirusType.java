package Virus;

public enum VirusType {
    H1N1("H1N1"), H5N1("H5N1");

    private String name= "";
    VirusType(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}
