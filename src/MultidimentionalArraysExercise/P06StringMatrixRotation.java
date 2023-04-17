package MultidimentionalArraysExercise;

import java.util.ArrayList;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotation = scanner.nextLine();
        int angle = Integer.parseInt(rotation.split("[()+]")[1]) % 360;

        ArrayList<String> matrixContent = new ArrayList<>();

        int maxLength = 0;

        while (true) {
            String matrixContentLine = scanner.nextLine();
            if (matrixContentLine.equals("END")) {
                break;
            }
            matrixContent.add(matrixContentLine);
            if (matrixContentLine.length() > maxLength) {
                maxLength = matrixContentLine.length();
            }
        }
        int row = matrixContent.size();
        int col = maxLength;

        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j < matrixContent.get(i).length()) {
                    matrix[i][j] = matrixContent.get(i).charAt(j);
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        matrixRotate(angle, row, col, matrix);
    }

    private static void matrixRotate(int angle, int row, int col, char[][] matrix) {

        if (angle == 90) {
            for (int i = 0; i < col; i++) {
                for (int j = row - 1; j >= 0; j--) {
                    System.out.print(matrix[j][i]);
                }
                System.out.println();
            }
        } else if (angle == 180) {
            for (int i = row - 1; i >= 0; i--) {
                for (int j = col - 1; j >= 0; j--) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else if (angle == 270) {
            for (int j = col - 1; j >= 0; j--) {
                for (int i = 0; i < row; i++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }
    }
}
