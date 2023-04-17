package IteratorsAndComparatorsExercise.P06StrategyPattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());

        if (result == 0) {
            char personOne = o1.getName().toLowerCase().charAt(0);
            char personTwo = o2.getName().toLowerCase().charAt(0);
            result = Character.compare(personOne, personTwo);
        }
        return result;
    }
}
