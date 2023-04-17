package SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Double[]> studentMap = new TreeMap<>();

        DecimalFormat format = new DecimalFormat("0.######################");
        while (count -- > 0) {
            String name = scanner.nextLine();
            Double[] grades = Arrays.stream(scanner.nextLine().split(" ")).map(Double::parseDouble).toArray(Double[]::new);
            studentMap.put(name, grades);

        }
        for (Map.Entry<String, Double[]> entry : studentMap.entrySet()) {
           Double average = (Double) average(entry.getValue());

            System.out.printf("%s is graduated with %s%n", entry.getKey(), format.format(average));
        }

    }

    private static Object average(Double[] value) {
        Double sum = 0.0;
        for (Double number : value) {
            sum += number;
        }
        return  sum/value.length;
    }
}
