package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Set<String> usernameSet = new LinkedHashSet<>();
        while (count-- > 0) {
            String username = scanner.nextLine();

            usernameSet.add(username);
        }

        for (String name : usernameSet) {
            System.out.println(name);
        }
    }
}
