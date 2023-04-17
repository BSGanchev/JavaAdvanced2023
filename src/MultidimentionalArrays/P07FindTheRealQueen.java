package MultidimentionalArrays;

import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[8][8];

        for (int i = 0; i < matrix.length; i++) {
            String [] currentRow = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = currentRow[j].charAt(0);
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char currentElement = matrix[row][col];

                if (currentElement == 'q') {
                    if (rowCheck(matrix, row) && colCheck(matrix, col) && diagonalsOne(matrix, row, col)
                    && diagonalsTwo(matrix, row, col) && diagonalsTree(matrix, row, col) && diagonalsFour(matrix, row, col)) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }
    }

    public static boolean rowCheck(char[][] matrix, int row) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[row][i] == 'q') {
                count++;

            }
        }
        return count == 1;
    }

    public static boolean colCheck(char[][] matrix, int col) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == 'q') {
                count++;
            }

        }
        return count == 1;
    }

    public static boolean diagonalsOne(char[][] matrix, int row, int col) {
        row++;
        col--;
        while (row < 8 && col >= 0) {
            if (matrix[row++][col--] == 'q') {
                return false;
            }
        }
        return true;
    }

    public static boolean diagonalsTwo(char[][] matrix, int row, int col) {
        row--;
        col++;
        while (row >= 0 && col < 8) {
            if (matrix[row--][col++] == 'q') {
                return false;

            }
        }
        return true;
    }

    public static boolean diagonalsTree(char[][] matrix, int row, int col) {
        row++;
        col++;
        while (row < 8 && col < 8) {
            if (matrix[row++][col++] == 'q') {
                return false;
            }
        }
        return true;
    }

    public static boolean diagonalsFour(char[][] matrix, int row, int col) {
        row--;
        col--;
        while (row >= 0 && col >= 0) {
            if (matrix[row--][col--] == 'q') {
                return false;
            }
        }
        return true;
    }
}
