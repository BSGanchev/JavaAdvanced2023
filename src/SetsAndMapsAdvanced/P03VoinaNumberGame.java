package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> playerOne = new LinkedHashSet<>();
        Set<Integer> playerTwo = new LinkedHashSet<>();

        String[] inputOne = scanner.nextLine().split("\\s+");
        String[] inputTwo = scanner.nextLine().split("\\s+");

        for (int i = 0; i < inputOne.length; i++) {
            playerOne.add(Integer.parseInt(inputOne[i]));
        }
        for (int i = 0; i < inputTwo.length; i++) {
            playerTwo.add(Integer.parseInt(inputTwo[i]));
        }

        for (int i = 0; i < 50; i++) {
            int playerOneNum = playerOne.iterator().next();
            playerOne.remove(playerOneNum);
            int playerTwoNum = playerTwo.iterator().next();
            playerTwo.remove(playerTwoNum);

            if (playerOneNum > playerTwoNum) {
                playerOne.add(playerOneNum);
                playerOne.add(playerTwoNum);
            } else if (playerOneNum < playerTwoNum) {
                playerTwo.add(playerOneNum);
                playerTwo.add(playerTwoNum);
            }
            if (playerOne.isEmpty()) {
                System.out.println("First player win!");
                break;
            } else if (playerTwo.isEmpty()) {
                System.out.println("Second player win!");
                break;
            }
        }
        if (playerOne.size() > playerTwo.size()) {
            System.out.println("First player win!");
        } else if (playerOne.size() < playerTwo.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
