package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class P06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nameLength = Integer.parseInt(scanner.nextLine());

        Predicate<String> checkNameLength = s -> s.length() <= nameLength;

        Arrays.stream(scanner.nextLine().split("\\s+")).
                filter(checkNameLength).
                forEach(e -> System.out.println(e));
    }
}
