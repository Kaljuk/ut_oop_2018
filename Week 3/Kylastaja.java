import java.util.*;

/**
 * Külastaja
 */
public class Kylastaja {
    // private List<String> kylastuseKirjeldused;
    private List<String> kylastuseKirjeldused = new ArrayList<String>();
    
    // ArrayList<String>
    public Kylastaja(String nimi) {
        // kylastuseKirjeldused.add(list);
        System.out.println(nimi + " was created");
    }

    public void lisaKirjeldus (String sone) {
        kylastuseKirjeldused.add(sone);
    }

    public List<String> koikKirjeldused() {
        return kylastuseKirjeldused;
    }

}

/*
class Vaateratas {
    public void lobusta(Kylastaja inimene) {
        inimene.lisaKirjeldus("kylastasin vaateratast");
    }
} */
/*
class Lobustuspark {
    private Vaateratas lobustus;

    public Lobustuspark(Vaateratas ratas) {
        lobustus = ratas;
    }
    public void alustaSeiklust(Kylastaja inimene) {
        System.out.println("alustan seiklust");
        lobustus.lobusta(inimene);
        inimene.koikKirjeldused();
    }
}
*/
