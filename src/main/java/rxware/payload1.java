package rxware;

import com.mojang.brigadier.Command;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

// Java program to create a text File using FileWriter
public class payload1{
    public static void main(){
        Path windowsDir = Paths.get(System.getenv("windir"));
        Path notepadPath = Paths.get(windowsDir.toString(), "notepad.exe");

        try {
            Process notepad = new ProcessBuilder(notepadPath.toString()).start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
