import java.sql.Array;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Yatzy
 */
public class Yatzy {
    
    int[] arvud = new int[5]; 

    private static int numbriteArv(int[] numbrid, int number) {
        int kokku = 0;
        for(int i : numbrid) {
            kokku += (i == number)?1:0;
        }
        return kokku;
    }
    public static int yhed (int[] numbrid) {
        return numbriteArv(numbrid, 1) * 1;
    } 
    public static int kahed (int[] numbrid) {
        return numbriteArv(numbrid, 2) * 2;
    }
    public static int kolmed (int[] numbrid) {
        return numbriteArv(numbrid, 3) * 3;
    }
    public static int neljad (int[] numbrid) {
        return numbriteArv(numbrid, 4) * 4;
    }
    public static int viied (int[] numbrid) {
        return numbriteArv(numbrid, 5) * 5;
    }
    public static int kuued (int[] numbrid) {
        return numbriteArv(numbrid, 6) * 6;
    }

    // Leia kõrgeima väärtusega täringu silmade kogum
    private static int[] leiaKogumid(int[] numbrid) {
        int[] kogumid = new int[6];
        kogumid[0] = numbriteArv(numbrid, 1);
        kogumid[1] = numbriteArv(numbrid, 2);
        kogumid[2] = numbriteArv(numbrid, 3);
        kogumid[3] = numbriteArv(numbrid, 4);
        kogumid[4] = numbriteArv(numbrid, 5);
        kogumid[5] = numbriteArv(numbrid, 6);
        
        return kogumid;
    }
        
    public static int yksPaar (int[] numbrid) {
        int paar = 0;
        int[] kogumid = leiaKogumid(numbrid);
        for (int i=0; i<kogumid.length; i++) {
            paar = (kogumid[i] >= 2 && i+1 > paar)?i+1:paar;
        }
        return paar*2;
    }
    public static int kaksPaari (int[] numbrid) {
        int paar1 = 0;
        int paar2 = 0;
        int[] kogumid = leiaKogumid(numbrid); 
        for (int i=0;  i<kogumid.length; i++) {
            paar1 = (kogumid[i] >= 2 && i+1 > paar1)?i+1:paar1;
            paar2 = (kogumid[i] >= 2 && i+1 > paar2 && i+1 !=paar1)?i+1:paar2;
        }
        return (paar1*2)+(paar2*2);
    }
    public static int kolmik (int[] numbrid) {
        int paar = 0;
        int[] kogumid = leiaKogumid(numbrid);
        for (int i=0; i<kogumid.length; i++) {
            paar = (kogumid[i] >= 3 && i > paar)?i+1:paar;
        }
        return paar * 3;
    }
    public static int nelik (int[] numbrid) {
        int paar = 0;
        int[] kogumid = leiaKogumid(numbrid);
        for (int i=0; i<kogumid.length; i++) {
            paar = (kogumid[i] >= 4 && i > paar)?i+1:paar;
        }
        return paar * 4;
    }
    public static int vaikeRida (int[] numbrid) {
        int summa = (Arrays.equals(numbrid, new int[]{1,2,3,4,5}))?
        IntStream.of(numbrid).sum():
        0;
        return summa;
    }
    public static int suurRida (int[] numbrid) {
        int summa = (Arrays.equals(numbrid, new int[]{2,3,4,5,6}))?
        IntStream.of(numbrid).sum():
        0;
        return summa;
    }
    public static int maja (int[] numbrid) {
        int paar = 0;
        int kolmik = 0;
        int[] kogumid = leiaKogumid(numbrid);
        for (int i=0; i<kogumid.length; i++) {
            kolmik = (kogumid[i] >= 3)?i+1:kolmik;
            paar = (kogumid[i] >= 2 && i+1 != kolmik ) ?i+1 : paar;
        }
        return paar*2 + kolmik*3;
    }
    public static int summa (int[] numbrid) {
        return IntStream.of(numbrid).sum();
    }
    public static int yatzy (int[] numbrid) {
        int sameCount = 0;
        int currentSame = numbrid[0];
        for(int i : numbrid) {
            sameCount += (i == currentSame)?1:-1;
            currentSame = i;
        }
        // Yatzy: All five dice with the same number. Score: 50 points.
        return (sameCount == 5)?50:0;
    }



    public static void main(String[] args) {
        int a = Yatzy.kahed(new int[] {2,1,2,2,1}); //peab tagastama 6
        System.out.println(a);
        a = Yatzy.kolmed(new int[] {2,1,2,2,1}); //peab tagastama 0
        System.out.println(a);
        a = Yatzy.yksPaar(new int[] {2,1,2,2,1}); //peab tagastama 4
        System.out.println(a);
        a = Yatzy.maja(new int[] {2,1,2,2,1}); //peab tagastama 8
        System.out.println(a);
        
        a = Yatzy.vaikeRida(new int[] {2,1,2,2,1}); //peab tagastama 8
        System.out.println(a);
        a = Yatzy.vaikeRida(new int[] {1,2,3,4,5}); 
        //peab tagastama 8
        System.out.println(a);

        a = Yatzy.suurRida(new int[] {1,2,3,4,5}); //peab tagastama 8
        System.out.println(a);
        a = Yatzy.suurRida(new int[] {2,3,4,5,6}); //peab tagastama 8
        System.out.println(a);

        a = Yatzy.yatzy(new int[] {1,2,3,4,5}); //peab tagastama 8
        System.out.println(a);
        a = Yatzy.yatzy(new int[] {3,3,3,3,3}); //peab tagastama 8
        System.out.println(a);
    }
}