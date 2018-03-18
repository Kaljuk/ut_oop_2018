import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * FailiTest
 */
public class FailiTest {
    public static void main(String[] args) throws Exception {
        String pathString = args[args.length-1].toString();
        /*for(String i: args) {
            System.out.println(i);
        }*/

        Path path = Paths.get(pathString);
        if (Files.isDirectory(path) == false) {
            // throw new Error("Is not a folder");
            System.err.println("[Error] FailiTest main(): Ei ole kaust");
            return;
        }

        FailiVaatleja visitor = new FailiVaatleja();
        
        Path file = Files.walkFileTree(path, visitor);
        
        List<String> failiNimed = visitor.getFailiNimed();
        Collections.sort(failiNimed, new NimeVordleja());
        for(String failiNimi : failiNimed) {
            System.out.println(failiNimi);
        }

        /*List<String> a = Arrays.asList("a", "b", "c", "x", "f", "e", "r");
        Collections.sort(a, new NimeVordleja());
        for(String i : a) {
            System.out.println(i);
        }*/
    }
    
}