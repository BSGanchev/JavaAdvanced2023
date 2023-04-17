package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> upperStart = e -> Character.isUpperCase(e.charAt(0));

        List<String> input = Arrays.stream(scanner.nextLine().split(" ")).filter(upperStart)
                .collect(Collectors.toList());
        System.out.println(input.size());
        input.forEach(System.out::println);
    }
}
