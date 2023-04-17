package MultidimentionalArraysExercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String method = input[1];
        int[][] matrix = new int[size][size];

        if (method.equals("A")) {
            methodA(matrix, size);
        } else if (method.equals("B")) {
            methodB(matrix, size);
        }
    }


    public static void methodA(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < matrix[i].length; k++) {
                    matrix[j][k] = j + (size * k) + 1;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void methodB(int[][] matrix, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < matrix[i].length; k++) {
                    if (k % 2 == 0) {
                        matrix[j][k] = j + (size * k) + 1;
                    } else {
                        matrix[j][k] = size * (k + 1) - j;

                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
