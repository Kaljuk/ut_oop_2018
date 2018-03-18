import java.util.ArrayList;
import java.util.List;

/**
 * Kylastaja
 */
public class Kylastaja {
    private List<String> kylastuseKirjeldused;
    private int vanus;
    private double kulud = 0;
    
    public Kylastaja(int inVanus) {
        this.kylastuseKirjeldused = new ArrayList<String>();
        this.vanus = inVanus;
    }

    public void lisaKirjeldus(String kylastuseKirjeldus) {
        this.kylastuseKirjeldused.add(kylastuseKirjeldus);
    }

    public List<String> koikKirjeldused() {
        return this.kylastuseKirjeldused;
    }

    public void lisaKulu(double lisanduvKulu) {
        this.kulud = lisanduvKulu;
    }

    // GET
    public int getVanus() {
        return this.vanus;
    }
    public double kuludeSumma() {
        return this.kulud;
    }
}