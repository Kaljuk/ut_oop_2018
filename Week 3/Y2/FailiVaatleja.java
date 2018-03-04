import java.io.IOException;
import java.nio.file.FileVisitor;

/**
 * FailiVaatleja
 */
// <Path>
public class FailiVaatleja implements FileVisitor {
    
    // @Override
    FileVisitResult visitFile (Path fn) 
        throws IOException {
        System.out.println(fn);
        return FileVisitResult.CONTINUE;
    };
    
}