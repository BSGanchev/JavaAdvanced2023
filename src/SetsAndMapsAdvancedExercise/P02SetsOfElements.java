package SetsAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numberOfElements = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToInt(Integer::parseInt).toArray();
        int setOneSize = numberOfElements[0];
        int setTwoSize = numberOfElements[1];

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();
        for (int i = 0; i < setOneSize; i++) {

            int number = Integer.parseInt(scanner.nextLine());
            setOne.add(number);
        }
        for (int i = 0; i < setTwoSize; i++) {

            int number = Integer.parseInt(scanner.nextLine());
            setTwo.add(number);
        }
        setOne.retainAll(setTwo);
        setOne.forEach(e -> System.out.print(e + " "));
    }
}
