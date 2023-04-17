package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class P09ListOfPredicates {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int end = Integer.parseInt(scanner.nextLine());

        List<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<List<Integer>, Integer, Boolean> divisible = ((list, integer) -> {
            for (Integer currentInteger : list) {
                if (integer % currentInteger != 0) {
                    return false;
                }

            }
            return true;
        });

        for (int num = 1; num <= end; num++) {
            if (divisible.apply(divisors, num)) {
                System.out.print(num + " ");
            }
        }
    }

}
