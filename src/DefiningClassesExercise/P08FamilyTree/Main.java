package DefiningClassesExercise.P08FamilyTree;

import java.util.*;

public class Main {
    public static final String END = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, List<String>> childByParentMap = new LinkedHashMap<>();
        List<Person> personList = new ArrayList<>();
        Set<String> stringSet = new LinkedHashSet<>();

        String input = scanner.nextLine();
        String target = input;
        input = scanner.nextLine();

        while (!input.equals(END)) {
            if (input.contains(" - ")) {
                String parentsPart = input.split(" - ")[0];
                String childrenPart = input.split(" - ")[1];
                childByParentMap.putIfAbsent(parentsPart, new ArrayList<>());
                childByParentMap.get(parentsPart).add(childrenPart);
                stringSet.add(parentsPart);
                stringSet.add(childrenPart);
            } else {
                String[] parts = input.split("\\s+");
                String name = parts[0] + " " + parts[1];
                String birthday = parts[parts.length - 1];
                Person person = new Person(name, birthday);
                personList.add(person);
            }
            input = scanner.nextLine();
        }
        for (String inputData : stringSet) {
            Person current = getInfoForPerson(inputData, personList);

            for (Map.Entry<String, List<String>> entry : childByParentMap.entrySet()) {
                Person parent = getInfoForPerson(entry.getKey(), personList);

                for (String childInfo : entry.getValue()) {
                    Person child = getInfoForPerson(childInfo, personList);

                    if (current == child) {
                        current.addParent(parent);

                    } else if (current == parent) {
                        current.addChild(child);
                    }
                }
            }
        }
        System.out.println(getInfoForPerson(target, personList).toString());
    }


    private static Person getInfoForPerson(String info, List<Person> personList) {
        Person current = null;
        for (Person person : personList) {
            if (person.getName().equals(info) || person.getBirthDate().equals(info)) {
                current = person;
            }
        }
        return current;
    }
}
