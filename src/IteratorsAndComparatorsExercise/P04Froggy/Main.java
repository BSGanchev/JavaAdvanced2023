package IteratorsAndComparatorsExercise.P04Froggy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Lake lake = null;
        String input = scanner.nextLine();
        while(!input.equals("END")) {
            Integer[] integers = Arrays.stream(input.split(", ")).map(Integer::parseInt).toArray(Integer[]::new);
            lake = new Lake(integers);
            input = scanner.nextLine();
        }

        Iterator<Integer> iterator = lake.iterator();
        StringBuilder result = new StringBuilder();
        while (iterator.hasNext()) {
            result.append(iterator.next() + ", ");
        }
        result.delete(result.length() - 2, result.length() - 1);

        System.out.println(result);
    }
}
