/**
 * LobustavKloun
 */
public class LobustavKloun implements Lobustus {
    private Kloun kloun;

    public LobustavKloun(Kloun inKloun) {
        kloun = inKloun;
    }

    public void lobusta(Kylastaja isik) {
        kloun.esine(isik);
    }
}