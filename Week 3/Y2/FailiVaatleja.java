import java.io.IOException;
import java.nio.file.FileVisitor;

/**
 * FailiVaatleja
 */
abstract class FailiVaatleja implements FileVisitor<Path> {
    
    @Override
    FileVisitResult visitFile (Path fn) 
        throws IOException {
        System.out.println(fn);
        return FileVisitResult.CONTINUE;
    };
    
}