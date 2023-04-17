package MultidimentionalArraysExercise;

import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");

        boolean[][] matrix = new boolean[Integer.parseInt(dimension[0])][Integer.parseInt(dimension[1])];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = true;
        }

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            String[] inputParts = input.split("\\s+");
            int entryRow = Integer.parseInt(inputParts[0]);
            int row = Integer.parseInt(inputParts[1]);
            int col = Integer.parseInt(inputParts[2]);

            boolean placeFound = false;
            int distanceTraveled = 1;
            distanceTraveled += Math.abs(row - entryRow);

            if(!matrix[row][col]) {
                distanceTraveled += col;
                matrix[row][col] = true;
                placeFound = true;
            } else {
                for (int i = 1; i < matrix[row].length && !placeFound; i++) {
                    if (col - i > 0 && !matrix[row][col - i]) {
                        matrix[row][col - i] = true;
                        placeFound = true;
                        distanceTraveled += col - i;
                    }
                    if (!placeFound && col + i < matrix[row].length && !matrix[row][col + i]) {
                        matrix[row][col + i] = true;
                        placeFound = true;
                        distanceTraveled += i + col;
                    }
                }
            }

            if(placeFound){
                System.out.println(distanceTraveled);
            }else {
                System.out.printf("Row %d full%n", row);
            }

            input = scanner.nextLine();
        }
    }
}
