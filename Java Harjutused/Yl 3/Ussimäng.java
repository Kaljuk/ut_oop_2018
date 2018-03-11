
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
        String[] rows = m.split("\n");
        for (int i=0;i< rows.length;i++) {
            String[] rida = rows[i].split("");
            for (int j=0; j< rida.length; j++) {
                
            }
        }
    }

    public void registreeriSündmus (String s) {
        // If command is acceptable
        if (Arrays.asList(allCommands).contains(s)) {
            // 
            System.out.println("Sobib");
            
            this.suund = (s != "oota")? s : suund;

            switch(s) {
                case "vasakule":
                case "paremale":

                break;
                case "üles":
                case "alla":

                break;
                default:
                break;
            }

        }
    }

    public String annaSeis() {
        return this.mänguväli.toString();
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

    private String[][] field;

    public GameField(String f) {
        setFieldSize(f);
    }  

    
    public String toString() {
        return getField();
    }
    
    private String getField() {
        String f = "";
        System.out.println("Field: "+f);
        return f;
    }

    private void setFieldSize(String inField) {
        String[] rows = inField.split("\n");
        
        

    } 
}