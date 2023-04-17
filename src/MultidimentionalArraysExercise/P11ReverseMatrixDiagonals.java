package MultidimentionalArraysExercise;

import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(dimensions[0]);
        int col = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] fill = scanner.nextLine().split("\\s+");
            matrix[i] = fill;

        }
        int rLimit = row - 1;
        int cLimit = col - 1;

        while (rLimit != -1) {
            int r = rLimit;
            int c = cLimit;
            while (c < col && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            cLimit--;
            if (cLimit == -1) {
                cLimit = 0;
                rLimit--;
            }
        }
    }
}
