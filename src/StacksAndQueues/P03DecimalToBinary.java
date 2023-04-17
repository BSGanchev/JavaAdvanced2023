package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> result = new ArrayDeque<>();

        if (num == 0) {
            System.out.println(0);
        } else {
            while (num != 0) {
                result.push(num % 2);
                num /= 2;
            }
        }
        while (!result.isEmpty())
            System.out.print(result.pop());
    }
}
