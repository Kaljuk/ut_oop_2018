import java.util.Scanner;

/**
 * learnscanner
 */
public class learnscanner {

    public static void main(String[] args) {
        // Create scanner
        Scanner input = new Scanner(System.in);
        // Dollar variable for input
        int dollars = -1;

        System.out.print("Insert dollars: ");
        dollars = scannerInt(input);

        System.out.printf("CL inserted %d dollars", dollars);
    }

    public static int scannerInt(Scanner scan) {
        boolean gotInt = false;
        int scannedInt = 0;
        while (!gotInt) {
            try {
                scannedInt = Integer.valueOf(scan.nextLine());
                gotInt     = true;
            } catch(NumberFormatException e) {
                gotInt     = false;
                System.out.print("\nIntegers only, please try again: ");
            }
        }
        return scannedInt;
    }
}