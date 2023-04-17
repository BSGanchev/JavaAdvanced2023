package StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\06.SortLinesOutput.txt";

        Path inputPath = Paths.get(input);
        Path outputPath = Paths.get(output);

        List<String> lines = Files.readAllLines(inputPath).stream().sorted().collect(Collectors.toList());
        Files.write(outputPath, lines);

    }
}
