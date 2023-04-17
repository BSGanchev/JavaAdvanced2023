package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P05LineNumbers {
    public static void main(String[] args) {

        String input = "C:\\Users\\BSGanchev\\Downloads\\Resources\\inputLineNumbers.txt";
        String output = "C:\\Users\\BSGanchev\\Downloads\\Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(input));
             PrintWriter writer = new PrintWriter(output)) {

            String line = reader.readLine();
            int count = 1;
            while (line != null) {

                writer.write(count  + ". " + line + System.lineSeparator());

                line = reader.readLine();
                count ++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
