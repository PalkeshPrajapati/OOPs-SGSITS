package inventory;

public class Order implements Runnable {
    private Product product;
    private int quantity;
    private Supplier supplier;

    public Order(Product product, int quantity, Supplier supplier) {
        this.product = product;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public void processOrder() throws OutOfStockException, InvalidProductException {
        if (product == null || quantity <= 0) {
            throw new InvalidProductException("Invalid product or quantity.");
        }

        synchronized (product) {
            product.reduceStock(quantity);
            System.out.println("Order processed for " + quantity + " units of " + product.getName());
        }
    }

    @Override
    public void run() {
        try {
            processOrder();
        } catch (OutOfStockException | InvalidProductException e) {
            System.out.println(e.getMessage());
        }
    }
}
