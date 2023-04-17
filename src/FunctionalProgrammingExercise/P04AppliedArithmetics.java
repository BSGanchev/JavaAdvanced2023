package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(n -> n + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(n -> n -= 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(n -> n *= 2).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(integer -> System.out.printf("%d ", integer));

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    integerList = add.apply(integerList);
                    break;
                case "subtract":
                    integerList = subtract.apply(integerList);
                    break;
                case "multiply":
                    integerList = multiply.apply(integerList);
                    break;
                case "print":
                    print.accept(integerList);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
