package MultidimentionalArraysExercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimensions = scanner.nextLine().split("\\s+");
        int matrixRow = Integer.parseInt(dimensions[0]);
        int matrixCol = Integer.parseInt(dimensions[1]);

        String[][] matrix = new String[matrixRow][matrixCol];

        for (int i = 0; i < matrixRow; i++) {
            String[] matrixContent = scanner.nextLine().split("\\s+");
            matrix[i] = matrixContent;

        }

        String[][] resultMatrix = new String[matrixRow][matrixCol];
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] input = command.split("\\s+");
            if (command.contains("swap")) {
                try {
                    int x1 = Integer.parseInt(input[1]);
                    int y1 = Integer.parseInt(input[2]);
                    int x2 = Integer.parseInt(input[3]);
                    int y2 = Integer.parseInt(input[4]);

                    resultMatrix = result(matrix, x1, y1, x2, y2);
                    for (int i = 0; i < matrixRow; i++) {
                        for (int j = 0; j < matrixCol; j++) {
                            System.out.print(resultMatrix[i][j] + " ");
                        }
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }


            command = scanner.nextLine();
        }
    }

    private static String[][] result(String[][] matrix, int x1, int y1, int x2, int y2) {
        String memory = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = memory;
        return matrix;
    }
}
