package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> filenames = new ArrayDeque<>();

        String command = scanner.nextLine();

        while (!command.equals("print")) {
            if (command.equals("cancel")) {
                if (filenames.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    String canceledFile = filenames.poll();
                    System.out.println("Canceled " + canceledFile);
                }

            } else {
                filenames.offer(command);
            }

            command = scanner.nextLine();
        }
        while (!filenames.isEmpty()) {
            System.out.println(filenames.poll());
        }
    }
}
