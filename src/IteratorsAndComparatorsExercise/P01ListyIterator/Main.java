package IteratorsAndComparatorsExercise.P01ListyIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListyIterator listyIterator = null;
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            switch (tokens[0]){
                case "Create":
                    listyIterator = new ListyIterator(Arrays.copyOfRange(tokens, 1, tokens.length));
                    break;
                case "Move":
                    if (listyIterator != null) {
                        System.out.println(listyIterator.Move());
                    }
                    break;
                case "Print":
                    try {
                        listyIterator.Print();
                    } catch (NullPointerException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "HasNext":
                    if (listyIterator != null) {
                        System.out.println(listyIterator.hasNext());
                    }
                    break;


            }
            input = scanner.nextLine();
        }

    }
}
