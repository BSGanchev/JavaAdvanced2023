package SetsAndMapsAdvanced;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, ArrayList<String>>> continentMap = new LinkedHashMap<>();

        while (count-- > 0) {
            String input = scanner.nextLine();
            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];

            if (!continentMap.containsKey(continent)) {
                continentMap.put(continent, new LinkedHashMap<>());
                if (!continentMap.get(continent).containsKey(country)) {
                    continentMap.get(continent).put(country, new ArrayList<>());
                    continentMap.get(continent).get(country).add(city);
                } else {
                    continentMap.get(continent).get(country).add(city);
                }
            } else {
                if (!continentMap.get(continent).containsKey(country)) {
                    continentMap.get(continent).put(country, new ArrayList<>());
                    continentMap.get(continent).get(country).add(city);
                } else {
                    continentMap.get(continent).get(country).add(city);
                }

            }
        }
        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> entry : continentMap.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());
            for (Map.Entry<String, ArrayList<String>> stringArrayListEntry : entry.getValue().entrySet()) {
                System.out.printf("  %s -> ", stringArrayListEntry.getKey());

                System.out.printf("%s %n", stringArrayListEntry.getValue().toString().replaceAll("[\\[\\]]", ""));

            }
        }
    }
}
