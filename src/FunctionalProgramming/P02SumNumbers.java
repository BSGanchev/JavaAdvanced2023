package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P02SumNumbers {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            List<String> input = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
            Function<String, Integer> parsing = e -> Integer.parseInt(e);
            int sum = 0;
            for (String s:
                    input) {
                sum += parsing.apply(s);
            }

            System.out.printf("Count = %d%n", input.size());
            System.out.printf("Sum = %d", sum);
    }
}
