package vehicle;

public class Vehicle {
    private String fuelType;
    private int maxSpeed;

    public Vehicle(String fuelType, int maxSpeed) {
        this.fuelType = fuelType;
        this.maxSpeed = maxSpeed;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void drive() {
        System.out.println("The vehicle is driving at a speed of " + maxSpeed + " km/h.");
    }

    public void refuel() {
        System.out.println("The vehicle is being refueled with " + fuelType + ".");
    }
}
