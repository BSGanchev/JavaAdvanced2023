package DefiningClassesExercise.P04RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Car>> carMap = new LinkedHashMap<>();

        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String carModel = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            double cargoWeight = Double.parseDouble(data[3]);
            String cargoType = data[4];

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tireList = new ArrayList<>();

            for (int i = 5; i <= 12; i += 2) {
                Tire tire = new Tire(Double.parseDouble(data[i]), Integer.parseInt(data[i + 1]));
                tireList.add(tire);
            }
            Car car = new Car(carModel, engine, cargo, tireList);

            if (!carMap.containsKey(cargoType)) {
                carMap.put(cargoType, new ArrayList<>());
                carMap.get(cargoType).add(car);
            } else {
                carMap.get(cargoType).add(car);
            }
        }
        String input = scanner.nextLine();

            carMap.get(input).forEach(entry -> entry.printCars(input));
    }
}
