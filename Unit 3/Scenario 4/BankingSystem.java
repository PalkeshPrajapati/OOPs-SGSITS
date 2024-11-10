import bankaccounts.*;
import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Create instances of different account types
        BankAccount savings = new SavingsAccount("SA12345", 5000);
        BankAccount checking = new CheckingAccount("CA12345", 2000);
        BankAccount business = new BusinessAccount("BA12345", 10000);
        
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an action:\n1. Deposit\n2. Withdraw\n3. Calculate Interest\n4. Exit");
            int action = scanner.nextInt();
            
            if (action == 4) {
                exit = true;
                break;
            }
            
            System.out.println("Choose account:\n1. Savings\n2. Checking\n3. Business");
            int accountChoice = scanner.nextInt();
            
            BankAccount account = switch (accountChoice) {
                case 1 -> savings;
                case 2 -> checking;
                case 3 -> business;
                default -> null;
            };
            
            if (account == null) {
                System.out.println("Invalid account choice.");
                continue;
            }

            switch (action) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double amount = scanner.nextDouble();
                    account.deposit(amount);
                }
                case 2 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = scanner.nextDouble();
                    account.withdraw(amount);
                }
                case 3 -> System.out.println("Interest: " + account.calculateInterest());
                default -> System.out.println("Invalid action choice.");
            }
            System.out.println("-------------------------------\n");
        }
        
        scanner.close();
    }
}

