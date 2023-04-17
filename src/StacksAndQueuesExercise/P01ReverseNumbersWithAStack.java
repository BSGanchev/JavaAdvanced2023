package StacksAndQueuesExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        String input = scanner.nextLine();
        List<Integer> numbers = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numbers);

        deque.addAll(numbers);
        int n = deque.size();
        for (int i = 0; i < n; i++) {

            System.out.print(deque.pop() + " ");
        }

    }
}
