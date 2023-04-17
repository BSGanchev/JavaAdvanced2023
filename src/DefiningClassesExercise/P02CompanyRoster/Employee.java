package DefiningClassesExercise.P02CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String email;
    private int age;
    private String department;

    public Employee(String name, double salary, String position, String email, int age, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.email = email;
        this.age = age;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name).append(" ").append(String.format("%.2f", salary)).append(" ");
        if (email != null) {
            stringBuilder.append(email);
        } else {
            stringBuilder.append("n/a");

        } stringBuilder.append(" ");
        if (age != 0) {
            stringBuilder.append(age);
        } else {
            stringBuilder.append("-1");
        }
        stringBuilder.append(System.lineSeparator());
        return stringBuilder.toString();
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }
}
