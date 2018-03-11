/*
Spiderweb - vähendab vastase <AP?> iga käigu alguses vähendatab tema actionPoints.
            efekt lõpeb, kui vastast on kahe tema käigu jooksul mõjutatud.
*/
public class Spiderweb implements Effect {
    public static int used = 0;

    private int damage = 14;
    private int duration = 2;

    public Spiderweb(Dude effectTarget, int accuracy) {
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
        effectTarget.getDamaged(damage);
        duration--;
    }

    //@Override
    // Cost is 10 AP
    public static int requiredActionPoints() {
        return 12;
    }
    @Override
    public boolean isExpired() {
        return (duration >0)?false:true;
    }
    @Override
    public String getName() {
        return "Spiderweb";
    }

    public static void stats() {
        System.out.println("Total times webbed:"+used);
    }
}
