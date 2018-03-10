
import java.util.*;

public class Ussimäng {
    
    private GameField mänguväli;

    private String suund = "";
    private List<Pos> uss = new ArrayList<Pos>();
    
    private String[] allCommands = {
        "üles", "alla",
        "vasakule", "paremale",
        "oota"
    };

    public Ussimäng(String m) {
        this.mänguväli = new GameField(m);
        // leia ussi pea
        String[] read = m.split("\n");
        for (int i=0;i<read.length;i++) {
            
        }
    }

    public void registreeriSündmus (String s) {
        // If command is acceptable
        if (Arrays.asList(allCommands).contains(s)) {
            // 
            System.out.println("Sobib");
        }
    }

    public String annaSeis() {
        return this.mänguväli.toString();
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

/**
 * GameField
 */
class GameField {

    private char[][] field;
    private int width;
    private int height;

    public GameField(String f) {
        setFieldSize(f);
    }  

    
    public String toString() {
        return getField();
    }
    
    private String getField() {
        String f = "";
        for(int i=0; i < this.height; i++) {
            for (int j=0; j < this.width; j++) {
                f = f + "a";
            }
            f = f + "\n";
        }
        System.out.println("Field: "+f);
        return f;
    }

    private void setFieldSize(String f) {
        String[] rows = f.split("\n");
        this.field = new char[ rows.length ][ rows[0].length() ];

        for (int i=0 ; i< rows.length ; i++) {
            for(int j=0; j< rows[i].length(); j++) {
                System.out.printf("X%d Y%d %c", i, j, rows[i].charAt(j) );

            }
        }
    }
}