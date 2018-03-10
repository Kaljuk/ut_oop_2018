
/*
 Tal on muuhulgas järgnevad fieldid: accuracy, armor, health ja actionPoints. 
 Lisaks on tal meetod void takeTurn(Dude attackTarget) ja boolean isAlive().
*/
public abstract class Dude {
    private int accuracy;
    private int armor;
    private int health;
    private int actionPoints;

    public Dude() {

    }

    public void takeTurn(Dude attackTarget) {

        
    }

    private boolean isAlive() {

        return true;
    }

}