import java.util.ArrayList;
import java.util.Scanner;
import bank.BankAccount;
import bank.SavingsAccount;
import bank.CheckingAccount;

public class BankAccountSystem {
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n1. Open Savings Account");
            System.out.println("2. Open Checking Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Display Balance");
            System.out.println("6. Calculate Interest");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name, account number, and initial balance: ");
                    accounts.add(new SavingsAccount(sc.next(), sc.nextInt(), sc.nextDouble()));
                    System.out.println("Savings account opened.");
                    break;
                case 2:
                    System.out.print("Enter account holder name, account number, and initial balance: ");
                    accounts.add(new CheckingAccount(sc.next(), sc.nextInt(), sc.nextDouble()));
                    System.out.println("Checking account opened.");
                    break;
                case 3:
                    System.out.print("Enter account number and deposit amount: ");
                    BankAccount depositAccount = findAccount(sc.nextInt());
                    if (depositAccount != null) {
                        double amount = sc.nextDouble();
                        if (depositAccount.deposit(amount)) {
                            System.out.println("Deposited ₹" + amount);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter account number and withdrawal amount: ");
                    BankAccount withdrawAccount = findAccount(sc.nextInt());
                    if (withdrawAccount != null) {
                        double amount = sc.nextDouble();
                        if (withdrawAccount.withdraw(amount)) {
                            System.out.println("Withdrawn ₹" + amount);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter account number to check balance: ");
                    BankAccount balanceAccount = findAccount(sc.nextInt());
                    if (balanceAccount != null) {
                        balanceAccount.displayBalance();
                    }
                    break;
                case 6:
                    System.out.print("Enter account number to calculate interest: ");
                    BankAccount interestAccount = findAccount(sc.nextInt());
                    if (interestAccount != null && interestAccount instanceof SavingsAccount) {
                        ((SavingsAccount) interestAccount).calculateInterest();
                    } else {
                        System.out.println("Interest calculation only available for Savings accounts.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting Bank Account Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 0);
    }

    // Method to find account by account number
    static BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.accountNumber == accountNumber) {
                return account;
            }
        }
        System.out.println("Account not found.");
        return null;
    }
}
