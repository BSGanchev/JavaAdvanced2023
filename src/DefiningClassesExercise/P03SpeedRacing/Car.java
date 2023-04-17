package DefiningClassesExercise.P03SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double FuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        FuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }
    public boolean move(int amountOfKm) {
        double neededFuel = amountOfKm * this.FuelCostFor1km;
        if (neededFuel <= this.fuelAmount) {
            this.fuelAmount -= neededFuel;
            this.distanceTraveled += amountOfKm;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d%n", model, fuelAmount, distanceTraveled);
    }
}
