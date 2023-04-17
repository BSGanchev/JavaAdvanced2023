package SetsAndMapsAdvancedExercise;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> cardsMap = new LinkedHashMap<>();
        String command = scanner.nextLine();
        while (!command.equals("JOKER")) {
            String name = command.split(": ")[0];
            String cards = command.split(": ")[1];
            String[] cardsArray = cards.split(", ");

            Set<String> cardsSet = new HashSet<>();
            cardsSet.addAll(Arrays.asList(cardsArray));

            if (!cardsMap.containsKey(name)) {
                cardsMap.put(name, cardsSet);
            } else {
                Set<String> currentCardsSet = cardsMap.get(name);
                currentCardsSet.addAll(Arrays.asList(cardsArray));
                cardsMap.put(name, currentCardsSet);
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> entry : cardsMap.entrySet()) {
            String name = entry.getKey();
            Set<String> cardsSet = entry.getValue();
            int points = getPoints(cardsSet);

            System.out.printf("%s: %d%n", name, points);
        }
    }

    private static int getPoints(Set<String> cardsSet) {
        Map<Character, Integer> pointsMap = getPointsFromChars();
        int sum = 0;
        for (String card : cardsSet) {
            int points = 0;
            if (card.startsWith("10")) {
                char T = card.charAt(2);
                points = 10 * pointsMap.get(T);
            } else {
                char P = card.charAt(0);
                char T = card.charAt(1);
                points = pointsMap.get(P) * pointsMap.get(T);
            }
            sum += points;
        }
        return sum;
    }

    private static Map<Character, Integer> getPointsFromChars() {

        Map<Character, Integer> points = new HashMap<>();
        points.put('2', 2);
        points.put('3', 3);
        points.put('4', 4);
        points.put('5', 5);
        points.put('6', 6);
        points.put('7', 7);
        points.put('8', 8);
        points.put('9', 9);
        points.put('J', 11);
        points.put('Q', 12);
        points.put('K', 13);
        points.put('A', 14);
        points.put('S', 4);
        points.put('H', 3);
        points.put('D', 2);
        points.put('C', 1);
        return points;
    }
}
