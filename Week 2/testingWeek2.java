/**
 * testingWeek2
 * 
 * Test week 2 homework solutions
 */
public class testingWeek2 {
    public static void main(String[] args) {
        Person A = new Person(1, "A", "E");
        Person B = new Person(3, "B", "3");
        Person C = new Person(2, "C", "2");
        Person D = new Person(3, "D", "3");
        Person E = new Person(4, "E", "4");
        
        // Create the list
        SortedUniquePersonList k = new SortedUniquePersonList();
        
        System.out.println("Adding 4 people in 7 tries");
        System.out.println(
            k.add(A) + " "+
            k.add(B) + " "+
            k.add(C) + " "+
            k.add(D) + " "+
            k.add(D) + " "+
            k.add(D) + " "+
            k.add(E)
        );
        // System.out.println("Print All people:");
        // k.printAllPeople();
        System.out.println("Remove one person on index:"+3);
        int index = k.indexOf(3);
        k.removeElement(3);
        int index2 = k.indexOf(3);
        System.out.println("Removed ID=3 indexOf(3): " + index2);
        // k.printAllPeople();
        System.out.println("ID:3 index new element " + k.getElementAt(index).getIdCode());

        System.out.println("People Length:"+k.size());
        
        for(int i=0; i<k.size(); i++){
            Person inimene = k.getElementAt(i);
            System.out.println("Element at "+ i);
            if (inimene != null) {
                System.out.println("-Name:"+ inimene.getFirstName());
                System.out.println("-ID:"+inimene.getIdCode());
            } else {
                System.out.println("Got null object");
            };
        }

    }   
}