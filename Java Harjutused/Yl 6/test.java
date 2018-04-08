import java.util.Arrays;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        Ankeet a = new Ankeet("Ankeet nr. 1");

        //a.lisaKüsimus(new ValikvastusegaKüsimus("Kumb sulle rohkem meeldib, kas kukk või kana?",
        //        Arrays.asList("kukk", "kana")));

        a.lisaKüsimus(new TekstiliseVastusegaKüsimus("Mis sind vaevab?"));
        a.lisaKüsimus(new TekstiliseVastusegaKüsimus("Mis su nimi on?", 30)); // 30 on maksimaalne vastuse pikkus
        a.lisaKüsimus(new ArvuliseVastusegaKüsimus("Kui raske sa oled?", 10.0, 200.0)); // 10.0 on minimaalne lubatud vastus ja 200.0 maksimaalne
        a.lisaKüsimus(new ArvuliseVastusegaKüsimus("Mitu last sul on?", 0.0, null)); // null tähendab, et vastuse ülempiiri pole
        a.lisaKüsimus(new ArvuliseVastusegaKüsimus("Millise temperatuuri juures su veri tavaliselt jäätub?", null, -1.0));
        a.lisaKüsimus(new ArvuliseVastusegaKüsimus("Kui palju raha sul on (€)?"));
        a.lisaKüsimus(new ValikvastusegaKüsimus("Kumb sulle rohkem meeldib, kas kukk või kana?",
                Arrays.asList("kukk", "kana")));

        String raport = a.esitaKüsimusedJaTagastaRaport();

        System.out.println();
        System.out.println("---------------");
        System.out.println("TULEMUS");
        System.out.println();
        System.out.println(raport);
    }
}