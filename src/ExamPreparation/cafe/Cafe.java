package ExamPreparation.cafe;

import java.util.ArrayList;
import java.util.List;

public class Cafe {
    private List<Employee> employeeList;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employeeList = new ArrayList<>(capacity);
    }

    public int repoSize() {
        return this.capacity;
    }

    public void addEmployee(Employee employee) {
        if (this.employeeList.size() < this.capacity) {
            employeeList.add(employee);
        }
    }

    public boolean removeEmployee(String name) {

        return this.employeeList.removeIf(p -> p.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        Employee oldestOne = new Employee("Petko", 0, "Varna");
        for (Employee employee : this.employeeList) {
            if (employee.getAge() > oldestOne.getAge()) {
                oldestOne = employee;
            }
        }
        return oldestOne;
    }

    public Employee getEmployee(String name) {
        Employee employeeForReturn = null;
        for (Employee employee : this.employeeList) {
            if (employee.getName().equals(name)) {
                employeeForReturn = employee;
            }
        }
        return employeeForReturn;
    }

    public int getCount() {
        return this.employeeList.size();
    }

    public String report() {
        StringBuilder result = new StringBuilder();
        result.append("Employees working at Cafe ").append(this.name).append(System.lineSeparator());
        for (Employee employee : this.employeeList) {
            result.append(employee).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
