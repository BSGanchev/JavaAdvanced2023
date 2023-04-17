package FunctionalProgrammingExercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(e ->Integer.parseInt(e)).collect(Collectors.toList());
        int num = Integer.parseInt(scanner.nextLine());


        Predicate<Integer> divisibleByN = removeDivisibleByN(num);
        Collections.reverse(numbers);

        numbers.stream().filter(divisibleByN).forEach (e -> System.out.print(e + " "));

    }

    private static Predicate<Integer> removeDivisibleByN(int num) {
        return n -> n % num != 0;
    }
}
