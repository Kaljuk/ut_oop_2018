import java.util.Scanner;

/**
 * ArvuliseVastusegaKüsimus implements Küsimus
 */
public class ArvuliseVastusegaKüsimus implements Küsimus {
    private String kysTekst;
    private Double maxValue;
    private Double minValue;

    private boolean hasMaxMin = false;
    private boolean isDouble = true;

    public ArvuliseVastusegaKüsimus(String tekst) {
        this.kysTekst = tekst;
    }
    public ArvuliseVastusegaKüsimus(String tekst, Double kMin, Double kMax) {
        this.kysTekst = tekst;
        this.minValue = kMin;
        this.maxValue = kMax;
        this.hasMaxMin= true;
    }

    @Override
    public String tekst() {
        return this.kysTekst;
    }
    @Override
    public String küsiVastus(Scanner sc) {
        String vastus = "";
        String errMessage;
        boolean gotAnswer = false;
        System.out.println(this.kysTekst);
        System.out.print("> ");
        do {
            errMessage = "";
            try {
                vastus = sc.nextLine();

                if (hasMaxMin && isNumberic(vastus)) {
                    gotAnswer = true;
                    if (this.minValue != null) {
                        if (Double.parseDouble(vastus) < this.minValue) {
                            errMessage = String.format("Arv ei tohi olla väiksem kui %.1f\n> ", this.minValue);
                            gotAnswer  = false;
                        } 
                    }
                    if (this.maxValue != null) {
                        if (Double.parseDouble(vastus) > this.maxValue) {
                            errMessage = String.format("Arv ei tohi olla suurem kui %.1f\n> ", this.maxValue);
                            gotAnswer  = false;
                        }
                    }
                    System.out.print(errMessage); 
                } else if (isNumberic(vastus)) {
                    gotAnswer = true;
                } else {
                    System.out.print("Palun sisesta arv!\n> ");
                }
            } catch(Exception e) {
                System.out.println("V"+vastus);
                System.out.println(e);
            }
        } while(!gotAnswer);
        //System.out.println("Saved answer"+vastus);
        return vastus;
    }

    private boolean isNumberic (String s) {
        try { 
            double d = Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}