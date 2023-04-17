package DefiningClassesExercise.P05CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int enginesCount = Integer.parseInt(scanner.nextLine());

        List<Engine> engineList = new ArrayList<>();

        while (enginesCount-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String engineModel = input[0];
            int enginePower = Integer.parseInt(input[1]);
            int engineDisplacement = 0;
            String engineEfficiency = null;
            if (input.length == 4) {
                engineDisplacement = Integer.parseInt(input[2]);
                engineEfficiency = input[3];
            } else if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    engineDisplacement = Integer.parseInt(input[2]);
                } else {
                    engineEfficiency = input[2];
                }
            }
            Engine engine = new Engine(engineModel, enginePower, engineDisplacement, engineEfficiency);
            engineList.add(engine);
        }
        int carsCount = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        while (carsCount-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String carModel = input[0];
            String carEngine = input[1];
            int carWeight = 0;
            String carColor = null;
            if (input.length == 4) {
                carWeight = Integer.parseInt(input[2]);
                carColor = input[3];
            } else if (input.length == 3) {
                if (Character.isDigit(input[2].charAt(0))) {
                    carWeight = Integer.parseInt(input[2]);
                } else {
                    carColor = input[2];
                }
            }
            Engine currentEngine = null;
            for (Engine engine : engineList) {
                if (engine.getModel().equals(carEngine)) {
                    currentEngine = engine;
                    break;
                }
            }
            Car car = new Car(carModel, currentEngine, carWeight, carColor);
            carList.add(car);
        }

        for (Car car : carList) {
            System.out.print(car.toString());
        }
    }
}
