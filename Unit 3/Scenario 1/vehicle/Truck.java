package vehicle;

public class Truck extends Vehicle implements Maintenance {
    private double loadCapacity;

    public Truck(String fuelType, int maxSpeed, double loadCapacity) {
        super(fuelType, maxSpeed);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    @Override
    public void drive() {
        System.out.println("The truck is driving with a heavy load at " + getMaxSpeed() + " km/h.");
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on the truck.");
    }
}
