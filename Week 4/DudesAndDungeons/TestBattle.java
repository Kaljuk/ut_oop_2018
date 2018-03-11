
/**
 * TestBattle
 */
public class TestBattle {

    public static void main(String[] args) {
        // Test battle
        Wizard dumbelDoor = new Wizard("DumbelDoor");
        Fighter kohalik   = new Fighter("Gopnik");
        System.out.println();
        Duel firstDuel = new Duel(dumbelDoor, kohalik);
        while(firstDuel.isDuelOver() == false) {
            firstDuel.oneTurnCycle();
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("\t\t[Statistics]");

        WeaponAttack.stats();
        Knockdown.stats();
        Firebolt.stats();
        Spiderweb.stats();
        Flamed.stats();
        GodsFist.stats();

        firstDuel.isDuelOver();
    }

}
