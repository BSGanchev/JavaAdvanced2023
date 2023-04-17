package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sizes = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] current = scanner.nextLine().split(", ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(current[j]);
            }

        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);

        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
            }
        }
        System.out.println(sum);
    }
}
