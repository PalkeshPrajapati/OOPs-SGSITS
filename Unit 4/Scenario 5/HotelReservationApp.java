import hotelSystem.*;

public class HotelReservationApp {
    public static void main(String[] args) {
        try {
            // Create a reservation for a suite
            Room suite = new Suite(101);
            Reservation reservation = new Reservation(suite);
            reservation.bookRoom();

            // Process payment
            Payment payment = new Payment();
            payment.processPayment(500); // Example amount

            // Checkout
            reservation.checkout();

        } catch (OverbookingException | InvalidPaymentException e) {
            System.out.println(e.getMessage());
        }
    }
}
