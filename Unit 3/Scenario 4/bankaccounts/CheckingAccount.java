package bankaccounts;

public class CheckingAccount extends BankAccount{
    private static final double OVERDRAFT_LIMIT = 1000; // Allow overdraft up to $1000

    public CheckingAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance + OVERDRAFT_LIMIT >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded. Cannot withdraw " + amount);
        }
    }

    @Override
    public double calculateInterest() {
        return 0; // Typically, checking accounts do not earn interest
    }
}
