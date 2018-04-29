import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Sugupuu
 */
public class Sugupuu {
    private List<Isik> isikud = new ArrayList<Isik>();


    public static void main(String[] args) {
        try {
            Sugupuu s = new Sugupuu("sugupuu1a.txt");
            Isik i = s.otsiIsik("17906292719");
            if (i != null) {
                System.out.println(i.getIsikukood());
            } else {
                System.out.println("NF");
            }
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    public Sugupuu(String fn) throws Exception{
        List<String> isikuteAndmed = getFileRows(fn, "UTF-8");
        for(String i: isikuteAndmed) {
            isikud.add(createPerson(i, isikuteAndmed));
        }

    }
    // Overloaded with filename encoding
    public Sugupuu(String fn, String encoding) throws Exception{
        List<String> isikuteAndmed = getFileRows(fn, encoding);
        for(String i: isikuteAndmed) {
            isikud.add(createPerson(i, isikuteAndmed));
        }
    }

    // Get file contents 
    private List<String> getFileRows(String fn, String encoding) throws Exception {
        // Read file contents and return them as String-rows 
        ArrayList<String> rows = new ArrayList<String>();
        InputStream inputStream;

        try {
            inputStream = new FileInputStream(new File(fn));
        } catch(FileNotFoundException e) {
            //System.out.println("FNF");
            return null;
        }
        
        //InputStream inputStream = new FileInputStream(fn);
        BufferedReader failiSisu;
        // Ei kasuta fileReaderit ning saab kodeeringut valida
        failiSisu = new BufferedReader(new InputStreamReader(inputStream, encoding));
        
        // Get file contents
        String failiRida;
        while((failiRida= failiSisu.readLine()) != null) {
            rows.add(failiRida);
        }
        // Close the buffer
        failiSisu.close();
        // When file

        // Return list of fullnames
        return rows;
    }

    // Create person from a row and connect them to their children 
    // and parents via the string-rows
    /**
     * @param row - row to turn into a person
     * @param personDB - persons data base to use in creating a person/
     *                   adding parents and children
     */
    private Isik createPerson(String row, List<String> personDB) {
        Isik isik = new Isik();
        // Create a person -> Isik
        String[] s = row.split(" ");
        if (s[1].equals("nimi")) {
            isik.setIsikukood(s[0]);
            isik.set
        }
        // Add children ___ Should it be done recursively?
        return isik;
    }


    public HashSet<Isik> otsiLapsed(Isik i) {
        return i.getLapsed();
    }


    public Isik otsiIsik(String isikukood) {
        for(Isik i: isikud) {
            //System.out.println(i.getIsikukood());
            if (i.getIsikukood().equals(isikukood)) {
                return i;
            }
        }
        return null;
    }

    public HashSet<String> kõikIsikukoodid() {
        HashSet<String> isikukoodid = new HashSet<String>();
        for(Isik i: isikud) {
            isikukoodid.add(i.getIsikukood());
        }
        return isikukoodid;
    }

    public HashSet<Isik> otsiJärglased(Isik i) {

        return new HashSet<Isik>();
    }
    
}