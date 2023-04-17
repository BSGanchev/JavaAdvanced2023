package IteratorsAndComparatorsExercise.P06StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<Person> personByName = new TreeSet<>(new NameComparator());
        TreeSet<Person> personByAge = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(scanner.nextLine());
        while (n -- > 0) {
            String input = scanner.nextLine();
            String[] data = input.split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            personByName.add(person);
            personByAge.add(person);
        }
        personByName.forEach(System.out::println);
        personByAge.forEach(System.out::println);
    }
}
