package rxware;

import com.mojang.brigadier.Command;

import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Java program to create a text File using FileWriter
public class payload1{
    public static void main(){
        Process a;
        String b;
        try {
            a = Runtime.getRuntime().exec("touch ~/boo"); //blank file jumpscare
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
