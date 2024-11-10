package vehicle;

public class Bus extends Vehicle implements Maintenance {
    private int passengerCapacity;

    public Bus(String fuelType, int maxSpeed, int passengerCapacity) {
        super(fuelType, maxSpeed);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public void drive() {
        System.out.println("The bus is driving with passengers at a moderate speed of " + getMaxSpeed() + " km/h.");
    }

    @Override
    public void performMaintenance() {
        System.out.println("Performing maintenance on the bus.");
    }
}
