package SetsAndMapsAdvancedExercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> countingMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if(!countingMap.containsKey(currentChar)) {
                countingMap.put(currentChar, 1);
            } else {
                int value = countingMap.get(currentChar);
                countingMap.put(currentChar, value + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : countingMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
