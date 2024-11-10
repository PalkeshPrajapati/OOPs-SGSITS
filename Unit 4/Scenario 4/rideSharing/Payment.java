package rideSharing;

public class Payment {
    public void processPayment(double amount) throws PaymentFailureException {
        if (amount <= 0) {
            throw new PaymentFailureException("Payment failed: Invalid amount.");
        }
        System.out.println("Payment of $" + amount + " processed successfully.");
    }
}
