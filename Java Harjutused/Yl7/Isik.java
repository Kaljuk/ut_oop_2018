import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Isik
 */
public class Isik {
    // Related Lists
    private Isik father;
    private Isik mother;

    private List<Isik> lapsed = new ArrayList<Isik>(); // Change into a list<Isik> later
    // Persons data 
    private String gender;
    private String isikukood;

    private String[] fnames = null;
    private String lname = null;

    public Isik() {
    }

    // Setters
    public void setIsikukood(String newIsik) {
        this.isikukood = newIsik;
    }

    public void addFName(String name) {
        
    }

    public void setGender (String g) {
        this.gender = g;
    }
    // Parents
    public void setFather(Isik f) {
        this.father = f;
    }
    public void setMother(Isik m) {
        this.mother = m;
    }

    // Set children 
    public void addChild(Isik laps) {
        this.lapsed.add(laps);
    }

    // Getters
    public String getIsikukood() {
        return this.isikukood;
    }
    public String getSugu() {
        return this.gender;
    }
    public String[] getEesnimed() {
        return this.fnames;
    }
    public String getPerenimi() {
        return this.lname;
    }

    public Isik getEma() {
        return this.mother;
    }
    public Isik getIsa() {
        return this.father;
    }

    public HashSet<Isik> getLapsed() {
        HashSet<Isik> hashLapsed = new HashSet<Isik>();
        for(Isik i: lapsed){
            hashLapsed.add(i);
        }
        return hashLapsed;
    }

    public HashSet<Isik> otsiEellased() {
        HashSet<Isik> eellased = new HashSet<Isik>();
        return eellased;
    }

    public String toString() {
        StringBuilder eesnimed = new StringBuilder();
        for(String s : this.fnames) {
            eesnimed.append(s);
            eesnimed.append(" ");
        }
        String sEesnimed = (this.fnames != null)? eesnimed.toString(): "<?>";
        return String.format("%s%s (%s)", sEesnimed, (this.lname != null)?this.lname:"<?>", this.isikukood);
    }
}