package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class P04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Double> parseDouble = e -> Double.parseDouble(e);
        UnaryOperator<Double> addVat = d -> d * 1.2;
        Consumer<Double> print = e -> System.out.printf("%.2f%n", e);

        List<Double> doubleList = Arrays.stream(scanner.nextLine().split(", ")).map(e -> parseDouble.apply(e))
                .map(e -> addVat.apply(e)).collect(Collectors.toList());
        System.out.println("Prices with VAT:");
        doubleList.forEach(e -> print.accept(e));
    }
}
