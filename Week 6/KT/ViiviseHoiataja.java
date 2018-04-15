import java.util.ArrayList;
import java.util.List;

/**
 * ViiviseHoiataja
 */
public class ViiviseHoiataja implements Kontrollija {
    private double lubatudViivis;
    private List<String> hoiatatavad = new ArrayList<String>();

    public ViiviseHoiataja(double annaLubatudViivis) {
        super();
        this.lubatudViivis = annaLubatudViivis;
    }
    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viiviseSuurus) {
        if (
            this.hoiatatavad.contains(laenutajaNimi) == false
            && viiviseSuurus > this.lubatudViivis
        ) {
            // Lisa laenutaja hoiatatavate listi
            this.hoiatatavad.add(laenutajaNimi);
        }
    }

    public List<String> getHoiatatavadLaenutajad() {
        return this.hoiatatavad;
    }

}