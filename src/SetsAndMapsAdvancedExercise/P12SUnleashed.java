package SetsAndMapsAdvancedExercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12SUnleashed {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("^(?<name>[A-Za-z ]+) @(?<beach>[A-Za-z ]+) (?<price>[0-9]+) (?<amount>[0-9]+)");
        Map<String, LinkedHashMap<String, Integer>> unleashedMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                String name = matcher.group("name");
                String beach = matcher.group("beach");
                int price = Integer.parseInt(matcher.group("price"));
                int amount = Integer.parseInt(matcher.group("amount"));

                if (!unleashedMap.containsKey(beach)) {
                    unleashedMap.put(beach, new LinkedHashMap<>());
                    if (!unleashedMap.get(beach).containsKey(name)) {

                        unleashedMap.get(beach).put(name, amount * price);
                    } else {
                        unleashedMap.get(beach).put(name, unleashedMap.get(beach).get(name) + (amount * price));
                    }
                } else {
                    if (!unleashedMap.get(beach).containsKey(name)) {
                        unleashedMap.get(beach).put(name, amount * price);
                    } else {
                        unleashedMap.get(beach).put(name, unleashedMap.get(beach).get(name) + (amount * price));
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : unleashedMap.entrySet()) {
            System.out.printf("%s%n", entry.getKey());

            entry.getValue().entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> {
                System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue());
            });
        }
    }
}
