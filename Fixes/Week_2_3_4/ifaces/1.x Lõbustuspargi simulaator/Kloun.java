// Muutsin täpitähed ära  ü -> y
public class Kloun {
    private String nimi;
    public Kloun(String nimi) {
      this.nimi = nimi;
    }
    public void esine(Kylastaja kylastaja) {
      kylastaja.lisaKirjeldus("nägin klouni nimega " + nimi);
    }
  }