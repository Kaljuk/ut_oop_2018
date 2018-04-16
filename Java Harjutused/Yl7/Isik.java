/**
 * Isik
 */
public class Isik {
    // Related Lists
    private List<String> vanemad; // Change into a list<Isik> later 
    private List<String> lapsed; // Change into a list<Isik> later
    // Persons data 
    private String gender;

    public Isik() {
        
    }

    // Setters
    public void setGender (String g) {
        this.gender = g;
    }
    // Parents
    public void setParents(List<String> parents) {
        this.vanemad = parents;
    }

    // Set children 
    public addChild(String isikukood) {
        this.lapsed.add(isikukood);
    }
}