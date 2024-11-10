package ecommerce;

public class PaymentProcessor {

    public static void processPayment(double amount) throws PaymentFailureException {
        if (amount <= 0) {
            throw new PaymentFailureException("Invalid payment amount.");
        }
        System.out.println("Payment of $" + amount + " processed successfully.");
    }
}
