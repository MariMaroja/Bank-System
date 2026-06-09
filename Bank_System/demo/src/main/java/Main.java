import java.util.Scanner;

/**
 * Main class that runs the console-based banking system.
 * Provides a menu for creating accounts, deposits,
 * withdrawals, transfers, balance checks, and
 * transaction history viewing.
 */
public class Main {
    /**
     * Program entry point.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args)
    {
        // Scanner used to read user input
        Scanner scanner = new Scanner(System.in);
        // Load saved bank data from storage
        Bank bank = BankStorage.load();

        // Controls the main application loop
        boolean running = true;

        // Main menu loop
        while(running){
            // Display menu options
            System.out.println("\n=== BANK SYSTEM ===");
            System.out.println("1 - Create account");
            System.out.println("2 - Deposit");
            System.out.println("3 - Withdraw");
            System.out.println("4 - Transfer");
            System.out.println("5 - Show Balance");
            System.out.println("6 - Transaction History");
            System.out.println("0 - Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Clear newline from input buffer

            switch (option){
                case 0:
                    // Save all accounts before exiting
                    BankStorage.save(bank);
                    running = false;
                    break;

                case 1:
                    // Create a new bank account
                    {System.out.println("Owner name: ");
                    String owner = scanner.nextLine();
                    
                    BankAccount account = new BankAccount(owner);

                    bank.addAccount(account);

                    System.out.println("Account Created.");
                    break;
                }
                case 2:
                    // Deposit money into an account
                    {System.out.println("Owner name: ");
                    String owner = scanner.nextLine();

                    BankAccount account = bank.findAccount(owner);

                    if (account == null){
                        System.out.println("Account not found.");
                        break;
                    }

                    System.out.println("Amount: ");
                    double amount = scanner.nextDouble();

                    account.deposit(amount);

                    System.out.println("Deposit Succesful.");

                    break;
                }
                case 3:
                    // Withdraw money from an account
                    {System.out.println("Owner name: ");
                    String owner = scanner.nextLine();

                    BankAccount account = bank.findAccount(owner);

                    if (account == null){
                        System.out.println("Account not found. ");
                        break;
                    }

                    System.out.println("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    if (account.withdraw(amount)){
                        System.out.println("Withdraw Succesful.");
                    }
                    else{
                        System.out.println("Withdraw Failed.");
                    }

                    break;
                }
                case 4:
                    // Transfer money between two accounts
                    {System.out.println("From: ");
                    String from = scanner.nextLine();

                    System.out.println("To: ");
                    String to = scanner.nextLine();

                    System.out.println("Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    if (bank.transfer(from, to, amount)){
                        System.out.println("Transfer Succesful.");
                    }
                    else {
                        System.out.println("Transfer failed.");
                    }
                    break;
                }
                case 5:
                    // Display account balance
                    {System.out.println("Owner name: ");
                    String owner = scanner.nextLine();

                    BankAccount account = bank.findAccount(owner);

                    if (account == null){
                        System.out.println("Account not Found.");
                        break;
                    }

                    System.out.println("Balance: " + account.getBalance());
                    break;
                }
                case 6:
                    // Display transaction history
                    {System.out.println("Owner name: ");
                    String owner = scanner.nextLine();

                    BankAccount account = bank.findAccount(owner);

                    if (account == null){
                        System.out.println("Account not Found.");
                        break;
                    }

                    // Print each transaction in the account history
                    for (String transaction : account.getTransactions()){
                        System.out.println(transaction);
                    }
                    break;
                }
            }
        }
        
    }
}
