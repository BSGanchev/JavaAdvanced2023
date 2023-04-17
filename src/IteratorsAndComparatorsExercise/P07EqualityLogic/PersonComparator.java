package IteratorsAndComparatorsExercise.P07EqualityLogic;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.getName().length(), o2.getName().length());
        if (result == 0) {
            result = o1.getName().compareTo(o2.getName());
        }
        if (result == 0) {
            result = Integer.compare(o1.getAge(), o2.getAge());
        }
        return result;
    }
}

