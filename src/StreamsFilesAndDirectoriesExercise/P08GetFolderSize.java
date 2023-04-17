package StreamsFilesAndDirectoriesExercise;

import java.io.File;

public class P08GetFolderSize {
    public static void main(String[] args) {

        String path = "C:\\Users\\BSGanchev\\Downloads\\Resources\\Exercises Resources";

        File folder = new File(path);
        File[] allFiles = folder.listFiles();

        int size = 0;
        if (allFiles != null) {
            for (File file:
                 allFiles) {
                size += file.length();
            }
        }

        System.out.println("Folder size: " + size);
    }
}
