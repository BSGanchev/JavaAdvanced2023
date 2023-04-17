package StreamsFilesAndDirectories;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class P08NestedFolders {
    public static void main(String[] args) {

        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

        File file = new File(path);
        Deque<File> directories = new ArrayDeque<>();
        directories.offer(file);

        int count = 1;

        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] nested = current.listFiles();

            for (File files : nested) {
                if (files.isDirectory()) {
                    directories.offer(files);
                    count++;
                }
            }
                    System.out.println(current.getName());
        }
                System.out.println(count + " folders");
    }
}

