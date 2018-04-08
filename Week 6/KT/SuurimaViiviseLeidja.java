import java.util.ArrayList;
import java.util.List;

/**
 * SuurimaViiviseLeidja implements Kontrollija
 */
public class SuurimaViiviseLeidja implements Kontrollija {
    private String viiviseOmanik = "";
    private String viiviseTeoseKirjeldus= "";
    private double viivis;
    private boolean viivisSet = false;

    public void saadaHoiatus() {
        System.out.println(this.viiviseOmanik + " " + this.viiviseTeoseKirjeldus);
    }

    public void salvestaViivis(String laenutajaNimi, String teoseKirjeldus, double viiviseSuurus) {
        if (viiviseSuurus > this.viivis || this.viivisSet == false) {
            this.viivisSet     = true;

            this.viiviseOmanik = laenutajaNimi;
            this.viivis        = viiviseSuurus;
            this.viiviseTeoseKirjeldus = teoseKirjeldus;
        }
    };

}