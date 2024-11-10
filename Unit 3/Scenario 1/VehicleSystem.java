import vehicle.*;

class VehicleSystem {

    public static void main(String[] args) {
        Car car = new Car("Petrol", 200, 4);
        car.drive();
        car.refuel();
        car.performMaintenance();
        System.err.println("--------------------------------------\n");
        
        Truck truck = new Truck("Diesel", 120, 10000.0);
        truck.drive();
        truck.refuel();
        truck.performMaintenance();
        System.err.println("--------------------------------------\n");
        
        Bus bus = new Bus("Diesel", 80, 50);
        bus.drive();
        bus.refuel();
        bus.performMaintenance();
        System.err.println("--------------------------------------\n");
    }
}
