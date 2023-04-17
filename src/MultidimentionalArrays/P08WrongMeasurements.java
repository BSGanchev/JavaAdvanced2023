package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int matrix[][] = new int[n][];

        for (int i = 0; i < n; i++) {
            int row[] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        String[] coordinates = scanner.nextLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        int wrongValue = matrix[x][y];
        int[][] resultMatrix = new int[n][];

        for (int i = 0; i < n; i++) {
            resultMatrix[i] = matrix[i].clone();
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (resultMatrix[i][j] == wrongValue) {
                    resultMatrix[i][j] = adjacentSum(matrix, i, j, wrongValue);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int adjacentSum(int[][] inputMatrix, int i, int j, int wrongValue) {
        int sum = 0;

        if (i - 1 >= 0 && inputMatrix[i - 1][j] != wrongValue) {
            sum += inputMatrix[i - 1][j];
        }
        if (i + 1 < inputMatrix.length && inputMatrix[i + 1][j] != wrongValue) {
            sum += inputMatrix[i + 1][j];
        }
        if (j - 1 >= 0 && inputMatrix[i][j - 1] != wrongValue) {
            sum += inputMatrix[i][j - 1];
        }
        if (j + 1 < inputMatrix[i].length && inputMatrix[i][j + 1] != wrongValue) {
            sum += inputMatrix[i][j + 1];
        }


        return sum;
    }
}
