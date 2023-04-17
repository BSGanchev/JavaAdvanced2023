package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            String[] input = scanner.nextLine().split("\\s+");
            if (i == 0) {
                String key = input[0] + " " + input[1];
                Tuple<String, String> tupleOne = new Tuple<>(key, input[2]);
                System.out.println(tupleOne);
            } else if (i == 1) {
                Tuple<String, Integer> tupleTwo = new Tuple<>(input[0], Integer.parseInt(input[1]));
                System.out.println(tupleTwo);
            } else {
                Tuple<Integer, Double> tupleThree = new Tuple<>(Integer.parseInt(input[0]),
                        Double.parseDouble(input[1]));
                System.out.println(tupleThree);
            }
        }
    }
}
