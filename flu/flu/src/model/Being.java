package model;

public enum Being {
    PERSON("person"),
    CHICKEN("chicken"),
    DUCK("duck"),
    PIG("pig");
    
    private String being = "";
    Being(String being) {
        this.being = being;
    }

    public String toString() {
        return this.being;
    }
    
    public boolean isEquals(Being being) {
        return this.being.equalsIgnoreCase(being.toString());
    }
}
