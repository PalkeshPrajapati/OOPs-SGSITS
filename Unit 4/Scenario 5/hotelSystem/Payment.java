package hotelSystem;

public class Payment {
    public void processPayment(double amount) throws InvalidPaymentException {
        if (amount <= 0) {
            throw new InvalidPaymentException("Invalid payment amount.");
        }
        System.out.println("Payment of $" + amount + " processed successfully.");
    }
}
