/**
 * 
 * Base taken from https://gist.github.com/anonymous/883e2ac30ef9478e34d4
 *  
 * 
 * @author Erik Klaljumäe
*/
// import utils;

public class Person {
    private final int idCode;
    private final String firstName;
    private final String lastName;

    //constructor goes here
    public Person (int a_idCode, String a_firstName, String a_lastName) {
        idCode    = a_idCode;
        firstName = a_firstName;
        lastName  = a_lastName;
    }
    //getters go here
    // Get idCode
    public int getIdCode() {
        return idCode;
    }
    // // Get Names // //
    // FirstName
    public String getFirstName() {
        return firstName;
    };
    // LastName
    public String getLastName() {
        return lastName;
    };
    // FullName
    public String getFullName() {
        return firstName+" "+lastName;
    }
    //no setters!
}
