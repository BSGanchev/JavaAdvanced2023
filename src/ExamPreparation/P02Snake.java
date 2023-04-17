package ExamPreparation;


import java.util.Scanner;

public class P02Snake {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];

        int snakeRow = 0;
        int snakeCol = 0;

        for (int i = 0; i < size; i++) {
            String[] matrixFill = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                matrix[i][j] = matrixFill[j];
                if (matrix[i][j].equals("S")) {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }
        boolean crossBorder = false;
        int foodsEaten = 0;
        boolean burrow = false;


        while (!crossBorder) {
            String command = scanner.nextLine();
            if (burrow) {
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        if (matrix[i][j].equals("B")) {
                            matrix[i][j] = "S";
                            snakeRow = i;
                            snakeCol = j;
                        }
                    }
                }
                burrow = false;
            }

            switch (command) {
                case "left":
                    if (snakeCol - 1 < 0) {
                        crossBorder = true;
                        matrix[snakeRow][snakeCol] = ".";
                    } else {

                        matrix[snakeRow][snakeCol] = ".";
                        if (matrix[snakeRow][snakeCol - 1].equals("B")) {
                            burrow = true;
                            matrix[snakeRow][snakeCol - 1] = ".";
                            break;
                        } else if (matrix[snakeRow][snakeCol - 1].equals("*")) {
                            foodsEaten++;
                        }
                        matrix[snakeRow][snakeCol - 1] = "S";
                        snakeCol--;
                    }

                    break;

                case "right":
                    if (snakeCol + 1 == size) {
                        crossBorder = true;
                        matrix[snakeRow][snakeCol] = ".";
                    } else {
                        matrix[snakeRow][snakeCol] = ".";
                        if (matrix[snakeRow][snakeCol + 1].equals("B")) {
                            burrow = true;
                            matrix[snakeRow][snakeCol + 1] = ".";
                            break;
                        } else if (matrix[snakeRow][snakeCol + 1].equals("*")) {
                            foodsEaten++;
                        }
                        matrix[snakeRow][snakeCol + 1] = "S";
                        snakeCol++;
                    }
                    break;

                case "up":
                    if (snakeRow - 1 < 0) {
                        crossBorder = true;
                        matrix[snakeRow][snakeCol] = ".";
                    } else {
                        matrix[snakeRow][snakeCol] = ".";

                        if (matrix[snakeRow - 1][snakeCol].equals("B")) {
                            burrow = true;
                            matrix[snakeRow - 1][snakeCol] = ".";
                            break;
                        } else if (matrix[snakeRow - 1][snakeCol].equals("*")) {
                            foodsEaten++;
                        }
                        matrix[snakeRow - 1][snakeCol] = "S";
                        snakeRow--;
                    }
                    break;

                case "down":
                    if (snakeRow + 1 == size) {
                        crossBorder = true;
                        matrix[snakeRow][snakeCol] = ".";
                    } else {
                        matrix[snakeRow][snakeCol] = ".";
                        if (matrix[snakeRow + 1][snakeCol].equals("B")) {
                            burrow = true;
                            matrix[snakeRow + 1][snakeCol] = ".";
                            break;
                        } else if (matrix[snakeRow + 1][snakeCol].equals("*")) {
                            foodsEaten++;
                        }
                        matrix[snakeRow + 1][snakeCol] = "S";
                        snakeRow++;
                    }
                    break;

            }
            if (foodsEaten == 10) {
                break;
            }
        }
        if (crossBorder) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodsEaten);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
