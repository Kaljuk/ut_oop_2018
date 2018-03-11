import java.util.*;
/**
 * Fighter
 */
public class Fighter extends Dude {
    protected int actionPointsPerTurn = 5;

    public Fighter(String inName) {
        // Accuracy | armor | health | actionpoints
        super(5, 14, 65, 28);
        setName(inName);
        setType("Fighter");
        callOut();
    }


    public void callOut() {
        System.out.println(String.format("A new fighter, %s was created",this.name));
    }

    @Override
    public void setName(String inName) {
        this.name = String.format("Sir %s", inName);
    }
    @Override
    public void takeTurn(Dude attackTarget) {

        Effect attack = null;

        int attackType = (int) new Random().nextInt() * 10;
        if (attackType > 6 && this.actionPoints >= WeaponAttack.requiredActionPoints()) {
            this.actionPoints -= WeaponAttack.requiredActionPoints();
            attack = new WeaponAttack(this.target, this.accuracy);
        } else if (this.actionPoints >= Knockdown.requiredActionPoints()) {
            this.actionPoints -= Knockdown.requiredActionPoints();
            attack = new Knockdown(this.target, this.accuracy);
        }

        String takeTurnMessage;
        if (attack != null) {
            takeTurnMessage = String.format("[%s] <%s> -> %s", this.name, attack.getName(),this.target.getType());
        } else {
            takeTurnMessage = String.format("[%s] Angry look -> %s", this.name, this.target.getType());
        }
        System.out.println(takeTurnMessage);
    }
}
