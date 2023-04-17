package SetsAndMapsAdvancedExercise;

import com.sun.source.tree.Tree;

import java.util.*;

public class P11LegendaryFarming {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> lootMap = new TreeMap<>();
        Map<String, Integer> junk = new TreeMap<>();
        lootMap.put("shards", 0);
        lootMap.put("fragments", 0);
        lootMap.put("motes", 0);


        boolean goal = false;

        while (!goal) {

            String[] loot = scanner.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < loot.length; i += 2) {
                String key = loot[i + 1];
                int value = Integer.parseInt(loot[i]);

                if (key.equals("shards") || key.equals("fragments") || key.equals("motes")) {

                    lootMap.put(key, lootMap.get(key) + value);
                } else {
                    junk.putIfAbsent(key, 0);
                    junk.put(key, junk.get(key) + value);
                }
                if (lootMap.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    lootMap.put("shards", lootMap.get("shards") - 250);
                    goal = true;
                    break;
                } else if (lootMap.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    lootMap.put("fragments", lootMap.get("fragments") - 250);
                    goal = true;
                    break;
                } else if (lootMap.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    lootMap.put("motes", lootMap.get("motes") - 250);
                    goal = true;
                    break;
                }
            }
            if (goal) {
                break;
            }
        }
        lootMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach( e -> {
            System.out.printf("%s: %d%n", e.getKey(), e.getValue());
                });

        for (Map.Entry<String, Integer> entry : junk.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}