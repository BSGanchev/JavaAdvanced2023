package MultidimentionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = currentRow;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                int sum =   matrix[i][j] + matrix[i + 1][j] + matrix[i + 2][j] +
                            matrix[i][j + 1] + matrix[i + 1][j + 1] + matrix[i + 2][j + 1] +
                            matrix[i][j + 2] + matrix[i + 1][j + 2] + matrix[i + 2][j + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = maxRow; i <= maxRow + 2; i++) {
            for (int j = maxCol; j <= maxCol + 2; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();

        }

    }
}
