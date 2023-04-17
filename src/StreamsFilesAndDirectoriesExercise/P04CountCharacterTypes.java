package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P04CountCharacterTypes {
    public static void main(String[] args) {

        String root = "C:\\Users\\BSGanchev\\Downloads\\Resources\\input.txt";
        String output = "C:\\Users\\BSGanchev\\Downloads\\Resources\\output.txt";

        int vowels = 0;
        int puncts = 0;
        int other = 0;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(root));
             PrintWriter writer = new PrintWriter(output)) {
            String line = reader.readLine();
            while (line != null) {

                for (char current : line.toCharArray()) {
                    if (current == 'a' || current == 'o' ||
                            current == 'u' || current == 'e' ||
                            current == 'i') {
                        vowels++;
                    } else if (current == '?' || current == '!' || current == '.' || current == ',') {
                        puncts++;
                    } else if (current != ' '&& current != '\r' && current != '\n'){
                        other++;
                    }
                }
                line = reader.readLine();

            }
            writer.println("Vowels: " + vowels);
            writer.println("Other symbols: " + other);
            writer.println("Punctuation: " + puncts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
