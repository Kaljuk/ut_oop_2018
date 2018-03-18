import java.util.Comparator;

/**
 * NimeVordleja
 */
public class NimeVordleja implements Comparator<String> {

    public int compare(String a, String b) {

        return a.compareTo(b)*-1;
    }
}