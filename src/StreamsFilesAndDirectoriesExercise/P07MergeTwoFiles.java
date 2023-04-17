package StreamsFilesAndDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String inputOne = "C:\\Users\\BSGanchev\\Downloads\\Resources\\inputOne.txt";
        String inputTwo = "C:\\Users\\BSGanchev\\Downloads\\Resources\\inputTwo.txt";


        PrintWriter writer = new PrintWriter("C:\\Users\\BSGanchev\\Downloads\\Resources\\merged.txt");

        List<String> wordsOne = Files.readAllLines(Path.of(inputOne));
        wordsOne.forEach(e -> writer.println(e));
        List<String> wordsTwo = Files.readAllLines(Path.of(inputTwo));
        wordsTwo.forEach(e -> writer.println(e));

        writer.close();
    }
}
