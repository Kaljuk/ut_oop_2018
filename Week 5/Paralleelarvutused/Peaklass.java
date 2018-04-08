/**
 * Peaklass
 */
public class Peaklass {

    public static void main(String[] args) {
        // Get file folder
        File kaust = new File(args[0]);
        // Count all .txt files
        kaust.listFiles(new FilenameFilter() { 
            public boolean accept(File dir, String filename)
                { 
                    return filename.endsWith(".txt"); 
                }
            } 
        );
        // TXT fn -> String[]
        // When minion is done then it pops one element

        // Assign a minion to each file

        // if all elements are popped, we can continue

    }
}