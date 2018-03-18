import java.util.ArrayList;
import java.util.List;

/**
 * Kylastaja
 */
public class Kylastaja {
    private List<String> kylastuseKirjeldused;
    
    public Kylastaja() {
        this.kylastuseKirjeldused = new ArrayList<String>();
    }

    public void lisaKirjeldus(String kylastuseKirjeldus) {
        this.kylastuseKirjeldused.add(kylastuseKirjeldus);
    }
    public List<String> koikKirjeldused() {
        return this.kylastuseKirjeldused;
    }
}