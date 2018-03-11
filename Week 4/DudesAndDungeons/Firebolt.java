/*
     vähendab pihta minemise hetkel vastase actionPoints 0 peale
*/
import java.util.*;

public class Firebolt implements Effect {
    public static int used = 0;

    private int damage = 23;
    private boolean hasExpired = false;

    public Firebolt(Dude effectTarget, int accuracy) {
        used++;
        if (willHit(effectTarget, accuracy)) {
            onHit(effectTarget, damage);
        }
    }

    @Override
    public void onHit(Dude effectTarget, int doDamage) {
        effectTarget.getDamaged(doDamage);
        effectTarget.addEffect(this);
        // Chance to set enemy on fire
        if (new Random().nextInt()*10 > 5 || true) {
            Effect onFlame = new Flamed(3);
            effectTarget.addEffect(onFlame);
        }
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
        hasExpired = true;
    }

    // Cost is 10 AP
    //@Override
    public static int requiredActionPoints() {
        return 15;
    }
    @Override
    public boolean isExpired() {
        return hasExpired;
    }
    @Override
    public String getName() {
        return "Firebolt";
    }

    public static void stats() {
        System.out.println("Total times firebolted:"+used);
    }
}
