public class Wizard extends Dude {

    public Wizard (String inName) {
        // Accuracy | armor | health | actionpoints
        super(15, 2, 30, 12);
        setName(inName);
        setType("Wizard");
        callOut();
    }

    private void callOut() {
        System.out.println(
            String.format("A Wizard named %s was created", this.name)
        );
    }
}
