public class Duel {
    private int turn = 1;
    private Dude[] duelists;

    public Duel(Dude duelistOne, Dude duelistTwo) {
        System.out.println(String.format(
            "%s initiates the duel with %s\n\t\t%s VS %s",
            duelistOne.getName(), duelistTwo.getName(), duelistOne.getType(), duelistTwo.getType()));
        duelists = new Dude[]{duelistOne, duelistTwo};
        inititateBattle();
    }

    public void oneTurnCycle() {
        announceTurn();
        for (int i=0; i<duelists.length; i++) {
            Dude duelist = duelists[i];
            duelist.beforeTurn();
            duelist.takeTurn(duelists[1-i]);
            duelist.afterTurn();
        }
        this.turn++;
    }

    public void inititateBattle() {
        for (int i=0; i<duelists.length; i++) {
            Dude duelist = duelists[i];
            duelist.setTarget(duelists[1-i]);
        }
        System.out.println("[Duel] Begin");
    }

    public void announceTurn() {
        String turnMessage = String.format("[Duel] Turn %d begins",
            this.turn
        );
        System.out.println(turnMessage);
    }

    public boolean isDuelOver() {
        Dude dOne = duelists[0];
        Dude dTwo = duelists[1];
        boolean dOneIsAlive = dOne.isAlive();
        boolean dTwoIsAlive = dTwo.isAlive();
        if (!dOneIsAlive && !dTwoIsAlive) {
            System.out.println(
                String.format("[Duel] Duel is over\n\t[%s] Dead\n\t[%s] Dead",
                dOne.getName(), dTwo.getName()
            ));
            return true;
        } else if (!dOneIsAlive || !dTwoIsAlive) {
            System.out.println(
                String.format("[Duel] Duel is over\n\t[%s] Killed %s",
                (dOneIsAlive)?dOne.getName():dTwo.getName(),
                (dTwoIsAlive)?dTwo.getName():dOne.getName()
            ));
            return true;
        } else {
            return false;
        }
    }

}
