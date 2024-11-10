package bank;

public abstract class BankAccount {
    String accountHolder;
    public int accountNumber;
    double balance;

    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    abstract void calculateInterest(); // Calculate interest for specific accounts

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        System.out.println("Insufficient balance for withdrawal.");
        return false;
    }

    public void displayBalance() {
        System.out.println("Account balance: ₹" + balance);
    }
}