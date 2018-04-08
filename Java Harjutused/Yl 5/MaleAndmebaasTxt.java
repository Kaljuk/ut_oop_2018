import java.io.*;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaleAndmebaasTxt {
    private File andmeteKaust;

    public static void main(String[] args) throws Exception {
        // seda meetodit automaattest ei puutu, seega siin võid teha ükskõik
        // milliseid muudatusi

        MaleAndmebaasTxt db = new MaleAndmebaasTxt(new File("data"));
        db.printTurniir();

        System.out.println("Osalejad");
        List<String> osalejad = db.turniiriOsalejad("Turniir1Nimetus");
        for(String s : osalejad) {
            System.out.println("O: " + s);
        }
    }

    public MaleAndmebaasTxt(File kaust) throws Exception {
        // Konstruktorile antakse teada, millisest kaustast tuleb otsida
        // faile isikud.txt, klubid.txt, partiid.txt ja turniirid.txt
        
        // Jäta siin kaust isendimuutujasse meelde!
        this.andmeteKaust = kaust;
    }

    public List<String> turniiriOsalejad(String turniiriNimi) throws Exception {
        // Meetod peab tagastama listi näidatud turniiril osalejate nimedega
        // (eesnimi ja perekonnanimi tühikuga kokku ühendatuna ning kasvavalt järjestatuna).

        // Kui sellise nimega turniiri andmebaasis pole, siis tuleb tagastada tühi list.
        List<String> osalejad = new ArrayList<String>();
        // Get Turniiri ID
        String turniir = getTurniir(turniiriNimi);
        // Get Turniiri Partiid
        List<String> partiid = getPartiid(turniir.split("\t")[0]);
        // Get osalejate IDd
        List<String> partiiOsalejad = new ArrayList<String>();
        
        List<String> pOsalejad = new ArrayList<String>();
        for (String p : partiid) {
            //System.out.println("Partii"+p);
            pOsalejad = getPartiiOsalejad(p);
            for (String s : pOsalejad) {
                //System.out.println("Osaleja"+s);
                if (!partiiOsalejad.contains(s)) {
                    partiiOsalejad.add(s);
                }
            }
        }
        // Get and add osalejad <eesnimi perenimi>
        // Return osalejad
        //return osalejad;
        return partiiOsalejad;
    }

    public void printTurniir() throws Exception {
        String turniir = getTurniir("Turniir1Nimetus");
        for(String s : turniir.split("\t")) {
            //System.out.println("Turniiri osa "+s);
        }

        // Debug
        //System.out.println("Turniirid prinditud\nPartiid next:\n");


        List<String> partiid = getPartiid(turniir.split("\t")[0]);
        for(String p : partiid) {
            //System.out.println("Partii: "+p);
        }
        //System.out.println(turniir.split("\t")[0]+"DONE");
    }

    private List<String> getPartiiOsalejad(String partii) throws Exception {
        String[] osalejateID = {partii.split("\t")[3], partii.split("\t")[4]};
        List<String> isikud = getIsikud();
        List<String> partiiOsalejad = new ArrayList<String>();

        String[] isik;
        for(String i : isikud) {
            isik = i.split("\t");
            //System.out.printf("%s -- %s %s_%s\n", i, isik[0], osalejateID[0], osalejateID[1]);
            if (isik[0].equals(osalejateID[0]) || isik[0].equals(osalejateID[1])) {
                // System.out.println("FITS");
                partiiOsalejad.add(isik[1]+" "+isik[2]);
            }
        }
        return partiiOsalejad;
    }

    private List<String> getIsikud() throws Exception {
        // 
        File isikudFile = new File(this.andmeteKaust.toString()+"/isikud.txt");
        List<String> isikud = getDataFromFile(isikudFile);
        return isikud;
    }

    private List<String> getPartiid(String turniiriID) throws Exception{
        File partiiFail = new File(this.andmeteKaust.toString()+"/partiid.txt");
        List<String> partiid = getDataFromFile(partiiFail);
        List<String> filtreeritudPartiid = new ArrayList<String>();
        
        for( String s : partiid ) {
            if (s.split("\t")[0].equals(turniiriID)) {
                filtreeritudPartiid.add(s);
            }
            //System.out.println("Oneof many"+s);
        }
        
        return filtreeritudPartiid;
    }

    private String getTurniir(String turniiriNimi) throws Exception {
        
        File turniiriFail = new File(this.andmeteKaust.toString()+"/turniirid.txt");
        List<String> turniirid = getDataFromFile(turniiriFail);
        //List<String> filtreeritudTurniirid = new ArrayList<String>();

        for( String s : turniirid ) {
            if (s.contains(turniiriNimi)) {
                //filtreeritudTurniirid.add(s);
                //return Arrays.asList(s.split("\t"));
                return s;
            }
        }
        return "";
        //return filtreeritudTurniirid;
    }

    private List<String> getDataFromFile(File failiNimi) throws Exception {
        List<String> andmeRead = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(
            new FileInputStream(failiNimi.getPath()), "UTF-8"
        ));
        
        String rida;
        while( (rida = br.readLine()) != null) {
            andmeRead.add(rida);
        }
        br.close();
        return andmeRead;
    }

    public double isikuPunktisummaTurniiril(String eesnimi, String perenimi,
                                            String turniiriNimi) throws SQLException {

        // Tagasta näidatud isiku punktisumma näidatud turniiril.
        // Punktisumma on tema partiide tulemuste summa jagatuna kahega.
        // Ära unusta, et isik võis mängida nii valgete kui mustadega!

        // Kui sellise nimega turniiril polnud sellise nimega osalejat,
        // (või kui sellise nimega turniiri ei leidu)
        // siis peab meetod tagastama 0.
        return 1.0;
    }
}