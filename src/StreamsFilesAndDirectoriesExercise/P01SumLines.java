package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class P01SumLines {
    public static void main(String[] args) {
        Path inputPath = Paths.get("C:\\Users\\BSGanchev\\Downloads\\Resources\\input.txt");

        try {
            try (BufferedReader bufferedReader = Files.newBufferedReader(inputPath)) {
                String line = bufferedReader.readLine();
                while (line != null) {
                    long sum = 0;
                    for (char currentChar:
                         line.toCharArray()) {
                        sum += currentChar;

                    }
                    System.out.println(sum);
                    line = bufferedReader.readLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
