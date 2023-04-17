package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class P02WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\output.txt";
        List<Character> charList = Arrays.asList(',', '.', '!', '?');
        try (FileInputStream fileInputStream = new FileInputStream(input);
             FileOutputStream fileOutputStream = new FileOutputStream(output) ) {
            int readByte = fileInputStream.read();
            while (readByte >= 0) {
                if(!charList.contains((char) readByte)) {
                    fileOutputStream.write(readByte);


                }
                readByte = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
