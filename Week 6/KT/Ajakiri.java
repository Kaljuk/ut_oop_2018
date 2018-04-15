/**
 * Ajakiri extends Teos
 */
public class Ajakiri extends Teos {

    private int ilmumisAasta;

    public Ajakiri(String teoseKirjeldus, String teoseTahis, String teoseLaenutaja, int days, int ilmumisaasta) {
        super(teoseKirjeldus, teoseTahis, teoseLaenutaja, days);
        this.ilmumisAasta = ilmumisaasta;
    }

    public boolean kasHoidlast() {
        return (ilmumisAasta <= 2000);
    }

    public String toString() {
        return String.format("[Ajakiri] %s", super.toString());
    }
}