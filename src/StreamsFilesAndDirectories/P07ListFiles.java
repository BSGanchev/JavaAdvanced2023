package StreamsFilesAndDirectories;

import java.io.File;

public class P07ListFiles {
    public static void main(String[] args) {

        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);
        File[] filesArray = file.listFiles();

        for (File files : filesArray) {
            if(files.isFile()) {
                System.out.printf("%s: [%d]%n", files.getName(), files.length());
            }
        }
    }
}
