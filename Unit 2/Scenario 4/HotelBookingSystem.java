import hotel.*;

import java.util.ArrayList;
import java.util.List;

public class HotelBookingSystem {

    public static void main(String[] args) {
        // Create a guest
        Guest guest1 = new Guest("Palkesh Prajapati", "D08", "palkeshprajapati88@gmail.com");

        // Create rooms
        Room room1 = new SingleRoom(101, 120.0);
        Room room2 = new DoubleRoom(102, 150.0);

        // Create a payment
        Payment payment1 = new Payment(120.0, "Credit Card");

        // Create a single room booking
        Booking booking1 = new Booking(guest1, room1, payment1);
        booking1.displayBookingDetails();
        System.err.println("-------------------------------\n");
        booking1.makePayment();
        
        // Create multiple room booking
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        Payment payment2 = new Payment(270.0, "Debit Card");
        
        Booking booking2 = new Booking(guest1, rooms, payment2);
        booking2.displayBookingDetails();
        System.err.println("-------------------------------\n");
        booking2.makePayment();
    }
}
