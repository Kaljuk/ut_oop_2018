/**
 * 
 * Base taken from https://gist.github.com/anonymous/883e2ac30ef9478e34d4
 * 
 * Collection for holding Person objects.<br>
 * Provides the following guarantees:<br>
 * 1) Elements are guaranteed to be in ascending order, sorted by their ID code value.<br>
 * 2) Elements are guaranteed to have unique ID code values.<br>
 *
 * Uses an underlying array for storing the elements. <br>
 * The object guarantees to not use more than twice the required array size.<br>
 * For example, if currently 10 persons are stored, then the underlying array size might range from 10 to 20, but will not be larger.
 * 
 * 
 */
public class SortedUniquePersonList {
    private Person[] people = {};
    /*public static void main(String[] args) {
        System.out.println("Initiated");
    }*/

    /**
     * Returns reference to object at the given index. Checks that the given index is in bounds of the underlying array, returns null if it isn't.
     * @param index Index at which the object is searched.
     * @return Person object at the given index, or null if the index is out of bounds.
     */
    public Person getElementAt(int index) {
        // System.out.println("getElementAt(): index "+index+"/"+people.length);
        return (people == null || people.length < index)? 
                null:
                people[index] ; 
    }

    /**
     * Returns the index of the object with the given ID code. If an object with the given ID code is not present, returns -1.
     * @param idCode ID code that is searched.
     * @return Index at which the Person object with the given ID code can be found, or -1 if no such ID code is present.
     */
    public int indexOf(int idCode) {
        // System.out.println("indexOf(): idCode="+idCode+" people.length="+people.length);
        if (people.length != 0) {
            for(int i=0;i<people.length;i++) {
                if (people[i] != null && people[i].getIdCode() == idCode) {
                    return i;
                } 
                if (people[i] == null) {
                    System.out.println("indexOf(): Array element "+i+" is null");
                }
            }
        }
        // System.out.println("indexOf(): idCode "+idCode+" Not in array");
        return -1;
    }

    /**
     * Attempts to add the person to the collection, but only if no person with the same ID code is already present.<br>
     * If an element is added, it is inserted to the correct position according to their ID code. Also, the index of all subsequent elements is then increased.<br>
     * If a Person object with the same ID code is already present, does nothing.
     * @param person Person object to be added.
     * @return true if person was added to the collection, false otherwise.
     */
    public boolean add(Person person) {
        System.out.println("add(): idCode "+person.getIdCode()+" isInArray? "+ (indexOf(person.getIdCode())!=-1) );
        if (person != null && indexOf(person.getIdCode()) == -1) {
            System.out.println("add(): Adding idCode "+person.getIdCode());
            // When list is empty
            if (people.length == 0) {
                // System.out.println("add(): First in list");
                people = new Person[]{person};
                // System.out.println("add() -> getIdCode():"+person.getIdCode());
                return true;
            };
            // When list is NOT empty
            // System.out.println("add(): Not first in list");
            int newPersonId = person.getIdCode();
            Person[] newPersonArray = new Person[people.length+1];
            
            int newArrCount = 0;
            boolean newPersonAdded = false;
            for(int i=0; i<people.length; i++) {
                Person i_person = people[i];
                // Add before the next variable 
                //System.out.println("add() - Comparison:"+i_person.getIdCode() + " > " + newPersonId);
                if (newPersonAdded == false) {
                    // Add if next.id > new.id
                    if (i_person.getIdCode() > newPersonId) {
                        newPersonArray[newArrCount++] = person;
                        newPersonAdded = true;
                    }
                    newPersonArray[newArrCount++] = i_person;
                    // Add if newPerson is the last in list
                    if (i == people.length-1 && newPersonAdded == false) {
                        newPersonArray[newArrCount++] = person;
                        newPersonAdded = true;
                    }
                } else {
                    newPersonArray[newArrCount++] = i_person;
                };
            }
            people = newPersonArray;
            System.out.println("add(): Now " +people.length+ ((people.length>1)?" people":" person")+" in array");
            return true;

        } 
        return false;
    }

    /**
     * Attempts to remove the person with the given ID code from the collection. Does nothing if no Person object with the given ID code is present.<br>
     * In the case of a successful removal of an object, decreases the index of all subsequent elements.
     * @param idCode ID code that is searched.
     * @return true if the person with the given ID code was removed, false otherwise.
     */
    public boolean removeElement(int idCode) {
        System.out.println("removeElement(): indexOf("+idCode+") = "+ indexOf(idCode));
        if (people.length > 0 && indexOf(idCode) != -1) {
            System.out.println("removeElement(): people.length="+people.length);
            Person[] newPeopleArray = new Person[people.length-1];
            int newArrCount = 0;
            for(int i=0; i < people.length; i++) {
                Person i_person = people[i];
                if (i_person.getIdCode() != idCode) {
                    newPeopleArray[newArrCount++] = i_person;
                }
            }
            people = newPeopleArray;
            return true;
        }
        return false;
    }

    /**
     * Calculates and returns the size of the collection.
     * @return Number of elements in the collection.
     */
    public int size() {
        return people.length;
    }

    // For testing purposes
    /*public void printAllPeople() {
        if (people.length != 0) {
            System.out.println("Printing all people"+ people.length);
            for (Person i : people) {
                if (i != null) {
                    System.out.println("Person name:"+i.getIdCode()+";Person ID"+i.getIdCode());
                } else {
                    System.out.println("Null Person");
                }
            }
        }
    }*/
}