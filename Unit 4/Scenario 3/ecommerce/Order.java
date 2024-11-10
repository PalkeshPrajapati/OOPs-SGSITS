package ecommerce;

public class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void processOrder() throws ProductUnavailableException {
        product.reduceStock(quantity);
        System.out.println("Order placed for " + quantity + " units of " + product.getProductName());
    }
}
