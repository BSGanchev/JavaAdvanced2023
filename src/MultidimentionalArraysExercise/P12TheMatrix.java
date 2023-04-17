package MultidimentionalArraysExercise;

import java.util.Scanner;

public class P12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);

        char[][] matrix = new char[row][col];

        for (int i = 0; i < row; i++) {
            char[] fill = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            matrix[i] = fill;

        }
        char fillChar = scanner.nextLine().charAt(0);
        String[] startDimensions = scanner.nextLine().split("\\s+");
        int startRow = Integer.parseInt(startDimensions[0]);
        int startCol = Integer.parseInt(startDimensions[1]);

        char startChar = matrix[startRow][startCol];

        fill(matrix, startRow, startCol, fillChar, startChar);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fill(char[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar) {
            return;
        }
        matrix[row][col] = fillChar;
        if (row + 1 < matrix.length) {
            fill(matrix, row + 1, col, fillChar, startChar);
        }
        if (row - 1 >= 0) {
            fill(matrix, row - 1, col, fillChar, startChar);
        }
        if (col + 1 < matrix[row].length) {
            fill(matrix, row, col + 1, fillChar, startChar);
        }
        if (col - 1 >= 0) {
            fill(matrix, row, col - 1, fillChar, startChar);
        }
    }
}
