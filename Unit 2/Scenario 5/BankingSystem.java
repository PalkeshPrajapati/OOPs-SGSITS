import java.util.*;

// TransactionHistory class (Composition: Account has a TransactionHistory)
class TransactionHistory {
    private List<String> transactions = new ArrayList<>();

    void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    void displayTransactions() {
        System.out.println("Transaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

// Account class (Aggregation: A Customer may have multiple Accounts)
class Account {
    private String accountNumber;
    private double balance;
    private TransactionHistory transactionHistory;

    Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new TransactionHistory();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public TransactionHistory getTransactionHistory() {
        return transactionHistory;
    }

    void deposit(double amount) {
        balance += amount;
        transactionHistory.addTransaction("Deposited Rs." + amount);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.addTransaction("Withdrew Rs." + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs." + balance);
    }
}

// Specialized SavingsAccount class inheriting Account
class SavingsAccount extends Account {
    private double interestRate;

    SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        getTransactionHistory().addTransaction("Interest applied: Rs." + interest);
    }
}

// Specialized CheckingAccount class inheriting Account
class CheckingAccount extends Account {
    private double overdraftLimit;

    CheckingAccount(String accountNumber, double initialBalance, double overdraftLimit) {
        super(accountNumber, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            super.withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}

// Transaction class (Method Overloading for different types of transactions)
class Transaction {
    void performTransaction(Account account, double amount, String type) {
        if (type.equals("deposit")) {
            account.deposit(amount);
        } else if (type.equals("withdrawal")) {
            account.withdraw(amount);
        }
    }
}

// Customer class (Association: Customer may have multiple Accounts)
class Customer {
    private String name;
    private String customerId;
    private List<Account> accounts = new ArrayList<>();

    Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    void addAccount(Account account) {
        accounts.add(account);
    }

    void displayCustomerDetails() {
        System.out.println("Customer: " + name + " (ID: " + customerId + ")");
        for (Account account : accounts) {
            account.displayAccountDetails();
            account.getTransactionHistory().displayTransactions();
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Create a Customer
        Customer customer = new Customer("Ravi Kumar", "C001");

        // Create Accounts
        SavingsAccount savings = new SavingsAccount("S001", 50000, 5); // 5% interest rate
        CheckingAccount checking = new CheckingAccount("C001", 20000, 5000); // Rs.5000 overdraft limit

        // Add Accounts to Customer
        customer.addAccount(savings);
        customer.addAccount(checking);

        // Perform Transactions
        Transaction transaction = new Transaction();
        transaction.performTransaction(savings, 10000, "deposit"); // Deposit Rs.10000 to savings
        transaction.performTransaction(checking, 3000, "withdrawal"); // Withdraw Rs.3000 from checking

        // Apply Interest to Savings Account
        savings.applyInterest();

        // Display Customer and Account details
        customer.displayCustomerDetails();
    }
}
