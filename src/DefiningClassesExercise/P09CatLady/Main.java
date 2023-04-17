package DefiningClassesExercise.P09CatLady;

import java.util.*;

public class Main {
    final public static String END = "End";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Cat> catMap = new HashMap<>();
        String input = scanner.nextLine();

        while (!END.equals(input)) {
            String breed = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            Cat cat = null;
            switch (breed) {
                case "Siamese":
                    cat = new Siamese(name, Double.parseDouble(input.split("\\s+")[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(name, Double.parseDouble(input.split("\\s+")[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(name, Double.parseDouble(input.split("\\s+")[2]));
                    break;
            }
            catMap.put(name, cat);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        if (catMap.containsKey(input)) {
            System.out.println(catMap.get(input));
        }
    }
}
