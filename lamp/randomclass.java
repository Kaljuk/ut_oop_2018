/**
 * randomclass
 */
public class randomclass {
    public static void main(String[] args) {
        test t = new test(12);
        test c = new test(1234);
        // t.num = 0;

        System.out.println(t.getInt());
        System.out.println(c.getInt());
        System.out.println(t.getInt());
    }
    
}

class test {
    // Init variables
    private final int num;

    // Constructor
    public test(int n) {
        // Assign variables ONCE
        num = n;
    }

    // Show variables
    public int getInt() {
        return num;
    }

}