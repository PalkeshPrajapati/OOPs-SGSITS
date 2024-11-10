import java.util.*;
import ecommerce.*;

public class ECommercePlatform {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create sample products
        Product prod1 = new Electronics("Laptop", 50000, 10);
        Product prod2 = new Clothing("T-shirt", 500, 50);

        // Create a customer
        Customer customer = new Customer("Palkesh Prajapati", "palkeshprajapati88@gmail.com");

        int choice;
        do {
            System.out.println("\n1. View Products");
            System.out.println("2. Place Order");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Products Available:");
                    System.out.println("1. " + prod1.getName() + " - Rs." + prod1.getPrice() + " (Stock: " + prod1.getStock() + ")");
                    System.out.println("2. " + prod2.getName() + " - Rs." + prod2.getPrice() + " (Stock: " + prod2.getStock() + ")");
                    break;

                case 2:
                    Order order = new Order(customer);

                    // Single product order
                    System.out.print("Enter product number (1 for Laptop, 2 for T-shirt): ");
                    int prodChoice = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    if (prodChoice == 1) {
                        order.addProduct(prod1, quantity);
                    } else if (prodChoice == 2) {
                        order.addProduct(prod2, quantity);
                    }

                    // Display order details
                    order.displayOrderDetails();
                    break;

                case 0:
                    System.out.println("Exiting E-Commerce Platform.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
