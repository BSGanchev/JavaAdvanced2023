package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            deque.push(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            deque.pop();
        }

        if (deque.contains(x)) {
            System.out.println("true");
        } else {
            if (deque.isEmpty()) {
                System.out.println("0");
            } else {
                System.out.println(Collections.min(deque));
            }
        }
    }
}
