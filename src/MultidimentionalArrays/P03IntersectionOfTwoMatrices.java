package MultidimentionalArrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrixA = new char[rows][cols];
        char[][] matrixB = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] split = scanner.nextLine().toCharArray();
            matrixA[i] = split;
        }
        for (int i = 0; i < rows; i++) {
            char[] split = scanner.nextLine().toCharArray();
            matrixB[i] = split;
        }
        char[][] matrixC = new char[matrixA.length][matrixA[0].length];
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[i].length; j++) {
                Character characterA = matrixA[i][j];
                Character characterB = matrixB[i][j];

                if (characterA.equals(characterB)) {
                    matrixC[i][j] = characterA;
                } else {
                    matrixC[i][j] = '*';
                }
            }
        }
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[i].length; j++) {
                System.out.print(matrixC[i][j]);
            }
            System.out.println();
        }
    }
}
