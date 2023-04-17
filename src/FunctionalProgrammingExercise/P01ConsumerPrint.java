package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        Arrays.stream(input).forEach(e -> System.out.println(e));
    }
}
