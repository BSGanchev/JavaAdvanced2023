package DefiningClassesExercise.P01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        while (count -- > 0) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);

            Person person = new Person(name, age);
            personList.add(person);
        }
        personList.stream().filter(p->p.getAge() > 30).sorted(Comparator.comparing(p -> p.getName())).
                forEach(e -> System.out.println(e.getName() + " - " + e.getAge()));
    }
}
