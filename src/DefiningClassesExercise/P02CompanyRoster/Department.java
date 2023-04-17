package DefiningClassesExercise.P02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> employeeList;

    public Department(String departmentName) {
        this.departmentName = departmentName;
        this.employeeList = new ArrayList<>();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public double getAverageSalary() {
        return this.employeeList.stream().mapToDouble(e -> e.getSalary()).average().orElse(0.00);
    }
}
