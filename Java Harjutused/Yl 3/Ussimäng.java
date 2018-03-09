import java.util.*;

public class Ussimäng {
    
    private String mänguväli;


    private String suund = "";
    private List<Pos> uss = new ArrayList<Pos>();

    private String[] allCommands = {
        "üles", "alla",
        "vasakule", "paremale",
        "oota"
    };

    public Ussimäng(String m) {
        this.mänguväli = m;
        // leia ussi pea
        String[] read = m.split("\n");
        for (int i=0;i<read.length;i++) {
            
        }
    }

    public void registreeriSündmus (String s) {
        // If command is acceptable
        if (Arrays.asList(allCommands).contains(s)) {
            // 

        }
    }

    public String annaSeis() {
        return this.mänguväli;
    }

    private boolean sündmuseTagajärg(String s) {

        return true;
    }

}

class Pos {
    private int x;
    private int y;
    public Pos(int nX, int nY) {
        this.x = nX;
    }
    /**
     * @param {int[]} {xKoordinaat, yKoordinaat}
     */
    public void setPos(int[] nXY) {
        this.x = nXY[0];
        this.y = nXY[1];
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}

