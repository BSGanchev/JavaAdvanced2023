package DefiningClassesExercise.P04RawData;

import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tireList;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tireList) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tireList = tireList;
    }

    public void printCars(String input) {
        switch (input) {
            case "flamable":
                if (engine.getEnginePower() > 250) {
                    System.out.println(model);
                }
                break;
            case "fragile":
                for (Tire tire : tireList) {
                    if(tire.getPressure() < 1) {
                        System.out.println(model);
                    }
                    break;
                }
        }
    }
}
