import java.util.List;

/**
 * LobustusPark
 */
public class LobustusPark {
    private Vaateratas lobustus;
    
    public LobustusPark(Vaateratas inLobustus) {
        this.lobustus = inLobustus;
    }

    public void alustaSeiklust(Kylastaja isik) {
        System.out.println("Alustan seiklust");

        lobustus.lobusta(isik);

        List<String> kirjeldused = isik.koikKirjeldused();

        for(String kirjeldus : kirjeldused) {
            System.out.println(kirjeldus);
        }
    }
}