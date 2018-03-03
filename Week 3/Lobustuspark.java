public class Lobustuspark {
    private Vaateratas lobustus;

    public Lobustuspark(Vaateratas ratas) {
        lobustus = ratas;
    }
    public void alustaSeiklust(Kylastaja inimene) {
        System.out.println("alustan seiklust");
        lobustus.lobusta(inimene);
        inimene.koikKirjeldused();
    }
}

