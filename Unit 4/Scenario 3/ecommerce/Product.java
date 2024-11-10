package ecommerce;

public class Product {
    private String productName;
    private double price;
    private int stock;

    public Product(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public synchronized void reduceStock(int quantity) throws ProductUnavailableException {
        if (quantity > stock) {
            throw new ProductUnavailableException("Product " + productName + " is out of stock.");
        }
        stock -= quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }
}
