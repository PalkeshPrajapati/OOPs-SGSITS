package hotel;

public class Payment {
    private double amount;
    private String paymentMethod;
    private boolean isPaid;

    public Payment(double amount, String paymentMethod) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.isPaid = false; // Initial payment status
    }

    public void makePayment() {
        isPaid = true;
        System.out.println("Payment of Rs" + amount + " made via " + paymentMethod + ".");
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void displayPaymentInfo() {
        System.out.println("Payment Amount: Rs" + amount);
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Payment Status: " + (isPaid ? "Paid" : "Unpaid"));
    }
}
