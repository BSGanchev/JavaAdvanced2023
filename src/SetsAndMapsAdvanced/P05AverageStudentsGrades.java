package SetsAndMapsAdvanced;

import java.util.*;

public class P05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<Double>> studentsMap = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            double grade = Double.parseDouble(input.split("\\s+")[1]);

            if(!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
                studentsMap.get(name).add(grade);
            }else {
                studentsMap.get(name).add(grade);
            }
        }
        for (Map.Entry<String, ArrayList<Double>> entry : studentsMap.entrySet()) {
            System.out.printf("%s -> ", entry.getKey());
            double gradesSum = 0;
            for (Double grade :
                    entry.getValue()) {
                System.out.printf("%.2f ",grade);
                gradesSum += grade;
            }
            System.out.printf(("(avg: %.2f)"), gradesSum/entry.getValue().size());
            gradesSum = 0;

            System.out.println();
        }
    }
}
