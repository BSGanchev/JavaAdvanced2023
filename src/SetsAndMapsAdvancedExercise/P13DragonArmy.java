package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P13DragonArmy {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, int[]>> dragonsMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];

            Map<String, int[]> nameAndStats = new TreeMap<>();
            int[] stats = new int[3];

            int damage = 45;
            if (!input[2].equals("null")) {
                damage = Integer.parseInt(input[2]);
            }
            int health = 250;
            if (!input[3].equals("null")) {
                health = Integer.parseInt(input[3]);
            }
            int armor = 10;
            if (!input[4].equals("null")) {
                armor = Integer.parseInt(input[4]);
            }
            stats[0] = damage;
            stats[1] = health;
            stats[2] = armor;

            nameAndStats.put(name, stats);

            if (!dragonsMap.containsKey(type)) {
                dragonsMap.put(type, nameAndStats);
            } else {
                dragonsMap.get(type).remove(name);
                dragonsMap.get(type).put(name, stats);
            }

        }
        dragonsMap.forEach((key, value) -> {
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            for (int[] ints : value.values()) {
                averageDamage += ints[0];
                averageHealth += ints[1];
                averageArmor += ints[2];
            }
            averageDamage /= value.size();
            averageHealth /= value.size();
            averageArmor /= value.size();

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, averageDamage, averageHealth, averageArmor );
            dragonsMap.get(key).forEach((k, v) -> System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", k, v[0], v[1], v[2]));

        });
    }
}
