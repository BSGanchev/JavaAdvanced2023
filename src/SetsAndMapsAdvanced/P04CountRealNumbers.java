package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersMap = new LinkedHashMap<>();

        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).
                mapToDouble(Double::parseDouble).toArray();

        for (double num :
                input) {
            if (!numbersMap.containsKey(num)) {
                numbersMap.put(num, 1);
            } else {
                numbersMap.put(num, numbersMap.get(num) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
