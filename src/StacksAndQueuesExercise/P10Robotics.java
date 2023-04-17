package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");

        LinkedHashMap<String, Integer> robotsData = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> workingTime = new LinkedHashMap<>();
        for (String currentRobot :
                input) {
            String name = currentRobot.split("-")[0];

            workingTime.put(name, 0);
        }

        for (int i = 0; i < input.length; i++) {
            String robotName = input[i].split("-")[0];
            int processTime = Integer.parseInt(input[i].split("-")[1]);

            robotsData.put(robotName, processTime);
        }
        String time = scanner.nextLine();
        int startInSeconds = getStartTimeInSecond(time);

        ArrayDeque<String> products = new ArrayDeque<>();
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            products.offer(product);
            product = scanner.nextLine();
        }

        while (!products.isEmpty()) {
            String current = products.poll();
            startInSeconds++;

            for (Map.Entry<String, Integer> entry : workingTime.entrySet()) {
                if (entry.getValue() > 0) {
                    workingTime.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            boolean taken = false;

            for (Map.Entry<String, Integer> entry : workingTime.entrySet()) {
                if (entry.getValue() == 0) {
                    System.out.println(entry.getKey() + " - " + current + " [" + getStartTimeInHours(startInSeconds) + "]");
                    workingTime.put(entry.getKey(), robotsData.get(entry.getKey()));
                    taken = true;
                    break;
                }
            }
            if (!taken) {
                products.offer(current);
            }


        }
    }

    private static int getStartTimeInSecond(String time) {
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        int seconds = Integer.parseInt(time.split(":")[2]);

        return hours * 3600 + minutes * 60 + seconds;


    }

    private static String getStartTimeInHours(int time) {
        int hours = (time / 3600) % 24;
        int minutes = time % 3600 / 60;
        int seconds = time % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);

    }
}
