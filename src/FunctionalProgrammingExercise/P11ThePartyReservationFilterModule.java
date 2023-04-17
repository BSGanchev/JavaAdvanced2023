package FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> invitations = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();


        List<String> commands = new ArrayList<>();
        Predicate<String> predicate = null;

        while (!commandLine.equals("Print")) {
            String[] command = commandLine.split(";");
            if (commandLine.contains("Add")) {
                commands.add(commandLine);
            } else if (commandLine.contains("Remove")) {
                commands.removeIf(s -> s.equals("Add filter;" + command[1] + ";" + command[2]));
            }
            commandLine = scanner.nextLine();
        }

        for (String s : commands) {
            String criteria = s.split(";")[2];

            if (s.contains("Length")) {
                predicate = x -> x.length() == Integer.parseInt(criteria);
                invitations.removeIf(predicate);
            } else if (s.contains("Starts")) {
                predicate = x -> x.startsWith(criteria);
                invitations.removeIf(predicate);
            } else if (s.contains("End")) {
                predicate = x -> x.endsWith(criteria);
                invitations.removeIf(predicate);
            } else if (s.contains("Contains")) {
                predicate = x -> x.contains(criteria);
                invitations.removeIf(predicate);

            }
        }
        System.out.println(invitations.stream().collect(Collectors.joining(" "))
                .replaceAll("[\\[\\]]", ""));
    }
}
