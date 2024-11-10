package vehicle;

public class Car extends Vehicle implements Maintenance {
    private int numberOfDoors;

    public Car(String fuelType, int maxSpeed, int numberOfDoors) {
        super(fuelType, maxSpeed);  // Call base class constructor
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void drive() {
        System.out.println("The car is driving smoothly at a speed of " + getMaxSpeed() + " km/h.");
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on the car.");
    }
}