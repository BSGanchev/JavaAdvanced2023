package IteratorsAndComparatorsExercise.P05ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        String commandLine = scanner.nextLine();

        while (!commandLine.equals("END")) {
            String[] command = commandLine.split("\\s+");
            Person person = new Person(command[0], Integer.parseInt(command[1]), command[2]);
            personList.add(person);
            commandLine = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        int counterEquals = 0;
        int counterDifferent = 0;
        Person personForCheck = personList.get(n - 1);
        personList.remove(personForCheck);
        for (Person person : personList) {
            if (personForCheck.compareTo(person) == 0) {
                counterEquals++;
            } else {
                counterDifferent++;
            }
        }
        if (counterEquals == 0) {
            System.out.println("No matches");
        } else {
            System.out.print(counterEquals + 1 + " ");
            System.out.print(counterDifferent + " ");
            System.out.print(personList.size() + 1);
        }
    }
}
