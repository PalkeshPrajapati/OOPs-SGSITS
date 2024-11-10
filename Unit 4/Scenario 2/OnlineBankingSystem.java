import banking.BankAccount;
import banking.Customer;
import banking.Transaction;

public class OnlineBankingSystem {

    public static void main(String[] args) {
        // Create a customer and a bank account
        Customer customer = new Customer("John Doe", 12345);
        BankAccount account = new BankAccount(customer, 67890, 1000.00);

        // Simulate transactions using multithreading
        try {
            Transaction deposit = new Transaction(account, 200, "deposit");
            Transaction withdrawal = new Transaction(account, 300, "withdraw");
            deposit.start();
            withdrawal.start();
            deposit.join();
            withdrawal.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
