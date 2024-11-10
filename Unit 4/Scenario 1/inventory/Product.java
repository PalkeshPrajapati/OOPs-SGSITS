package inventory;

public class Product {
    private String name;
    private int productId;
    private int stock;

    public Product(String name, int productId, int stock) {
        this.name = name;
        this.productId = productId;
        this.stock = stock;
    }

    public synchronized void updateStock(int amount) {
        stock += amount;
        System.out.println("Stock updated. New stock level: " + stock);
        notifyAll(); // Notify other threads waiting on stock
    }

    public synchronized void reduceStock(int amount) throws OutOfStockException {
        if (stock < amount) {
            throw new OutOfStockException("Product " + name + " is out of stock.");
        }
        stock -= amount;
        System.out.println("Stock reduced. Remaining stock: " + stock);
    }

    public int getStock() {
        return stock;
    }

    public String getName() {
        return name;
    }

    public int getProductId() {
        return productId;
    }
}
