/**
 * NimedeLyhendamine
 * 
 * Course of actions
 * 
 */

import java.util.*; // For the List
import java.io.*;   // For reading the file
import java.lang.*; // For the regex split

public class NimedeLyhendamine {
    public static void main(String[] args) throws Exception {
        // Get names from nimed.txt file
        ArrayList<String> nimed = readPersons("nimed.txt");
        // Process and print out the names
        printPersons(nimed);
    }
    
    // Get names from TXT file (nimed.txt)
    public static ArrayList<String> readPersons (String fn) throws Exception {
        // Save names here
        ArrayList<String> names = new ArrayList<String>();

        FileReader failiLugeja = new FileReader("nimed.txt");
        BufferedReader failiSisu = new BufferedReader(failiLugeja);
        // Get file contents
        String failiRida;
        while((failiRida= failiSisu.readLine()) != null) {
            names.add(failiRida);
        }
        // Close the buffer
        failiSisu.close();
        // Return list of fullnames
        return names;
    }

    // Get namesList as input and AFTER processing print out the names
    public static void printPersons(ArrayList<String> nimed) throws Exception {        
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