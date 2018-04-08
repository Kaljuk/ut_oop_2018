import java.util.Arrays;

/**
 * Teos
 */
public abstract class Teos implements Comparable<Teos>{
    private String teoseKirjeldus; 
    private String teoseTahis;
    private String teoseLaenutaja;
    private int days;
    public Teos(String teoseKirjeldus, String teoseTahis, String teoseLaenutaja, int days) {
        this.teoseKirjeldus = teoseKirjeldus; 
        this.teoseTahis = teoseTahis;
        this.teoseLaenutaja = teoseLaenutaja;
        this.days = days;
    }

    public abstract boolean kasHoidlast();
    public int laenutusaeg() {
        switch (this.teoseTahis) {
            case "roheline":
                return 1;
            case "puudub":
                return 14;
            case "kollane":
                return 30;
            case "sinine" :
                return 60;
            //break;
            default:
                return 0;
        }
    };
    public double paevaneViivis() {
        // roheline-2, puudub-0.15, kollane-sinine-0.05
        switch (this.teoseTahis) {
            case "kollane":
            case "sinine" :
                return 0.05;
            //break;
            case "puudub":
                return 0.15;
            case "roheline":
                return 2.0;
            default:
                return 0;
        }
    }

    public void arvutaViivis(Kontrollija k) {
        if (laenutusaeg()< this.days) {
            k.salvestaViivis(this.teoseLaenutaja, this.teoseKirjeldus, this.days*paevaneViivis());
        }
    }

    public String toString() {
        String finalString = String.format(
            "TeoseKirjeldus: %s, VajaTellidaHoidlast: %b, TeoseLaenutaja: %s", 
            this.teoseKirjeldus, kasHoidlast(), this.teoseLaenutaja
        );
    }

    public String getTeoseKirjeldus() {
        return this.teoseKirjeldus;
    }

    @Override
    public int compareTo(Teos teineTeos) {
        return this.teoseKirjeldus.compareTo(anotherString.getTeoseKirjeldus());
    }
}