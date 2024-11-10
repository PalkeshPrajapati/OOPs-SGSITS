package bankaccounts;

public class BusinessAccount extends BankAccount implements Taxable {
    private static final double INTEREST_RATE = 0.03; // 3% interest rate
    private static final double TAX_RATE = 0.2; // 20% tax rate on interest

    public BusinessAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance for withdrawal.");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * INTEREST_RATE;
    }

    @Override
    public double calculateTax() {
        return calculateInterest() * TAX_RATE; // Tax on earned interest
    }
}
