package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class P03MaximumElement {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int n = scanner.nextInt();

        for (int i = 0; i <= n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    int number = Integer.parseInt(command[1]);
                    deque.push(number);
                    break;

                case "2":
                    if (!deque.isEmpty()) {
                        deque.pop();
                    }
                    break;
                case "3":
                    System.out.println(Collections.max(deque));
                    break;
            }

        }
    }
}
