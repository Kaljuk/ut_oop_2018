/*
     vähendab pihta minemise hetkel vastase actionPoints 0 peale
*/
public class Knockdown implements Effect {
    private int damage = 6;
    public static int used = 0;

    public Knockdown(Dude effectTarget, int accuracy) {
        used++;

        if (willHit(effectTarget, accuracy)) {
            onHit(effectTarget, damage);
        }
    }

    @Override
    public void onHit(Dude effectTarget, int doDamage) {
        effectTarget.setActionPoints(0);
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

    //@Override
    // Cost is 10 AP
    public static int requiredActionPoints() {
        return 10;
    }
    @Override
    public boolean isExpired() {
        return true;
    }
    @Override
    public String getName() {
        return "Knockdown";
    }

    public static void stats() {
        System.out.println("Total times Knocked down:"+used);
    }
}
