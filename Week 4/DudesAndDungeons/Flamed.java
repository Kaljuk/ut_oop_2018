/*
     vähendab pihta minemise hetkel vastase actionPoints 0 peale
*/
public class Flamed implements Effect {
    public static int used = 0;

    private int damage = 2;
    private int duration;

    public Flamed(int inDuration) {
        used++;

        duration = inDuration;
    }

    @Override
    public void onHit(Dude effectTarget, int doDamage) {
        // Do nothing
    }
    @Override
    public boolean willHit(Dude effectTarget, int accuracy) {
        // Do nothing
        return true;
    }
    @Override
    public void beforeTurn(Dude effectTarget) {
        // Burn
        effectTarget.getTrueDamage(damage);
        System.out.println(
        String.format("[%s] Got burned -%d", effectTarget.getName(), damage)
        );
        duration--;
    }
    @Override
    public void afterTurn(Dude effectTarget) {
        // Do nothing
    }

    //@Override
    public static int requiredActionPoints() {
        // Do nothing
        return 0;
    }
    @Override
    public boolean isExpired() {
        return (duration >0)?false:true;
    }
    @Override
    public String getName() {
        return "Flamed";
    }

    public static void stats() {
        System.out.println("Total times got on fire:"+used);
    }
}
