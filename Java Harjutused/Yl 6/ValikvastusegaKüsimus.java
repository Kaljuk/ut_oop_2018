import java.util.*;

/**
 * ValikvastusegaKüsimus
 */
public class ValikvastusegaKüsimus implements Küsimus {
    private String kysTekst;
    private List<String> kys;

    public ValikvastusegaKüsimus(String tekst, List<String> vastused) {
        this.kysTekst = tekst;
        this.kys      = vastused;
    }

    @Override
    public String tekst() {
        return this.kysTekst;
    }
    @Override
    public String küsiVastus(Scanner sc) {
        int v=1;
        boolean gotAnswer = false;
        String vastus = "";
        String valik;
        String errMessage = "Palun sisesta valiku number!\n> ";
        
        System.out.println(this.kysTekst);
        System.out.println("\tValikud:");
        for(String s : this.kys) {
            System.out.println(
                String.format("\t\t%d: %s", v++, s)
            );
        };
        System.out.print("\tSisesta valiku number!\n> ");
        // Get answer
        do {
            valik = sc.nextLine();
            try {
                v = Integer.parseInt(valik);
                if (v >= 1 && v <= this.kys.size()) {
                    vastus = this.kys.get(v-1);
                    gotAnswer = true;
                } else {
                    System.out.println(errMessage);    
                }
            } catch(Exception e) {
                System.out.println(errMessage);
            }
        } while(!gotAnswer);

        return vastus;
    }
    
}