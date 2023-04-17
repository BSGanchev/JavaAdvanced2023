package SetsAndMapsAdvancedExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Set<String> periodicTable = new TreeSet<>();

        while (count -- > 0){
            String input = scanner.nextLine();
            String[] elements = input.split("\\s+");
            periodicTable.addAll(Arrays.asList(elements));

        }
        periodicTable.forEach(e -> System.out.print(e + " "));
    }
}
