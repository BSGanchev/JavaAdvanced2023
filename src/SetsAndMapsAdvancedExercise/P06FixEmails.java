package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> emailsMap = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("stop")) {

            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                emailsMap.put(command, email);
            }

            command = scanner.nextLine();

        }
        emailsMap.forEach((e, v) -> System.out.printf("%s -> %s%n", e, v));
    }
}
