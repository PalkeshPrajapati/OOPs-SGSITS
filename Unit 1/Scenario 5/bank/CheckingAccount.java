package bank;

public class CheckingAccount extends BankAccount {
    static final double MINIMUM_BALANCE = 500; // Minimum balance for checking accounts

    public CheckingAccount(String accountHolder, int accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    void calculateInterest() {
        // Checking accounts do not earn interest, so this method is empty
    }

    boolean checkMinimumBalance() {
        if (balance < MINIMUM_BALANCE) {
            System.out.println("Warning: Minimum balance requirement not met.");
            return false;
        }
        return true;
    }
}
