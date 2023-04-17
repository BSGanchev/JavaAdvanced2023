package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, LinkedHashMap<String, Integer>> logsMap = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0].split("=")[1];
            String user = input.split("\\s+")[2].split("=")[1];

            if (!logsMap.containsKey(user)) {
                logsMap.put(user, new LinkedHashMap<>());
            }
            Map<String, Integer> ips = logsMap.get(user);
            if (!ips.containsKey(ip)) {
                ips.put(ip, 1);
            } else {
                ips.put(ip, ips.get(ip) + 1);
            }
            input = scanner.nextLine();
        }
        for (String users : logsMap.keySet()) {
            System.out.println(users + ": ");

            Map<String, Integer> ips = logsMap.get(users);

            int counter = ips.size();

            for (String s : ips.keySet()) {
                if (counter == 1) {
                    System.out.printf("%s => %d.%n", s, ips.get(s));
                } else {
                    System.out.printf("%s => %d, ", s, ips.get(s));
                }
                counter--;
            }
        }
    }
}
