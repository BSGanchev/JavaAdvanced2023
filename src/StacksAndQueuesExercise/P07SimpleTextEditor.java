package StacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        ArrayDeque<String> stack = new ArrayDeque<>();
        StringBuilder currentText = new StringBuilder();

        for (int i = 0; i <= n; i++) {
            String command = scanner.nextLine();

            if (command.startsWith("1")) {
                stack.push(currentText.toString());
                String forAppend = command.split("\\s+")[1];
                currentText.append(forAppend);
            }else if (command.startsWith("2")) {
                stack.push(currentText.toString());
                int count = Integer.parseInt(command.split("\\s+")[1]);
                int startIndex = currentText.length() - count;
                currentText.delete(startIndex, currentText.length());
            } else if (command.startsWith("3")) {
                int position = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(currentText.charAt(position - 1));
            }else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    String textForReturn = stack.pop();
                    currentText = new StringBuilder(textForReturn);
                }
            }
        }
    }
}
