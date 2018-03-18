/**
 * Lasketiir
 */
public class Lasketiir implements Lobustus {

    public void lobusta(Kylastaja isik) {
        int tabatud = (int) (Math.random()*21);
        isik.lisaKirjeldus(
            String.format("tabasin lasketiirus %d sihtmärki", tabatud)
        );
    }
}