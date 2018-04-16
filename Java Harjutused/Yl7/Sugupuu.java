/**
 * Sugupuu
 */
public class Sugupuu {

    public Sugupuu(String fn) {
        
    }
    // Overloaded with filename encoding
    public Sugupuu(String fn, String encoding) {
        
    }

    // Get file contents 
    private List<String> getFileRows() {
        // Read file contents and return them as String-rows 
    }

    // Create person from a row and connect them to their children 
    // and parents via the string-rows
    /**
     * @param row - row to turn into a person
     * @param personDB - persons data base to use in creating a person/
     *                   adding parents and children
     */
    private Isik createPerson(String row, List<String> personDB) {
        // Create a person -> Isik

        // Add children ___ Should it be done recursively?
    }
}