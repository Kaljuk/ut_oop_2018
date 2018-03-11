import java.util.*;

public class Wizard extends Dude {
    protected int actionPointsPerTurn = 4;

    public Wizard (String inName) {
        // Accuracy | armor | health | actionpoints
        super(15, 2, 30, 22);
        setName(inName);
        setType("Wizard");
        callOut();
    }

    private void callOut() {
        System.out.println(
            String.format("A Wizard named %s was created", this.name)
        );
    }

    @Override
    public void takeTurn(Dude attackTarget) {

        Effect attack = null;
        while (attack == null) {
            int attackType = (int) new Random().nextInt() * 10;
            if (attackType == 9) {

            } else if (attackType > 7) {
                attack = new Firebolt(attackTarget, this.accuracy);
            } else if (attackType < 2 && false) {
                attack = new WeaponAttack(attackTarget, this.accuracy);
            } else {
                attack = new Spiderweb(attackTarget, this.accuracy);
            }

        }

        String takeTurnMessage = String.format("[%s] <%s> -> %s", this.name, attack.getName(),this.target.getType());
        System.out.println(takeTurnMessage);
    }
}
