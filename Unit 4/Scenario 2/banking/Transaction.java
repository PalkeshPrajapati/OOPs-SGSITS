package banking;

public class Transaction extends Thread {
    private BankAccount account;
    private double amount;
    private String type;

    public Transaction(BankAccount account, double amount, String type) {
        this.account = account;
        this.amount = amount;
        this.type = type;
    }

    @Override
    public void run() {
        try {
            if (type.equals("deposit")) {
                account.deposit(amount);
            } else if (type.equals("withdraw")) {
                account.withdraw(amount);
            } else {
                throw new InvalidAccountException("Invalid transaction type");
            }
        } catch (InsufficientFundsException | InvalidAccountException e) {
            System.out.println(e.getMessage());
        }
    }
}
