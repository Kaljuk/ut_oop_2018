/**
 * VanuseKontrollija
 */
public class VanuseKontrollija implements Lobustus {
    private int noutudVanus;
    private Lobustus delegaat;
    public VanuseKontrollija(int noutudVanus, Lobustus delegaat) {
        this.noutudVanus = noutudVanus;
        this.delegaat    = delegaat;
    }

    public void lobusta(Kylastaja isik) {
        if (isik.getVanus() >= noutudVanus) {
            this.delegaat.lobusta(isik);
        } else {
            System.out.println("külastaja ei läbinud vanusekontrolli");
        }
    }

}