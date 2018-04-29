import java.io.File;
import java.io.FilenameFilter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Peaklass
 */
public class Peaklass {

    private static List<BigInteger> allExtremums = new ArrayList<BigInteger>();
    private static List<BigInteger> totalSums = new ArrayList<BigInteger>();

    BlockingQueue<String> blockingQueue;

    public static void main(String[] args) {
        File[] files = getFiles(
            (args.length > 0)? args[0]:"."
        );
        
        
        if (files.length > 0) {
            int i=0;
            
            while(i < files.length) {
                while(Runtime.getRuntime().availableProcessors() == 0){
                    //System.out.println("Waiting for an available core");
                };
                new Thread(new MinionCalculator(files[i].toString(), totalSums, allExtremums)).start();
                i++;
            }
            
            System.out.println("DONE");
        } else {
            System.out.println("No files found");
        }

    }

    public static void minionHandler() {

    }

    private static File[] getFiles(String kaustaNimi) {
        if (kaustaNimi == null) { return null; }
        // Count all .txt files
        File kaust = new File(kaustaNimi);
        File[] failid = kaust.listFiles(new FilenameFilter(){
            public boolean accept(File dir, String filename) { 
                return filename.endsWith(".txt"); 
            } 
        });
        return failid;
    }
}