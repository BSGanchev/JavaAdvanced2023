package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class P01ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int oneByte = fileInputStream.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileInputStream.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
