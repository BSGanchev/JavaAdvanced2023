package Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (i == 0) {
                String name = input[0] + " " + input[1];
                Threeuple<String, String, String> threeupleOne =
                        new Threeuple<>(name, input[2], input[3]);
                System.out.println(threeupleOne);
            } else if (i == 1) {
                boolean drunk = input[2].equals("drunk");
                Threeuple<String, Integer, Boolean> threeupleTwo =
                        new Threeuple<>(input[0], Integer.parseInt(input[1]), drunk);
                System.out.println(threeupleTwo);
            } else {
                Threeuple<String, Double, String> threeupleThree =
                        new Threeuple<>(input[0], Double.parseDouble(input[1]), input[2]);
                System.out.println(threeupleThree);
            }
        }
    }
}
