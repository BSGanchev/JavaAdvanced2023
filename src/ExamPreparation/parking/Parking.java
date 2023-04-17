package ExamPreparation.parking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

public class Parking {

    private String type;
    private int capacity;

    private Collection<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>(capacity);
    }


    public void add(Car car) {

        if (this.getCount() >= this.getCapacity()) {
            return;
        }
        this.data.add(car);
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {

        return this.data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }
    public Car getCar(String manufacturer, String model) {

        return this.data.stream().filter(e -> e.getModel().equals(model) && e.getManufacturer().equals(manufacturer)).findFirst().orElse(null);

    }

    public int getCount() {

        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder statistic = new StringBuilder();
        statistic.append(String.format("The car parked in %s ExamPreparation.parking garage:", this.type)).append(System.lineSeparator());
        this.data.forEach(e -> {
            statistic.append(e).append(System.lineSeparator());
        });
        return statistic.toString().trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Collection<Car> getData() {
        return data;
    }

    public void setData(Collection<Car> data) {
        this.data = data;
    }
}
