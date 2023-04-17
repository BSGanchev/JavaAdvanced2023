package MultidimentionalArraysExercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P10RadioactiveMutantVampireBunnies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimension = scanner.nextLine();
        int rows = Integer.parseInt(dimension.split("\\s+")[0]);
        int cols = Integer.parseInt(dimension.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        int playerRow = 0;
        int playerCol = 0;

        for (int i = 0; i < rows; i++) {
            String[] inputs = scanner.nextLine().split("");
            for (int j = 0; j < cols; j++) {

                if (inputs[j].equals("P")) {
                    playerRow = i;
                    playerCol = j;
                    matrix[i][j] = inputs[j];
                } else {
                    matrix[i][j] = inputs[j];
                }
            }
        }

        String[] moves = scanner.nextLine().split("");
        ArrayDeque<String> movesStack = new ArrayDeque<>();
        Collections.addAll(movesStack, moves);

        boolean bunnie = false;
        boolean win = false;

        while (!movesStack.isEmpty()) {
            String currentMove = movesStack.pop();
            switch (currentMove) {
                case "U":
                    if (playerRow - 1 < 0) {
                        win = true;
                        matrix[playerRow][playerCol] = ".";
                    } else {
                        if (matrix[playerRow - 1][playerCol].equals(".")) {
                            matrix[playerRow - 1][playerCol] = "P";
                            matrix[playerRow][playerCol] = ".";
                            playerRow--;
                        } else {
                            bunnie = true;
                            matrix[playerRow][playerCol] = ".";
                            playerRow--;
                        }
                    }
                    break;
                case "D":
                    if (playerRow + 1 == rows) {
                        win = true;
                        matrix[playerRow][playerCol] = ".";
                    } else {
                        if (matrix[playerRow + 1][playerCol].equals(".")) {
                            matrix[playerRow + 1][playerCol] = "P";
                            matrix[playerRow][playerCol] = ".";
                            playerRow++;
                        } else {
                            bunnie = true;
                            matrix[playerRow][playerCol] = ".";
                            playerRow++;
                        }
                    }
                    break;
                case "L":
                    if (playerCol - 1 < 0) {
                        win = true;
                        matrix[playerRow][playerCol] = ".";
                    } else {
                        if (matrix[playerRow][playerCol - 1].equals(".")) {
                            matrix[playerRow][playerCol - 1] = "P";
                            matrix[playerRow][playerCol] = ".";
                            playerCol--;
                        } else {
                            bunnie = true;
                            matrix[playerRow][playerCol] = ".";
                            playerCol--;
                        }
                    }
                    break;
                case "R":
                    if (playerCol + 1 == cols) {
                        win = true;
                        matrix[playerRow][playerCol] = ".";
                    } else {
                        if (matrix[playerRow][playerCol + 1].equals(".")) {
                            matrix[playerRow][playerCol + 1] = "P";
                            matrix[playerRow][playerCol] = ".";
                            playerCol++;
                        } else {
                            bunnie = true;
                            matrix[playerRow][playerCol] = ".";
                            playerCol++;
                        }
                    }
                    break;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j].equals("B")) {
                        if (i - 1 >= 0) {
                            if (matrix[i - 1][j].equals("P")) {
                                bunnie = true;
                                matrix[i - 1][j] = "N";
                            } else if (matrix[i - 1][j].equals(".")) {
                                matrix[i - 1][j] = "N";
                            }
                        }
                        if (i + 1 < matrix.length) {
                            if (matrix[i + 1][j].equals("P")) {
                                bunnie = true;
                                matrix[i + 1][j] = "N";
                            } else if (matrix[i + 1][j].equals(".")) {
                                matrix[i + 1][j] = "N";
                            }
                        }
                        if (j - 1 >= 0) {
                            if (matrix[i][j - 1].equals("P")) {
                                bunnie = true;
                                matrix[i][j - 1] = "N";
                            } else if (matrix[i][j - 1].equals(".")) {
                                matrix[i][j - 1] = "N";
                            }
                        }
                        if (j + 1 < matrix[i].length) {
                            if (matrix[i][j + 1].equals("P")) {
                                bunnie = true;
                                matrix[i][j + 1] = "N";
                            } else if (matrix[i][j + 1].equals(".")) {
                                matrix[i][j + 1] = "N";
                            }
                        }
                    }
                }
            }
            matrix = refill(matrix);
            if (bunnie) {
                visualiseMatrix(matrix);
                System.out.printf("dead: %d %d", playerRow, playerCol);
                break;
            } else if (win) {
                visualiseMatrix(matrix);
                System.out.printf("won: %d %d", playerRow, playerCol);
                break;

            }
        }
    }

    private static void visualiseMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static String[][] refill(String[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("N")) {
                    matrix[i][j] = "B";
                }
            }
        }
        return matrix;
    }
}