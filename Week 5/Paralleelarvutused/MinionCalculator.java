import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.*;
import java.util.List;
import java.util.regex.Pattern;

/**
 * MinionCalculator
 */
public class MinionCalculator implements Runnable {
    public static int runners=0;

    private BigInteger biggestInt;
    private BigInteger smallestInt;
    private BigInteger sum;// = new BigInteger("0");
    private String fn;

    private List<BigInteger> sumList;
    private List<BigInteger> extremumsList;

    private String nonReadable = "";

    public MinionCalculator(String fileName, List<BigInteger> sumList, List<BigInteger> extremumsList) {
        super();
        runners++;
        this.fn = fileName;
        this.sumList = sumList;
        this.extremumsList = extremumsList;
    }

    public void run() {
        readFilecontents();
        showResults();
        sumList.add(this.sum);
        extremumsList.add(smallestInt);
        extremumsList.add(biggestInt);
/*        try {
            sleep(2000);
        } catch(Exception e) {}*/
        runners--;
        System.out.println("Runners"+runners);
    }

    private void showResults() {

        String errors = (nonReadable != "")?
                "Can't parse bigInt out of: "+ nonReadable
                :"No number parsing errors encountered.";
        
        String resultsMessage = String.format(
            "FileName    : %s\nBiggestInt  : %d \nSmallestInt : %d\nSum         : %d\n%s\n\n",
            this.fn, this.biggestInt, this.smallestInt, this.sum, errors
        );
        
        System.out.println(resultsMessage);
    }

    private void processBigInt(BigInteger newBigInt) {
        // Smallest value
        this.smallestInt = 
            (this.smallestInt == null)? newBigInt // If variable has no value aka == null
            : ( newBigInt.compareTo(this.smallestInt) != -1 ) ? this.smallestInt 
            : newBigInt;
        // Biggest value
        this.biggestInt  = 
            (this.biggestInt == null)? newBigInt // If variable has no value aka == null
            : ( newBigInt.compareTo(this.biggestInt)  !=  1 ) ? this.biggestInt  
            : newBigInt;
        // Sum of all values
        this.sum         = (this.sum == null)? newBigInt : this.sum.add(newBigInt);
        
    }

    private void readFilecontents() {
        InputStream inputStream;

        try {
            inputStream = new FileInputStream(new File(this.fn));
            
            //InputStream inputStream = new FileInputStream(fn);
            BufferedReader failiSisu;
            // Ei kasuta fileReaderit ning saab kodeeringut valida
            failiSisu = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            
            // Get file contents
            String failiRida;
            String[] numbrid;
            
            int i;
            while((failiRida= failiSisu.readLine()) != null) {
                
                failiRida = failiRida.replaceAll("\\p{C}", "");
                numbrid = failiRida.split(" ");
                for(i=0; i<numbrid.length; i++) {
                    if (numbrid[i].length() == 0) continue;
                    
                    try {
                        processBigInt(new BigInteger(numbrid[i]));    
                    } catch(NumberFormatException e) {
                        nonReadable += numbrid[i] + " ";
                    }
                }

                System.out.println();
            }
                        
            // Close the buffer
            failiSisu.close();
            // When file
        } catch(FileNotFoundException e) {
            System.out.println("File not found: "+e);;
        } catch(Exception e) {
            System.out.println(e);
        }
    }
    

    // Getters 
    public BigInteger getBiggestInt() {
        return this.biggestInt;
    }
    public BigInteger getSmallestInt() {
        return this.smallestInt;
    }
    public BigInteger getSum() {
        return this.sum;
    }
}