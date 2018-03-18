import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        Vaateratas ratas    = new Vaateratas();
        TasulineLobustus tasulineRatas = new TasulineLobustus(2.25, ratas);

        Lasketiir lasketiir = new Lasketiir();
        /*
        Kirjeldage kommentaaris, mis juhtuks, kui hoopis TasulineLõbustus delegeeriks 
        vanusekontrolliga lasketiirule (objektid on üksteise sees teises järjekorras). 
        Kuidas koodi käitumine muutuks?

        Siis käitub kood nagu skeemitav lõbustuspark: 
        Maksad, et lasta, kuid kui avastatakse, et külastaja pole piisavalt vana,
        siis ei anta püssi kätte ehk ei saa lõbustada, kuid raha on juba ära antud,
        mis tähendab, et samahästi oleks võinud selle raha eest hoopis jäätist osta.
        */
        TasulineLobustus tasulineLasketiir = new TasulineLobustus(1.5, lasketiir);
        VanuseKontrollija vkLasketiir = new VanuseKontrollija(10, tasulineLasketiir);

        Kloun ivan = new Kloun("IVAN");

        LobustusPark park= new LobustusPark(
            Arrays.asList(
                tasulineRatas,//ratas, 
                vkLasketiir,//lasketiir, 
                new LobustavKloun(ivan)
            )
        );

        Kylastaja klient9 = new Kylastaja(9);
        Kylastaja klient11= new Kylastaja(11);

        park.alustaSeiklust(klient9);
        park.alustaSeiklust(klient11);
    }
}