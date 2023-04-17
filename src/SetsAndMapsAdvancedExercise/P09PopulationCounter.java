package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Long>> populationMap = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("report")) {
            String country = input.split("\\|")[1];
            String city = input.split("\\|")[0];
            Long population = Long.parseLong(input.split("\\|")[2]);

            if (!populationMap.containsKey(country)) {
                populationMap.put(country, new LinkedHashMap<>());
                populationMap.get(country).put(city, population);
            } else {
                populationMap.get(country).put(city, population);
            }
            input = scanner.nextLine();
        }
        populationMap.entrySet().stream().sorted((c1, c2) -> {
            Long firstPop = populationMap.get(c1.getKey()).values().stream().mapToLong(l -> l).sum();
            Long secondPop = populationMap.get(c2.getKey()).values().stream().mapToLong(l -> l).sum();
            return Long.compare(secondPop, firstPop);
        }).forEach(entry -> {
            System.out.print(entry.getKey() + " ");
            StringBuilder builder = new StringBuilder();

            AtomicReference<Long> totalPop = new AtomicReference<>((long) 0);

            populationMap.get(entry.getKey()).entrySet().stream().sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue())).forEach(c -> {
                builder.append(String.format("=>%s: %d%n", c.getKey(), c.getValue()));
                totalPop.updateAndGet(e -> e + c.getValue());
            });

            System.out.printf("(total population: %s)%n", totalPop.toString());
            System.out.print(builder.toString());


        });
    }
}
