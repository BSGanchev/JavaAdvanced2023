package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int lower = Integer.parseInt(input[0]);
        int upper = Integer.parseInt(input[1]);
        String oddOrEven = scanner.nextLine();

        Predicate<Integer> filterOddOrEven = oddOrEven.equals("odd") ? x -> x % 2 != 0 : x -> x % 2 == 0 ;

        IntStream.range(lower, upper + 1).filter(e -> filterOddOrEven.test(e)).forEach(e -> System.out.print(e + " "));


    }
}
