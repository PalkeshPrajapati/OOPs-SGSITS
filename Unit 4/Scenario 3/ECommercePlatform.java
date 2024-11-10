import ecommerce.Product;
import ecommerce.Order;
import ecommerce.PaymentProcessor;

public class ECommercePlatform {

    public static void main(String[] args) {
        // Initialize products
        Product product1 = new Product("Laptop", 1500.0, 10);
        Product product2 = new Product("Headphones", 100.0, 5);

        // Simulate placing an order
        try {
            Order order1 = new Order(product1, 2);
            Order order2 = new Order(product2, 1);

            // Process orders concurrently
            Thread orderThread1 = new Thread(() -> {
                try {
                    order1.processOrder();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });

            Thread orderThread2 = new Thread(() -> {
                try {
                    order2.processOrder();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });

            orderThread1.start();
            orderThread2.start();
            orderThread1.join();
            orderThread2.join();

            // Simulate payment
            PaymentProcessor.processPayment(1600.0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
