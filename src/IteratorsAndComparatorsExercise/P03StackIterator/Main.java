package IteratorsAndComparatorsExercise.P03StackIterator;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Stack<Integer> integerStack = new Stack<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+", 2);
            switch(tokens[0]) {
                case "Push":
                    List<String> intTokens = Arrays.stream(tokens[1].trim().split(",\\s+")).collect(Collectors.toList());
                    List<Integer> integers = intTokens.stream().map(Integer::parseInt).collect(Collectors.toList());
                    for (Integer integer : integers) {
                        integerStack.Push(integer);
                    }
                    break;
                case "Pop":
                    try {
                        integerStack.Pop();
                    } catch (OperationNotSupportedException ex) {
                        System.out.println("No elements");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        integerStack.forEach(System.out::println);

        integerStack.forEach(e -> System.out.println(e));
    }

}
