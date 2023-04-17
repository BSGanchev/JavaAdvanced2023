package MultidimentionalArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        List<List<Integer>> matrix = new ArrayList<>();
        int element = 1;
        for (int i = 0; i < rows; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                matrix.get(i).add(element++);
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] input = command.split("\\s+");
            int targetRow = Integer.parseInt(input[0]);
            int targetCol = Integer.parseInt(input[1]);
            int radius = Integer.parseInt(input[2]);


            for (int i = targetCol + radius; i >= targetCol - radius; i--) {
                if (isInMatrix(matrix, targetRow, i)) {
                    matrix.get(targetRow).remove(i);
                }
            }
            for (int i = targetRow - radius; i <= targetRow + radius; i++) {
                if (isInMatrix(matrix, i, targetCol) && i != targetRow) {
                    matrix.get(i).remove(targetCol);
                }

            }
            matrix.removeIf(List::isEmpty);
            command = scanner.nextLine();
        }
        for (List<Integer> row : matrix) {
            for (int elements : row) {
                System.out.print(elements + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInMatrix(List<List<Integer>> matrix, int row, int col) {
        if (row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size()) {
            return true;
        } else {
            return false;
        }
    }
}
