package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Set<String> guestSet = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            guestSet.add(input);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")){
            guestSet.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(guestSet.size());

        guestSet.forEach(System.out::println);
    }
}
