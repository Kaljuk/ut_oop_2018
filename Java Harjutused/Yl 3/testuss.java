public class testuss {
    public static void main(String[] args) {
        Ussimäng m = new Ussimäng(
            "########\n" +
            "#      #\n" +
            "#   *  #\n" +
            "#   õ  #\n" +
            "#   õõ #\n" +
            "########\n");

        m.registreeriSündmus("alla");
        m.registreeriSündmus("paremale");
        m.registreeriSündmus("alla");
        //m.registreeriSündmus("vasakule");
        //m.registreeriSündmus("üles");
        //m.registreeriSündmus("oota");

        System.out.println(m.annaSeis());
    }
}