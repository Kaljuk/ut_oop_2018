import java.time.LocalDateTime;

/**
 * Arvuti
 */
public class Arvuti {
    protected String tootja;
    protected boolean kiirtoo;
    protected LocalDateTime registreerimisAeg;

    public Arvuti () {

    }

    public String getTootja() {
        return this.tootja;
    }
    public boolean onKiirtoo() {
        return this.kiirtoo;
    } 

    public LocalDateTime getRegistreerimiseAeg() {
        return this.registreerimisAeg;
    }

    public double arvutaArveSumma() {
        return 0.1;
    }

    // Setters
    public void setRegistreerimisAeg(LocalDateTime aeg) {
        this.registreerimisAeg = aeg;
    }

}