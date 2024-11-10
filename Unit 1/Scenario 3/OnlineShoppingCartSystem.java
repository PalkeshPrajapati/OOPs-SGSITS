import java.util.Scanner;
import ecommerce.Customer;
import ecommerce.Product;
import ecommerce.ShoppingCart;

public class OnlineShoppingCartSystem {
    static ShoppingCart cart = new ShoppingCart();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter customer name: ");
        Customer customer = new Customer(sc.nextLine());
        
        int choice;
        do {
            System.out.println("\n1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Display Cart & Checkout");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter product name, price, quantity: ");
                    cart.addProduct(new Product(sc.next(), sc.nextDouble(), sc.nextInt()));
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    cart.removeProduct(sc.next());
                    break;
                case 3:
                    cart.displayCart();
                    break;
                case 0:
                    System.out.println("Exiting Shopping Cart System. Thank you, " + customer.name + "!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }
}
