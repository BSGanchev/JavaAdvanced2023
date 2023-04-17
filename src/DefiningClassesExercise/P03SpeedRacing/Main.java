package DefiningClassesExercise.P03SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String END = "End";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Car> carMap = new LinkedHashMap<>();

        while (count -- > 0) {
            String input = scanner.nextLine();
            String model = input.split("\\s+")[0];
            double fuelAmount = Double.parseDouble(input.split("\\s+")[1]);
            double fuelCostFor1km = Double.parseDouble(input.split("\\s+")[2]);

            Car car = new Car(model, fuelAmount, fuelCostFor1km);
            carMap.put(model, car);
        }
        String command = scanner.nextLine();
        while (!command.equals(END)) {
            String[] commands = command.split("\\s+");
            String model = commands[1];
            int amountOfKm = Integer.parseInt(commands[2]);

            Car carToDrive = carMap.get(model);
            if(!carToDrive.move(amountOfKm)) {

                System.out.println("Insufficient fuel for the drive");
            }

            command = scanner.nextLine();
        }
        for (Car car : carMap.values()) {
            System.out.print(car.toString());

        }

    }
}
