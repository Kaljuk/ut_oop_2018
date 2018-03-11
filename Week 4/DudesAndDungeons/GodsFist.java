public class GodsFist implements Effect {
    public static int used = 0;

    private int damage = 999999999;

    public GodsFist(Dude effectTarget, int accuracy) {
        used++;

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

    //@Override
    // Cost is 5 AP
    public static int requiredActionPoints() {
        return 5;
    }
    @Override
    public boolean isExpired() {
        return true;
    }
    @Override
    public String getName() {
        return "GodsFist";
    }


    public static void stats() {
        System.out.println("Total times somebody got fisted:"+used);
    }

}
