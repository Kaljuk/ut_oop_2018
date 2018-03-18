/**
 * NimedeLyhendamine
 * 
 * Course of actions
 * Used | useful links
 * https://stackoverflow.com/questions/10730413/filenotfoundexception-when-using-bufferedreader-on-a-file
 * https://stackoverflow.com/questions/22749096/efficient-way-to-read-a-file-java?rq=1
 * https://stackoverflow.com/questions/3478222/java-how-to-do-pythons-try-except-else
 * https://stackoverflow.com/questions/23375515/im-getting-an-error-exception-filenotfoundexception-is-never-thrown-in-body-o
 * 
 * Parandused
 * - Ei kasuta FileReaderit
 * 
 */

import java.util.*; // For the List
import java.io.*;   // For reading the file
import java.lang.*; // For the regex split

public class NimedeLyhendamine_parandus {
    public static void main(String[] args) throws Exception {
        // Get names from nimed.txt file

        // System.out.println(args[0]);

        ArrayList<String> nimed = readPersons(
            (args.length>0)?
            args[0]:
            "nimed.txt"
        );
        // Process and print out the names
        printPersons(nimed);
        //readPersons("sellistFailiPole.txt");
        
    }
    
    // Get names from TXT file (nimed.txt)
    public static ArrayList<String> readPersons (String fn) throws Exception {
        // Save names here
        ArrayList<String> names = new ArrayList<String>();
        File fileToRead = new File(fn);
        InputStream inputStream;

        if (!fileToRead.exists()) {
            System.out.println("File not found");
            return null;
        }

        inputStream = new FileInputStream(fileToRead);
        
        
        
        //InputStream inputStream = new FileInputStream(fn);
        BufferedReader failiSisu;
        // Ei kasuta fileReaderit ning saab kodeeringut valida
        failiSisu = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        
        // Get file contents
        String failiRida;
        while((failiRida= failiSisu.readLine()) != null) {
            names.add(failiRida);
        }
        // Close the buffer
        failiSisu.close();
        // When file

        // Return list of fullnames
        return names;
    }

    // Get namesList as input and AFTER processing print out the names
    public static void printPersons(ArrayList<String> nimed) throws Exception { 
        if (nimed == null) {
            System.out.println("List empty, nothing to print out");
            return;
        }
        // Regex for filtering files
        String splitBySpace = "\\s+";
        // Print all names
        for(String nimi : nimed) {
            // Process fullname to fitting pieces
            String[] nameParts = nimi.split(splitBySpace);
            String newFullname = nameParts[nameParts.length-1];
            // Get initials and accepted symbols
            for(int i=0;i<nameParts.length-1;i++) {
                String[] fullNamePart = nameParts[i].split("");
                String addToName = "";
                // Accept ONLY Capital Letters and the symbol "-"
                for(String letter : fullNamePart) {
                    if (letter.matches("[A-Z]|-") == true) {
                        addToName += letter;
                    }
                }
                // Add processed name to be printed out
                newFullname += " " + addToName + ".";
            }
            // Print out a name
            System.out.println(newFullname);
        }
    }
}