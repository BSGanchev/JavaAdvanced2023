package MultidimentionalArraysExercise;

import java.util.Scanner;

public class P08TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heiganPoints = 3000000.0;
        int playerPoints = 18500;

        int startRow = 7;
        int startCol = 7;

        String lastSpell = "";
        boolean cloud = false;

        double damage = Double.parseDouble(scanner.nextLine());

        while (playerPoints > 0 && heiganPoints > 0) {
            heiganPoints -= damage;

            if (cloud) {
                playerPoints -= 3500;
                cloud = false;

                if (playerPoints < 0) {
                    break;
                }
            }
            if (heiganPoints < 0) {
                break;
            }

            String[] input = scanner.nextLine().split("\\s+");
            String spell = input[0];

            int row = Integer.parseInt(input[1]);
            int col = Integer.parseInt(input[2]);

            boolean[][] chamber = new boolean[15][15];

            for (int i = row - 1; i <= row + 1; i++) {
                if (i >= 0 && i < chamber.length) {
                    for (int j = col - 1; j <= col + 1; j++) {
                        if (j >= 0 && j < chamber[row].length) {
                            chamber[i][j] = true;
                        }
                    }
                }
            }
            if (chamber[startRow][startCol]) {
                if (rowIsValid(chamber, startRow - 1) && !chamber[startRow - 1][startCol]) {
                    startRow--;
                } else if (colIsValid(chamber, startCol + 1) && !chamber[startRow][startCol + 1]) {
                    startCol++;
                } else if (rowIsValid(chamber, startRow + 1) && !chamber[startRow + 1][startCol]) {
                    startRow++;
                } else if (colIsValid(chamber, startCol - 1) && !chamber[startRow][startCol - 1]) {
                    startCol--;
                }
                if (chamber[startRow][startCol]) {
                    switch (spell) {
                        case "Cloud":
                            playerPoints -= 3500;
                            cloud = true;
                            lastSpell = "Plague Cloud";
                            break;
                        case "Eruption":
                            playerPoints -= 6000;
                            lastSpell = spell;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + spell);
                    }
                }
            }
        }
        if (heiganPoints > 0) {
            System.out.printf("Heigan: %.2f%n", heiganPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerPoints > 0) {
            System.out.printf("Player: %d%n", playerPoints);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }

        System.out.println("Final position: " + startRow + ", " + startCol);
    }

    private static boolean colIsValid(boolean[][] chamber, int startCol) {
        return startCol >= 0 && startCol < chamber.length;
    }

    private static boolean rowIsValid(boolean[][] chamber, int startRow) {
        return startRow >= 0 && startRow < chamber[startRow].length;
    }

}
