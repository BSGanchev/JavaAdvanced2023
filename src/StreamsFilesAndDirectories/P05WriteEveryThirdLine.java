package StreamsFilesAndDirectories;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) {
        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String input = path + "\\input.txt";
        String output = path + "\\05.WriteEveryThirdLineOutput.txt";


        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            int counter = 1;
            String line = reader.readLine();
            while (line != null) {
                if(counter % 3 == 0) {
                    writer.println(line);
                }
                line = reader.readLine();
                counter++;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
