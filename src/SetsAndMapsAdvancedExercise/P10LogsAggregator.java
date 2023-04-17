package SetsAndMapsAdvancedExercise;

import java.util.*;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> usersDuration = new TreeMap<>();
        Map<String, List<String>> usersIP = new HashMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        while (count -- > 0) {

            String input = scanner.nextLine();
            String username = input.split("\\s+")[1];
            int duration = Integer.parseInt(input.split("\\s+")[2]);
            String ip = input.split("\\s+")[0];

            if (!usersDuration.containsKey(username)) {
                usersDuration.put(username, duration);
                usersIP.put(username, new ArrayList<>());
                usersIP.get(username).add(ip);
            }else {
                usersDuration.put(username, usersDuration.get(username) + duration);
                if (!usersIP.get(username).contains(ip)) {
                    usersIP.get(username).add(ip);
                }
            }
        }
        for (Map.Entry<String, List<String>> entry : usersIP.entrySet()) {
            Collections.sort(entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : usersDuration.entrySet()) {
            System.out.printf("%s: %d %s%n", entry.getKey(), entry.getValue(), usersIP.get(entry.getKey()));
        }

    }
}
