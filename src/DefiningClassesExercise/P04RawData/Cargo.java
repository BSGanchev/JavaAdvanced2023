package DefiningClassesExercise.P04RawData;

public class Cargo {
    private double cargoWeight;
    private String cargoType;

    public Cargo(double cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    public double getCargoWeight() {
        return cargoWeight;
    }

    public String getCargoType() {
        return cargoType;
    }
}
