package StacksAndQueues;

import java.util.*;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");

        List<String> inputList = (Arrays.asList(input));
        Collections.reverse(inputList);

        for (String current : inputList) {
            stack.push(current);
        }
        int result = 0;
        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (operation) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;
            }

            stack.push("" + result);
        }
        System.out.println(result);
    }
}
