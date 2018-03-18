import java.io.IOException;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.*;
/**
 * FailiVaatleja
 */
// <Path>
public class FailiVaatleja implements FileVisitor<Path> {
    private List<String> failiNimed;

    public FailiVaatleja() {
        this.failiNimed = new ArrayList<>();
    }
    //public static void main(String[] args) throws Exception {
    //}
    public FileVisitResult visitFileFailed(Path fn, IOException e) {
        return FileVisitResult.CONTINUE;
    }
    public FileVisitResult postVisitDirectory(Path fn, IOException e) {
        return FileVisitResult.CONTINUE;
    };
    public FileVisitResult preVisitDirectory(Path p, BasicFileAttributes a) {
        return FileVisitResult.CONTINUE;
    }


    //@Override
    public FileVisitResult visitFile (Path fn) throws IOException {
        // Ärge siin meetodis midagi ekraanile väljastage.
        //System.out.println("Failinimi: " + fn.toString());
        failiNimed.add(fn.toString());
        return FileVisitResult.CONTINUE;
    };
    public FileVisitResult visitFile (Path fn, BasicFileAttributes a) throws IOException {
        // Ärge siin meetodis midagi ekraanile väljastage.
        //System.out.println("Failinimi: " + fn.toString());
        failiNimed.add(fn.toString());
        return FileVisitResult.CONTINUE;
    };


    public List<String> getFailiNimed() {
        return this.failiNimed;
    }
}