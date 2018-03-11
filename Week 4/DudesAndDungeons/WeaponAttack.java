/**
 * WeaponAttack
 vähendab pihta minemise hetkel vastase health
 */
public class WeaponAttack implements Effect {
    private int damage = 6;

    public WeaponAttack(Dude effectTarget, int accuracy) {
        if (willHit(effectTarget, accuracy)) {
            onHit(effectTarget, damage);
        }
    }

    @Override
    public void onHit(Dude effectTarget, int doDamage) {
        effectTarget.getDamaged(doDamage);
        effectTarget.addEffect(this);
    }
    @Override
    public boolean willHit(Dude effectTarget, int accuracy) {
        int hitChance = (int) Math.max(20.0, Math.random()*20.0 + 1.0);
        if (accuracy + hitChance >= effectTarget.getArmor()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void beforeTurn(Dude effectTarget) {
        // Do nothing
    }
    @Override
    public void afterTurn(Dude effectTarget) {
        // Do nothing
    }

    @Override
    // Cost is 5 AP
    public int requiredActionPoints() {
        return 5;
    }
    @Override
    public boolean isExpired() {
        return true;
    }

}
