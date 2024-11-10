package bankaccounts;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public abstract void withdraw(double amount); // Abstract method for withdrawal

    public abstract double calculateInterest(); // Abstract method to calculate interest

    public double getBalance() {
        return balance;
    }
}
