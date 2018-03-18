/**
 * Test
 */
public class Test {

    public static void main(String[] args) {
        Vaateratas ratas = new Vaateratas();
        LobustusPark park= new LobustusPark(ratas);
        Kylastaja klient = new Kylastaja();
        ratas.lobusta(klient);
        park.alustaSeiklust(klient);
    }
}