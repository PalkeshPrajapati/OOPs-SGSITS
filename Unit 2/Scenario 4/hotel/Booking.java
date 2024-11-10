package hotel;

import java.util.ArrayList;
import java.util.List;

public class Booking {
    private Guest guest;
    private List<Room> rooms;
    private Payment payment;

    public Booking(Guest guest, Room room, Payment payment) {
        this.guest = guest;
        this.rooms = new ArrayList<>();
        this.rooms.add(room);
        this.payment = payment;
    }

    // Method overloading to handle multiple room bookings
    public Booking(Guest guest, List<Room> rooms, Payment payment) {
        this.guest = guest;
        this.rooms = rooms;
        this.payment = payment;
    }

    public void displayBookingDetails() {
        System.out.println("Booking Details:");
        guest.displayGuestInfo();
        for (Room room : rooms) {
            room.displayRoomInfo();
        }
        payment.displayPaymentInfo();
    }

    public void makePayment() {
        payment.makePayment();
    }
}
