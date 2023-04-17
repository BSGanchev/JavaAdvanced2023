package FunctionalProgrammingExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    public static void main(String[] args) throws NullPointerException {
        Scanner scanner = new Scanner(System.in);

        List<String> nameList = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Party!")) {
            String[] command = commandLine.split("\\s+");
            String criteria = command[2];

            Predicate<String> stringPredicate = null;

            if (commandLine.contains("StartsWith")) {
                stringPredicate = x -> x.startsWith(criteria);
            } else if (commandLine.contains("EndsWith")) {
                stringPredicate = x -> x.endsWith(criteria);
            }
            if (commandLine.contains("Length")) {
                stringPredicate = x -> x.length() == Integer.parseInt(criteria);
            }
            if (commandLine.contains("Double")) {
                List<String> subList = new ArrayList<>();
                for (String name : nameList) {
                    if (stringPredicate.test(name)) {
                        subList.add(name);
                    }
                }
                nameList.addAll(subList);
            } else if (commandLine.contains("Remove")) {
                List<String> subList = new ArrayList<>();
                for (String name : nameList) {
                    if (stringPredicate.test(name)) {
                        subList.add(name);
                    }
                }
                nameList.removeAll(subList);
            }
            commandLine = scanner.nextLine();
        }
        if (nameList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(nameList.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString()
                    .replaceAll("[\\[\\]]", "") + " are going to the party!");
        }
    }
}
