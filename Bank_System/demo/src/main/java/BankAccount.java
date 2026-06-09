import java.util.ArrayList;

/**
 * Represents a simple bank account that supports deposits,
 * withdrawals, and transaction history tracking.
 */
public class BankAccount {
    // Name of the account owner 
    private String owner;
    // Current account balance
    private double balance;
    // List of all account transactions
    private ArrayList<String> transactions;

    /**
     * Creates a new bank account with the specified owner.
     * The initial balance is set to 0.
     *
     * @param owner Name of the account owner
     */
    public BankAccount(String owner){
        this.owner = owner;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    /**
     * Withdraws money from the account if the amount is valid
     * and sufficient funds are available.
     *
     * @param amount Amount to withdraw
     * @return true if the withdrawal succeeds, false otherwise
     */
    public boolean withdraw(double amount){
        // Reject invalid withdrawal amounts
        if (amount <= 0){
            return false;
        }
        // Prevent overdrawing the account
        if (amount > balance){
            return false;
        }
        // Update balance and record transaction
        balance -= amount;
        transactions.add("Withdraw: -" + amount);
        return true;
    }
    /**
     * Deposits money into the account.
     *
     * @param amount Amount to deposit
     * @return true if the deposit succeeds, false otherwise
     */
    public boolean deposit(double amount){
        // Reject invalid deposit amounts
        if (amount <= 0){
            return false;
        }
        // Update balance and record transaction
        balance += amount;
        transactions.add("Deposit: +" + amount);
        return true;
    }
    /**
     * Returns the current account balance.
     *
     * @return Current balance
     */
    public double getBalance(){
        return balance;
    }
    /**
     * Returns the list of account transactions.
     *
     * @return Transaction history
     */
    public ArrayList<String> getTransactions(){
        return transactions;
    }
    /**
     * Returns the name of the account owner.
     *
     * @return Owner name
     */
    public String getOwner(){
        return owner;
    }
    /**
     * Adds a custom transaction entry to the transaction history.
     *
     * @param transaction Transaction description
     */
    public void addTransaction(String transaction){
        transactions.add(transaction);
    }
}
