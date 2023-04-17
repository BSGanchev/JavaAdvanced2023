package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> persons = new LinkedHashMap<>();

        while (n -- > 0) {
            String[] input = scanner.nextLine().split(", ");
            persons.put(input[0], Integer.parseInt(input[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filter = getPredicate(condition, age);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);

        persons.entrySet().stream().filter(e -> filter.test(e.getValue())).forEach(e -> print.accept(e));
    }

    private static Consumer<Map.Entry<String, Integer>> getPrintConsumer(String format) {
        if (format.equals("name")) {
            return e -> System.out.println(e.getKey());
        }else if (format.equals("age")) {
            return e-> System.out.println(e.getValue());
        }else {
            return e -> System.out.println(e.getKey() + " - " + e.getValue());
        }
    }

    private static Predicate<Integer> getPredicate(String condition, int age) {

        if(condition.equals("older")) {
            return  n -> n >= age;
        } else if (condition.equals("younger")) {
            return n -> n <= age;
        }
        return null;
    }
}
