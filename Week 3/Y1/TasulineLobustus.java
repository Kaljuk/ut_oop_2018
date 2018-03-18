/**
 * TasulineLobustus
 */
public class TasulineLobustus implements Lobustus {
    private double hind;
    private Lobustus delegaat;

    public TasulineLobustus(double hind, Lobustus delegaat) {
        this.hind = hind;
        this.delegaat = delegaat;    
    }

    public void lobusta(Kylastaja isik) {
        this.delegaat.lobusta(isik);
        isik.lisaKulu(hind);
        isik.lisaKirjeldus(
            String.format("tasusin külastuse eest %d", hind)
        );
    }
}