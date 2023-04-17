package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> forwarded = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("Home")) {
            switch (input) {
                case "back":
                    if (history.size() == 1 || history.isEmpty()) {
                        System.out.println("no previous URLs");
                        input = scanner.nextLine();
                        continue;
                    }
                    forwarded.push(history.peek());
                    history.pop();
                    System.out.println(history.peek());
                    break;
                case "forward":
                    if (forwarded.isEmpty()) {
                        System.out.println("no next URLs");
                        input = scanner.nextLine();
                        continue;
                    }
                    System.out.println(forwarded.peek());
                    history.push(forwarded.peek());
                    forwarded.pop();
                    break;
                default:
                    history.push(input);
                    System.out.println(history.peek());
                    forwarded.clear();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
