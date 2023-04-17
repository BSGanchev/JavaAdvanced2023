package MultidimentionalArraysExercise;

import java.util.Scanner;

public class P02MatrixOfPalindromes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int x = Integer.parseInt(input.split(" ")[0]);
        int y = Integer.parseInt(input.split(" ")[1]);

        int[][] matrix = new int[x][y];


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                String current = getPalindrome(i, j);
                System.out.print(current + " ");

            }
            System.out.println();
        }
    }

    private static String getPalindrome(int x, int y) {
        StringBuilder palindrome = new StringBuilder();
            char first = (char) (97 + x);
            palindrome.append(first);
            char middle = (char) (first + y);
            palindrome.append(middle);
            palindrome.append(first);
        return palindrome.toString();
    }
}
