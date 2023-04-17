package DefiningClassesExercise.P07Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String END = "End";
    public static final String COMPANY = "company";
    public static final String POKEMON = "pokemon";
    public static final String PARENTS = "parents";
    public static final String CHILDREN = "children";
    public static final String CAR = "car";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Person> personMap = new LinkedHashMap<>();
        while (!END.equals(input)) {
            String[] data = input.split("\\s+");
            String name = data[0];
            if (!personMap.containsKey(name)) {
                personMap.put(name, new Person());
            }
            String type = data[1];
            switch (type) {
                case COMPANY:
                    String companyName = data[2];
                    String department = data[3];
                    double salary = Double.parseDouble(data[4]);
                    Company company = new Company(companyName, department,salary);
                    personMap.get(name).setCompany(company);
                    break;
                case POKEMON:
                    String pokemonName = data[2];
                    String pokemonType = data[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personMap.get(name).getPokemonList().add(pokemon);
                    break;
                case PARENTS:
                    String parentName = data[2];
                    String parentsBirthDate = data[3];
                    Parents parents = new Parents(parentName, parentsBirthDate);
                    personMap.get(name).getParentsList().add(parents);
                    break;
                case CHILDREN:
                    String childName = data[2];
                    String childBirthDate = data[3];
                    Children children = new Children(childName, childBirthDate);
                    personMap.get(name).getChildrenList().add(children);
                    break;
                case CAR:
                    String model = data[2];
                    int speed = Integer.parseInt(data[3]);
                    Car car = new Car(model, speed);
                    personMap.get(name).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        String personToSearch = scanner.nextLine();

        Person personToPrint = personMap.get(personToSearch);
        System.out.println(personToSearch);
        System.out.print(personToPrint);
    }
}
