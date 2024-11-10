package rideSharing;

public class Ride {
    private User user;
    private String pickupLocation;
    private String dropoffLocation;
    private Driver driver;
    private boolean isStarted;

    public Ride(User user, String pickupLocation, String dropoffLocation) {
        this.user = user;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.isStarted = false;
    }

    public void assignDriver(Driver driver) throws NoDriverAvailableException {
        if (driver == null) {
            throw new NoDriverAvailableException("No driver available for this ride.");
        }
        this.driver = driver;
        System.out.println("Driver assigned: " + driver.getName());
    }

    public void startRide() throws InvalidRideRequestException {
        if (driver == null || user == null) {
            throw new InvalidRideRequestException("Ride request is invalid.");
        }
        this.isStarted = true;
        System.out.println("Ride started from " + pickupLocation + " to " + dropoffLocation);
    }
}
