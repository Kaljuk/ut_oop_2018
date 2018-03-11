import java.util.*;
/*
 Tal on muuhulgas järgnevad fieldid: accuracy, armor, health ja actionPoints.
 Lisaks on tal meetod void takeTurn(Dude attackTarget) ja boolean isAlive().
*/
public abstract class Dude {
    protected int accuracy;
    protected int armor;
    protected int health;
    protected int actionPoints;
    // Name
    protected String name;
    // Who to fight
    protected Dude target;
    // Character type
    public String dudeType;
    // Effects applied
    protected List<Effect> appliedEffects = new ArrayList<Effect>();

    public Dude(int inAccuracy, int inArmor, int inHealth, int inActionPoints) {
        this.accuracy     = inAccuracy;
        this.armor        = inArmor;
        this.health       = inHealth;
        this.actionPoints = inActionPoints;
    }

    // [START GetDam]GTTING DAMAGED AND ATTACKED
    public void addEffect(Effect inEffect) {
        this.appliedEffects.add(inEffect);
    }
    public void getDamaged(int inDamage) {
        this.health += Math.min(0, this.armor - inDamage);
    }
    // [END GetDam]

    public void cycleEffects (boolean beforeT) {
        // Check Effects
        for(int i=0; i< this.appliedEffects.size(); i++) {
            Effect e = this.appliedEffects.get(i);
            if (e.isExpired()) {
                this.appliedEffects.remove(i);
            } else {
                if (beforeT) {
                    e.beforeTurn(this);
                } else {
                    e.afterTurn(this);
                }
            }
        }
    }
    public void beforeTurn () {
        cycleEffects(true);
        String beginTurn = String.format("[%s] Begins turn", this.name);
        System.out.println(beginTurn);
    }
    public void takeTurn(Dude attackTarget) {
        //

    }
    public void afterTurn () {
        cycleEffects(false);
    }

    public boolean isAlive() {
        return (this.health <= 0)?false:true;
    }

    // Set name
    public void setName(String inName) {
        this.name = inName;
    }
    public void setType (String inType) {
        this.dudeType = inType;
    }

    // Set the enemy
    public void setTarget(Dude inTarget) {
        this.target = inTarget;
    }

    // Getters
    public int getArmor() {
        return this.armor;
    }
    public String getName() {
        return this.name;
    }
    public String getType() {
        return this.dudeType;
    }
    public int getHealth() {
        return this.health;
    }
}
