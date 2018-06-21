package virus;

public enum TypeVirus {
    H1N1("H1N1"), H5N1("H5N1");
// These viruses are to eliminate randomness -
//  for testing only.
//    MINI4TESTING(0, 0), MAXI4TESTING(1, 1);

    private String name = "";
    
    TypeVirus(String name){
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
}
