package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> plantsStack = new ArrayDeque<>();
        int[] days = new int[plants.length];
        plantsStack.push(0);

        for (int i = 0; i < plants.length; i++) {
            int maxDays = 0;
            while (plantsStack.size() > 0 && plants[plantsStack.peek()] >= plants[i]) {
                maxDays = Integer.max(days[plantsStack.pop()], maxDays);
            }

            if (plantsStack.size() > 0) {
                days[i] = maxDays + 1;
            }

            plantsStack.push(i);

        }
        System.out.printf("%d", Arrays.stream(days).max().getAsInt());
    }
}
