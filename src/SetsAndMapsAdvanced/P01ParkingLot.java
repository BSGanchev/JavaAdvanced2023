package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> parkingSet = new LinkedHashSet<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];
            if (direction.equals("IN")) {
                parkingSet.add(carNumber);
            } else if (direction.equals("OUT")) {
                parkingSet.remove(carNumber);
            }
            input = scanner.nextLine();
        }
        if (parkingSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car :
                    parkingSet) {
                System.out.println(car);
            }
        }
    }
}
