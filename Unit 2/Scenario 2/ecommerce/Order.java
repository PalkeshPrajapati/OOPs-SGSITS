package ecommerce;

import java.util.*;

public class Order {
    private Customer customer;
    private ArrayList<Product> products = new ArrayList<>();
    private double totalAmount;

    public Order(Customer customer) {
        this.customer = customer;
    }

    // For a single product
    public void addProduct(Product product, int quantity) {
        if (product.getStock() >= quantity) {
            products.add(product);
            totalAmount += product.getPrice() * quantity;
            product.reduceStock(quantity);
        } else {
            System.out.println("Not enough stock for " + product.getName());
        }
    }

    // For multiple products
    void addProduct(ArrayList<Product> productList) {
        for (Product product : productList) {
            products.add(product);
            totalAmount += product.getPrice();
        }
    }

    public void displayOrderDetails() {
        System.out.println("Order for Customer: " + customer.getName() + " (" + customer.getEmail() + ")");
        System.out.println("Ordered Products:");
        for (Product product : products) {
            System.out.println("- " + product.getName() + ": Rs." + product.getPrice());
        }
        System.out.println("Total Amount: Rs." + totalAmount);
    }
}