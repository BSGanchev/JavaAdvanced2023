package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02SumBytes {
    public static void main(String[] args) {
        String root = "C:\\Users\\BSGanchev\\Downloads\\Resources\\input.txt";
        long sum = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(root))) {

            String line = bufferedReader.readLine();

            while (line != null) {
                for (char current :
                        line.toCharArray()) {
                    sum += current;
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(sum);
    }
}
