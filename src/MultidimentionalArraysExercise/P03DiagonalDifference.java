package MultidimentionalArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];

        for (int i = 0; i < n; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = numbers;
        }
        int result = Math.abs(getLeftDiagonal(matrix, n) - getRightDiagonal(matrix, n));

        System.out.println(result);
    }

    private static int getLeftDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int getRightDiagonal(int[][] matrix, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][size - 1 - i];
        }
        return sum;
    }
}
