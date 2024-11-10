package ecommerce;

import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<Product> cart = new ArrayList<>();
    static final double TAX_RATE = 0.08; // 8% tax
    static final double DISCOUNT_THRESHOLD = 5000;
    static final double DISCOUNT_RATE = 0.1; // 10% discount

    public void addProduct(Product p) {
        cart.add(p);
        System.out.println(p.name + " added to cart.");
    }

    public void removeProduct(String name) {
        cart.removeIf(p -> p.name.equals(name));
        System.out.println(name + " removed from cart.");
    }

    double calculateTotal() {
        double subtotal = 0;
        for (Product p : cart) {
            subtotal += p.price * p.quantity;
        }
        double discount = (subtotal > DISCOUNT_THRESHOLD) ? subtotal * DISCOUNT_RATE : 0;
        double tax = subtotal * TAX_RATE;
        return subtotal - discount + tax;
    }

    public void displayCart() {
        System.out.println("\nCart Contents:");
        for (Product p : cart) {
            System.out.println(p.name + " - Rs." + p.price + " x " + p.quantity);
        }
        System.out.println("Total: Rs." + calculateTotal());
        System.out.println("-------------------------");
    }
}
