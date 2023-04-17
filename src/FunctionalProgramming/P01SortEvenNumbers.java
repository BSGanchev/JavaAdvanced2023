package FunctionalProgramming;

import java.util.*;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).filter(e -> e % 2 == 0).
                collect(Collectors.toList());

        print(integers);
        System.out.println();
        List<Integer> sortedNums = integers.stream().sorted().collect(Collectors.toList());
        print(sortedNums);
    }
    private static void print (List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print( list.get(i));
            if ( i < list.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
