package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] input = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .toArray(Integer[]::new);


        Function<Integer[], Integer> smallest = e -> {
            Integer min = Integer.MAX_VALUE;
            for (Integer integer : e) {
                if (integer < min) {
                    min = integer;
                }
            }
            return min;
        };
        System.out.println(smallest.apply(input));
    }
}
