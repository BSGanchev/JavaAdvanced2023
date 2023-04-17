package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstMatrixRows = dimension[0];
        int firstMatrixCols = dimension[1];

        int[][] firstMatrix = new int[firstMatrixRows][firstMatrixCols];
        for (int i = 0; i < firstMatrixRows; i++) {
            int[] unit = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = unit;
        }
        dimension = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int secondMatrixRows = dimension[0];
        int secondMatrixCols = dimension[1];

        int[][] secondMatrix = new int[secondMatrixRows][secondMatrixCols];
        for (int i = 0; i < secondMatrixRows; i++) {
            int[] unit = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = unit;
        }

        if (equals(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static boolean equals(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int i = 0; i < firstMatrix.length; i++) {
            if (firstMatrix[i].length != secondMatrix[i].length) {
                return false;
            }
            for (int j = 0; j < firstMatrix[i].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }

            }

        }
        return true;
    }
}
