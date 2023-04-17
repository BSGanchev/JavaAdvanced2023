package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean balanced = false;

        for (char bracket :
                input.toCharArray()) {
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                stack.push(bracket);
            } else if (bracket == '}' || bracket == ']' || bracket == ')') {
                if (stack.isEmpty()) {
                    balanced = false;
                    break;
                }
                    char lastBracket = stack.pop();
                if (lastBracket == '{' && bracket == '}') {
                    balanced = true;
                } else if (lastBracket == '[' && bracket == ']') {
                    balanced = true;
                } else if (lastBracket == '(' && bracket == ')') {
                    balanced = true;
                } else {
                    balanced = false;
                    break;
                }
            }

        }
        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
