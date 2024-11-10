package bank;

public class SavingsAccount extends BankAccount {
    static final double INTEREST_RATE = 0.04; // 4% interest rate for savings accounts

    public SavingsAccount(String accountHolder, int accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    public
    void calculateInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        System.out.println("Interest added: ₹" + interest);
    }
}