import java.util.ArrayList;

/**
 * Represents a bank that manages multiple bank accounts.
 * Provides functionality for adding accounts, searching
 * for accounts, and transferring funds between accounts.
 */
public class Bank {
    // List of all bank accounts
    private ArrayList<BankAccount> accounts;

    /**
     * Creates a new bank with an empty account list.
     */
    public Bank(){
        accounts = new ArrayList<>();
    }
    /**
     * Adds a bank account to the bank.
     *
     * @param account The account to add
     */
    public void addAccount(BankAccount account){
        accounts.add(account);
    }
    /**
     * Searches for an account by owner name.
     *
     * @param owner The owner's name
     * @return The matching BankAccount, or null if not found
     */
    public BankAccount findAccount(String owner){
        for (BankAccount account : accounts){
            if (account.getOwner().equals(owner)){
                return account;
            }
        }
        return null;
    }
    /**
     * Transfers money from one account to another.
     *
     * @param fromOwner Owner of the sending account
     * @param toOwner Owner of the receiving account
     * @param amount Amount to transfer
     * @return true if the transfer succeeds, false otherwise
     */
    public boolean transfer(String fromOwner, String toOwner, double amount){
        // Find both accounts involved in the transfer
        BankAccount sender = findAccount(fromOwner);
        BankAccount receiver = findAccount(toOwner);

        // Record transfer details in both transaction histories
        sender.addTransaction("Transfer Sent: -" + amount + " to " + receiver.getOwner());
        receiver.addTransaction("Transfer Received: +" + amount + " from " + sender.getOwner());

        // Ensure both accounts exist
        if(sender == null || receiver == null){
            return false;
        }
        // Attempt to withdraw money from the sender
        if(!sender.withdraw(amount)){
            return false;
        }
        // Deposit money into the receiver's account
        receiver.deposit(amount);
        return true;
    }
    /**
     * Returns the list of all bank accounts.
     *
     * @return List of accounts
     */
    public ArrayList<BankAccount> getAccounts(){
        return accounts;
    }
}
