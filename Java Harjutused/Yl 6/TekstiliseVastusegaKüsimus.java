import java.util.*;

/**
 * TekstiliseVastusegaKüsimus
 */
public class TekstiliseVastusegaKüsimus implements Küsimus {

    private String kysTekst;
    private boolean hasLength=false;
    private int kyslength;

    public TekstiliseVastusegaKüsimus(String inTekst) {
        this.kysTekst = inTekst;
    }
    public TekstiliseVastusegaKüsimus(String inTekst, int inKysLength) {
        this.hasLength = true;
        this.kyslength = inKysLength;
        this.kysTekst     = inTekst;
    }

    @Override
    public String küsiVastus(Scanner sc) {
        String vastus;
        boolean gotAnswer = false;
        System.out.println(this.kysTekst);
        System.out.print("- ");
        do {
            vastus = sc.nextLine();
            if (this.hasLength) {
                if (vastus.length() <= this.kyslength) {
                    gotAnswer = true; 
                } else {
                    System.out.printf("\nPalun piirdu vastamisel %d sümboliga!\n> ", this.kyslength);
                }
            } else {
                gotAnswer = true;
            }
        } while(!gotAnswer);
        return vastus;
    }

    @Override
    public String tekst() {
        return this.kysTekst;
    }
}