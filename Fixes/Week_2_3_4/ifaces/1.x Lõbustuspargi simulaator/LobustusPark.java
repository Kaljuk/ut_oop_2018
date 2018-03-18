import java.util.List;

/**
 * LobustusPark
 */
public class LobustusPark {
    private List<Lobustus> lobustused;

    public LobustusPark(List<Lobustus> inLobustused) {
        this.lobustused = inLobustused;
    }

    public void alustaSeiklust(Kylastaja isik) {
        System.out.println("Alustan seiklust");

        //lobustused.get(0)
        //    .lobusta(isik);
        for(Lobustus lobustus : lobustused) {
            lobustus.lobusta(isik);
        }

        List<String> kirjeldused = isik.koikKirjeldused();

        for(String kirjeldus : kirjeldused) {
            System.out.println(kirjeldus);
        }

        System.out.println("Kulud: "+ isik.kuludeSumma());
        // Visual HorizontalRule
        System.out.println("------------------------------");
    }
}