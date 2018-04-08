//import java.util.ArrayList;
//import java.util.List;
import java.util.*;

/**
 * Ankeet
 */
public class Ankeet {
    private String pealkiri;
    private List<Küsimus> kysimused = new ArrayList<Küsimus>();

    public Ankeet(String inPealkiri) {
        this.pealkiri = inPealkiri;
    }

    public void lisaKüsimus(Küsimus inKys) {
        kysimused.add(inKys);
    }

    public String esitaKüsimusedJaTagastaRaport() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int q=1;

        System.out.printf("%s\n", this.pealkiri);

        sb.append(this.pealkiri+"\n");
        for (Küsimus k : kysimused) {

            System.out.printf("\n%d. ", q);  
            sb.append(
                String.format(
                    "\n%d. %s\n - %s\n", q, k.tekst(), k.küsiVastus(sc)
                )
            );
            // Append linebreak if needed
            q++;
        }
        return sb.toString();
    }
}