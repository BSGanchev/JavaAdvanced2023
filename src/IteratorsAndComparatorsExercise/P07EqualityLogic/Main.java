package IteratorsAndComparatorsExercise.P07EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> personSet = new TreeSet<>(new PersonComparator());
        HashSet<Person> personHashSet = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n -- > 0) {
            String data = scanner.nextLine();
            String name = data.split("\\s+")[0];
            int age = Integer.parseInt(data.split("\\s+")[1]);

            Person person = new Person(name, age);
            personSet.add(person);
            personHashSet.add(person);
        }

        System.out.println(personSet.size());
        System.out.println(personHashSet.size());
    }
}
