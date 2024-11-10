import rideSharing.Ride;
import rideSharing.Driver;
import rideSharing.User;
import rideSharing.Payment;

public class RideSharingApp {

    public static void main(String[] args) {
        // Initialize drivers and users
        Driver driver1 = new Driver("John Doe", "JD123");
        Driver driver2 = new Driver("Jane Smith", "JS456");
        User user1 = new User("Alice", "AL789");

        // Simulate ride requests and payments
        try {
            Ride ride1 = new Ride(user1, "Downtown", "Airport");
            ride1.assignDriver(driver1);

            // Process ride booking in a separate thread
            Thread rideThread = new Thread(() -> {
                try {
                    ride1.startRide();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });

            rideThread.start();
            rideThread.join();

            // Simulate payment
            Payment payment = new Payment();
            payment.processPayment(50.0);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
