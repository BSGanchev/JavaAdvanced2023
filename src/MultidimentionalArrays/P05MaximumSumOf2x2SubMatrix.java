package MultidimentionalArrays;

import java.util.Scanner;

public class P05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            String[] columnData = scanner.nextLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(columnData[col]);
            }
        }
        int maxSum = Integer.MIN_VALUE;

        int x = 0;
        int y = 0;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int k = 0; k < matrix[i].length - 1; k++) {
                int sum = matrix[i][k] + matrix[i][k + 1] + matrix[i + 1][k] + matrix[i + 1][k + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    x = i;
                    y = k;

                }
            }
        }
        System.out.println(matrix[x][y] + " " + matrix[x][y + 1] + System.lineSeparator() + matrix[x + 1][y] + " " + matrix[x + 1][y + 1]);
        System.out.println(maxSum);
    }
}
