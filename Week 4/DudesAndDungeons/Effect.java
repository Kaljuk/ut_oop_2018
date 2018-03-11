import java.lang.*;
/**
 * Effect
 Pihta/mööda minemise tuvastamiseks kasutatakse valemit
 "d20 + ründaja täpsus >= vastase kaitse",
 kus d20 on juhuslik arv [1..20].
 */
public interface Effect {

    public void onHit(Dude effectTarget, int doDamage);

    public void beforeTurn(Dude effectTarget);
    public void afterTurn(Dude effectTarget);

    public int requiredActionPoints();
    public boolean isExpired();

    public boolean willHit(Dude effectTarget, int accuracy);
}
