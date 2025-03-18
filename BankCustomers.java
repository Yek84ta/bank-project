import java.util.ArrayList;

public class BankCustomers {
    private ArrayList<BankAccount> accountsList = new ArrayList<>();

    public void addAccount(BankAccount newAccount) {
        accountsList.add(newAccount);
    }

    public void showAllBalances() {
        for (int i = 0; i < accountsList.size(); i++) {
            System.out.println("Customer's name: " + accountsList.get(i).getAccountHolderName());
            System.out.println("Account number: " + accountsList.get(i).getAccountNumber());
            System.out.println("Balance: " + accountsList.get(i).getBalance());
        }
    }

    public BankAccount findAccount(String accountNumber) {
        for (int i = 0; i < accountsList.size(); i++) {
            if (accountsList.get(i).getAccountNumber().equals(accountNumber)) {
                System.out.println("Customer's name: " + accountsList.get(i).getAccountHolderName());
                System.out.println("Account number: " + accountsList.get(i).getAccountNumber());
                System.out.println("Balance: " + accountsList.get(i).getBalance());
                return accountsList.get(i);
            }
        }
        System.out.println("No account was found with the provided account number!");
        return null;
    }
}