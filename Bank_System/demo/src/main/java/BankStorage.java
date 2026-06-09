import java.util.ArrayList;
import java.io.*;
import java.nio.Buffer;

/**
 * Handles saving and loading bank account data
 * to and from a text file.
 */
public class BankStorage {
    /**
     * Saves all bank accounts to a file named "accounts.txt".
     * Each account is stored in the format:
     * owner;balance
     *
     * @param bank The bank containing accounts to save
     */
    public static void save(Bank bank){
        try{
            // Create a writer for the accounts file
            PrintWriter writer = new PrintWriter("accounts.txt");

            // Write each account's owner and balance
            for (BankAccount account : bank.getAccounts()){
                writer.println(account.getOwner() + ";" + account.getBalance());
            }
            // Close the file after writing
            writer.close();
        }
        catch (Exception e){
            System.out.println("Save error.");
        }
    }
    /**
     * Loads bank accounts from "accounts.txt".
     * If the file does not exist, an empty bank is returned.
     *
     * @return A Bank object containing all loaded accounts
     */
    public static Bank load(){
        // Create an empty bank to store loaded accounts
        Bank bank = new Bank();

        try{
            File file = new File("accounts.txt");

            // Return an empty bank if no save file exists
            if (!file.exists()){
                return bank;
            }

            // Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Split the line into owner and balance
                String[] parts = line.split(";");

                String owner = parts[0];
                double balance = Double.parseDouble(parts[1]);

                // Recreate the bank account
                BankAccount account = new BankAccount(owner);

                // Restore the balance
                account.deposit(balance);
                // Add the account to the bank
                bank.addAccount(account);
            }
            // Close the file after reading
            reader.close();
        }
        catch (Exception e){
            System.out.println("Load error.");
        }
        return bank;
    }
}
