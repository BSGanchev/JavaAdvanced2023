package IteratorsAndComparatorsExercise.P02Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator iterator = null;


        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]) {
                case "Create":
                    iterator = new ListyIterator(Arrays.copyOfRange(tokens, 1, tokens.length));
                    break;
                case "Move":
                    if (iterator != null) {
                        System.out.println(iterator.Move());
                    }
                    break;
                case "Print":
                    try {
                        iterator.Print();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    if (iterator != null) {
                        System.out.println(iterator.hasNext());
                    }
                    break;
                case "PrintAll":
                    try {
                        iterator.PrintAll();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
            }
            input = scanner.nextLine();
        }
    }
}
