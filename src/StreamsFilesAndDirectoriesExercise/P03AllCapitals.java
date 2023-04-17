package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P03AllCapitals {
    public static void main(String[] args) {
        String root = "C:\\Users\\BSGanchev\\Downloads\\Resources\\input.txt";
        String output = "C:\\Users\\BSGanchev\\Downloads\\Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(root));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get(output)))
        {
            String line = reader.readLine();
            while (line != null) {

                String upperCaseLine = line.toUpperCase();
                writer.write(upperCaseLine + '\n');
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
