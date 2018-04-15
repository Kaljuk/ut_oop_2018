import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * PeaKlass
 */
public class PeaKlass {
    public static void main(String[] args) throws Exception {
        
        List<Teos> teosed = loeTeosed("laenutus.txt");
        // Sort list
        Collections.sort(teosed);
        
        ViiviseHoiataja hoiataja = new ViiviseHoiataja(0.2);
        SuurimaViiviseLeidja suurimaViiviseLeidja = new SuurimaViiviseLeidja();
        // Arvuta viivised
        for (Teos t : teosed) {
            t.arvutaViivis(hoiataja);
        }
        List<String> hoiatatavad = hoiataja.getHoiatatavadLaenutajad();
        System.out.println("Viivisega laenutajad:");
        for(String s: hoiatatavad) {
            System.out.println(s);
        }
        // Arvuta suurima viivise omanik
        for (Teos t : teosed) {
            t.arvutaViivis(suurimaViiviseLeidja);
        }

        suurimaViiviseLeidja.saadaHoiatus();
        
        
    }
    
    public static List<Teos> loeTeosed(String fn) throws Exception {
        List<Teos> teosed = new ArrayList<Teos>();
        // Get file contents
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(fn);
        } catch(FileNotFoundException e) {
            System.out.println("Laenutuste faili ei leitud");
            return teosed;
        }
        BufferedReader failiSisu;
        failiSisu = new BufferedReader(
            new InputStreamReader(inputStream, "UTF-8")
        );
        String failiRida;
        while((failiRida= failiSisu.readLine()) != null) {
            // kirjeldus, teose tähis, laenutaja nimi ja laenutatud päevade arv
            String[] teos = failiRida.split("; ");
            if (teos.length >= 4) {
                // Kirjeldus
                String kirjeldus = teos[0];
                String tahis     = teos[1];
                String laenutaja = teos[2];
                int days         = Integer.parseInt( teos[3] );

                if (kirjeldus.contains("/")) {
                    //System.out.println("Ajakiri");
                    int aasta = 0;
                    try {
                        aasta = Integer.parseInt( kirjeldus.split("/")[1].split(",")[0] );
                    } catch(NumberFormatException e) {
                        System.out.println("Error: ei suutnud aasta numbrit lugeda");
                        System.out.println(kirjeldus);
                    }
                    teosed.add(
                        // String teoseKirjeldus, String teoseTahis, String teoseLaenutaja, int days, int ilmumisaasta
                        // pealkiri, kaldkriips, aasta number, koma ja ajakirja number
                        new Ajakiri( kirjeldus, tahis, laenutaja, days, aasta )
                    );
                } else {
                    //System.out.println("Raamat");
                    teosed.add(
                        // String teoseKirjeldus, String teoseTahis, String teoseLaenutaja, int days
                        new Raamat( kirjeldus, tahis, laenutaja, days )
                    );
                }
            }
        }
        failiSisu.close();

        return teosed;
    }
}