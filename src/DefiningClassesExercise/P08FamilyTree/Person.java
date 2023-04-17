package DefiningClassesExercise.P08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private List<Person> parentList;
    private List<Person> childrenList;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parentList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public void addParent(Person person) {
        if (personIsNew(person, parentList)) {
            this.parentList.add(person);
        }
    }
    public void  addChild(Person person) {
        if(personIsNew(person, childrenList)){
            this.childrenList.add(person);
        }
    }

    private boolean personIsNew(Person person, List<Person> personList) {

        for (Person per : personList) {
            if(per.equals(person)){
                return false;
            }
        }
        return true;
    }
    public String output(List<Person> personList) {
        StringBuilder output = new StringBuilder();

        if(!personList.isEmpty()) {
            for (Person person : personList) {
                output.append(String.format("%s %s%n", person.getName(), person.getBirthDate()));
            }
        }
        return output.toString();
    }
    @Override
    public String toString() {
        return String.format("%s %s%nParents:%n%sChildren:%n%s", name, String.join(" / ", birthDate),
                output(parentList), output(childrenList));
    }
}
