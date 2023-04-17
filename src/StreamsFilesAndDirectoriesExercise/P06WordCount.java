package StreamsFilesAndDirectoriesExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class P06WordCount {
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\BSGanchev\\Downloads\\Resources\\text.txt";
        String output = "C:\\Users\\BSGanchev\\Downloads\\Resources\\result.txt";
        String words = "C:\\Users\\BSGanchev\\Downloads\\Resources\\words.txt";

        List<String> wordsList = Files.readAllLines(Path.of(words));

        Map<String, Integer> wordsCounter = new HashMap<>();
        try {
            try (BufferedReader reader = Files.newBufferedReader(Paths.get(input))) {

                for (String word :
                        wordsList) {
                    String[] row = word.split(" ");
                    Arrays.stream(row).forEach(e -> {
                        wordsCounter.put(e, 0);
                    });
                }
                String line = reader.readLine();
                while (line != null) {
                    line = line.replaceAll("[\\.\\,\\?\\!\\:]", "");
                    String[] currentLine = line.split(" ");

                    for (String word :
                            currentLine) {
                        if (wordsCounter.containsKey(word)) {
                            wordsCounter.put(word, wordsCounter.get(word) + 1);
                        }

                    }
                    line = reader.readLine();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (PrintWriter writer = new PrintWriter(output)) {

            wordsCounter.entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(entry ->
            writer.println(entry.getKey() + " - " + entry.getValue()));
        }
    }
}