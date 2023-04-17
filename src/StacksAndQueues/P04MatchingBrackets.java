package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char currentCh = input.charAt(i);
            if (currentCh == '(') {
                indexes.push(i);

            } else if (currentCh == ')') {
                int openIndex = indexes.pop();
                String result = input.substring(openIndex, i + 1);

                System.out.println(result);
            }
        }
    }
}
