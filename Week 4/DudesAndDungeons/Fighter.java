/**
 * Fighter
 */
public class Fighter extends Dude {

    public Fighter(String inName) {
        // Accuracy | armor | health | actionpoints
        super(5, 14, 65, 8);
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
        Effect attack = new WeaponAttack(this.target, this.accuracy);
        System.out.println("[s]HIA");
    }
}
