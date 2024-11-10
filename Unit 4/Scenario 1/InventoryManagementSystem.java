import inventory.*;

public class InventoryManagementSystem {

    public static void main(String[] args) {
        // Create Product and Supplier
        Product product = new Product("Laptop", 1001, 10);
        Supplier supplier = new Supplier("Tech Supplies", 5001);

        // Simulate processing an order
        Order order = new Order(product, 5, supplier);
        try {
            order.processOrder();
        } catch (OutOfStockException | InvalidProductException e) {
            System.out.println(e.getMessage());
        }

        // Start threads to handle inventory updates and order processing concurrently
        Thread updateStockThread = new Thread(new StockUpdater(product));
        Thread orderProcessingThread = new Thread(order);

        updateStockThread.start();
        orderProcessingThread.start();
    }
}
