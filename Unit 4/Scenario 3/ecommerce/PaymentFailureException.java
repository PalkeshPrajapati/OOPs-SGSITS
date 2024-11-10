package ecommerce;

public class PaymentFailureException extends Exception {
    public PaymentFailureException(String message) {
        super(message);
    }
}
