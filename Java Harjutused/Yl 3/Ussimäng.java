
import java.util.*;

public class Ussimäng {
    
    private GameField mänguväli;
    private boolean isGameOver = false;

    private String suund = "";

    private String[] allCommands = {
        "üles", "alla",
        "vasakule", "paremale",
        "oota"
    };

    public Ussimäng(String m) {
        this.mänguväli = new GameField(m);

        Pos pea = new Pos(0,0);
        System.out.println("DONE");
        System.out.println(pea.toString());

        this.mänguväli.drawField();
    }

    public void registreeriSündmus (String s) {
        // If command is acceptable
        //System.out.println(s);
        if (Arrays.asList(allCommands).contains(s) && !isGameOver) {
            // 
            System.out.println(s+"Sobib");
            this.suund = (s != "oota")? s : suund;
            int newX = 0;
            int newY = 0;

            newX = (this.suund=="vasakule")?-1:(this.suund=="paremale")?1:0;
            newY = (this.suund=="üles")?-1:(this.suund=="alla")?1:0;

            this.mänguväli.moveWorm(newX, newY);
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
        setPos(new int[]{nX, nY});
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

    public String toString() {
        return String.format("X%d Y%d", this.x, this.y);
    }
}

/**
 * GameField
 */
class GameField {

    private String ussSymbol = "*";
    private String nomSymbol = "õ";

    private String[][] field;

    private List<Pos> uss = new ArrayList<Pos>();

    private boolean growWorm = false;

    public GameField(String f) {
        setFieldSize(f);
    }  

    
    public String toString() {
        StringBuilder fieldAsString = new StringBuilder();
        for(int i=0; i< this.field.length; i++) {
            for(int j=0; j<this.field[i].length; j++) {
                fieldAsString.append(field[i][j]);
            }
            fieldAsString.append("\n");
        }
        String fieldString = fieldAsString.toString();
        return fieldString;
    }

    private void setFieldSize(String inField) {
        Pos pea;

        int width = inField.split("\n")[0].split("").length;
        int height = inField.split("\n").length;
        this.field = new String[height][width];

        String[] rows = inField.split("\n");
        for (int i=0;i< rows.length;i++) {
            String[] rida = rows[i].split("");

            for (int j=0; j < rida.length; j++) {
                if (rida[j] != "\n") {
                    if (rida[j].equals(nomSymbol)) {

                        this.field[i][j] = rida[j];

                        pea = new Pos(j, i);
                        uss.add(pea);
                        
                    } else {
                        this.field[i][j] = rida[j];
                    }
                }
            }
            //System.out.println("");
        }

    }
    

    public boolean isWormDead () {
        // Check walls

        // Check worm colision with self

        return false;
    }

    public void moveWorm(int addX, int addY) {
        int x = this.uss.get(0).getX();
        int y = this.uss.get(0).getY();
        Pos uusPea = new Pos(x+addX, y+addY);
        this.uss.add(0, uusPea);
        if (!this.growWorm) {
            this.uss.remove(this.uss.size()-1);
        } else {
            this.growWorm = false;
        }
        clearWorm();
        updateWorm();

        drawField();
    }


    private void clearWorm() {
        for(int i=0; i< this.field.length; i++) {
            for(int j=0; j<this.field[i].length; j++) {
                field[i][j] = (field[i][j].equals(ussSymbol))?" ":field[i][j];
            }
        }
    }
    private void updateWorm() {
        for(Pos p : uss) {
            int x = p.getX();
            int y = p.getY();
            this.growWorm = (field[y][x] == nomSymbol)?true:this.growWorm;
            field[y][x] = ussSymbol;
        }
    }

    public void drawField() {
        for(int i=0; i< this.field.length; i++) {
            for(int j=0; j<this.field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }
}