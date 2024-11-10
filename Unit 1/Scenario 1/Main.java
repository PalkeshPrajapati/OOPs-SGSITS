import java.util.Scanner;
import LibraryManagementSystem.LibrarySystem;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // Initialize the library system
        LibrarySystem library = new LibrarySystem();
        Scanner sc = new Scanner(System.in);
        int userChoice = 0; // Initialize choice variable
        
        System.out.println("\nLibrary Management System By Palkesh Prajapati\n");

        // Main program loop
        do {
            try {
                // Display options for the user
                System.out.println("1. Register a new Member");
                System.out.println("2. Show all Members");
                System.out.println("3. Add a new Book");
                System.out.println("4. Show all Books");
                System.out.println("5. Borrow a Book");
                System.out.println("6. Return a Book");
                System.out.println("7. Show all Loans");
                System.out.println("8. Exit");

                System.out.printf("\nEnter Your Choice: ");
                userChoice = sc.nextInt(); // Get user input

                // Handle user choices with a switch statement
                switch (userChoice) {
                    case 1:
                        // Register a new member
                        System.out.printf("Enter member ID: ");
                        String id = sc.next();

                        System.out.printf("Enter member name: ");
                        String name = sc.next();

                        library.registerMember(name, id); // Call method to register a member
                        System.out.println("Member successfully registered.\n");
                        break;

                    case 2:
                        // Show all members
                        library.showAllMembers();
                        break;

                    case 3:
                        // Add a new book to the system
                        System.out.printf("Enter ISBN number: ");
                        String isbn = sc.next();

                        System.out.printf("Enter title: ");
                        sc.nextLine(); // Consume the newline
                        String title = sc.nextLine();

                        System.out.printf("Enter author name: ");
                        String author = sc.nextLine();

                        library.addBook(title, author, isbn); // Call method to add book
                        System.out.println("Book successfully added.\n");
                        break;

                    case 4:
                        // Show all books in the system
                        library.showAllBooks();
                        break;

                    case 5:
                        // Borrow a book
                        System.out.printf("Enter member ID: ");
                        String borrow_id = sc.next();

                        System.out.printf("Enter Book ISBN: ");
                        String borrow_isbn = sc.next();

                        library.borrowBook(borrow_isbn, borrow_id); // Call method to borrow book
                        break;

                    case 6:
                        // Return a book
                        System.out.printf("Enter member ID: ");
                        String return_id = sc.next();

                        System.out.printf("Enter Book ISBN: ");
                        String return_isbn = sc.next();

                        library.returnBook(return_isbn, return_id); // Call method to return book
                        break;

                    case 7:
                        // Show all loans
                        library.showAllLoans();
                        break;

                    case 8:
                        // Exit the system
                        System.out.println("Exiting... Thank you for using the system.");
                        break;

                    default:
                        // Handle invalid menu options
                        System.out.println("Invalid choice! Please choose between 1 and 8.\n");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine(); // Clear the buffer
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }

        } while (userChoice != 8); // Loop until the user chooses to exit

        // Close the scanner to prevent resource leaks
        sc.close();
    }
}
