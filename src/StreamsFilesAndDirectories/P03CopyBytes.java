package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03CopyBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\03.CopyBytesOutput.txt";

        try (FileInputStream fileInputStream = new FileInputStream(input);
             FileOutputStream fileOutputStream = new FileOutputStream(output)) {
            int readByte = fileInputStream.read();
            while (readByte >= 0) {
                if(readByte == 10 || readByte == 32) {
                    fileOutputStream.write(readByte);
                } else {

                    String digits = String.valueOf(readByte);
                    for (int i = 0; i < digits.length(); i++) {

                        fileOutputStream.write(digits.charAt(i));
                    }
                }

                readByte = fileInputStream.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
