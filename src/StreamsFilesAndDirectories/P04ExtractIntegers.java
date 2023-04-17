package StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04ExtractIntegers {
    public static void main(String[] args) {
        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\04.ExtractIntegersOutput.txt";

        try (FileInputStream fileInputStream = new FileInputStream(input);
             FileOutputStream fileOutputStream = new FileOutputStream(output)) {

            PrintWriter printWriter = new PrintWriter(fileOutputStream);
            Scanner scanner = new Scanner(fileInputStream);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    printWriter.println(scanner.nextInt());
                }
                scanner.next();
            }
            printWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
