public class Test {
    public static void main(String[] args) {
        Vaateratas vaade = new Vaateratas();
        Lobustuspark park = new Lobustuspark(vaade);
        Kylastaja inimene = new Kylastaja();

        park.alustaSeiklust(inimene);
    }
}