package MultidimentionalArrays;

import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String [][] matrix = new String[n][n];


        for (int i = 0; i < matrix.length; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = data[j];
            }
        }
        for (int x = 0; x < matrix.length; x++) {
            System.out.print(matrix[x][x] + " ");
        }
        System.out.println();
        for (int i = matrix.length - 1; i >= 0 ; i--) {
            System.out.print(matrix[i][matrix.length - i - 1] + " ");
        }
    }
}
