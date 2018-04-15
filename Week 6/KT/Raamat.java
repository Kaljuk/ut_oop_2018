/**
 * Raamat extends Teos
 */
public class Raamat extends Teos {

    public Raamat(String teoseKirjeldus, String teoseTahis, String teoseLaenutaja, int days) {
        super(teoseKirjeldus, teoseTahis, teoseLaenutaja, days);

    }

    public boolean kasHoidlast() {
        return (this.teoseTahis=="kollane" || this.teoseTahis=="sinine");
    }
    
    public String toString() {
        return String.format("[Raamat] %s", super.toString());
    }

}