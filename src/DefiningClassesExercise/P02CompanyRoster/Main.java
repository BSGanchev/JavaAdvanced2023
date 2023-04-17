package DefiningClassesExercise.P02CompanyRoster;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departmentMap = new HashMap<>(  );

        while (count-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String employeeName = input[0];
            Double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String departments = input[3];
            String email = null;
            int age = 0;
            if (input.length == 6) {
                email = input[4];
                age = Integer.parseInt(input[5]);
            } else if (input.length == 5) {
                if (input[4].contains("@")) {
                    email = input[4];
                } else {
                    age = Integer.parseInt(input[4]);
                }
            }

            Employee employee = new Employee(employeeName, salary, position, email, age, departments);
            if (!departmentMap.containsKey(departments)) {
                departmentMap.put(departments, new Department(departments));
                departmentMap.get(departments).getEmployeeList().add(employee);
            } else {
                departmentMap.get(departments).getEmployeeList().add(employee);
            }
        }
            Department maxAverage = departmentMap.entrySet().stream().
                    max(Comparator.comparing(entry -> entry.getValue().getAverageSalary())).
                    get().getValue();

        System.out.println("Highest Average Salary: " + maxAverage.getDepartmentName());

        maxAverage.getEmployeeList().stream().sorted((l, r) -> Double.compare(r.getSalary(), l.getSalary())).
                forEach(e -> System.out.print(e.toString()));
    }
}
