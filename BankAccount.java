public abstract class BankAccount {
    final private String accountNumber;
    private String accountHolderName;
    protected double balance;

    public BankAccount(String newAccountNumber, String newAccountHolderName, double newBalance) {
        this.accountNumber = newAccountNumber;
        this.accountHolderName = newAccountHolderName;
        this.balance = newBalance;
    }

    public abstract void calculateInterest();

    public void deposit(double amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("The amount that you mentioned is not valid!");
            }
            balance += amount;
            System.out.println("Dear " + accountHolderName + ", an amount of " + amount + " has been credited to your account " + accountNumber + ", and your balance is " + balance + ".");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("The amount that you mentioned is not valid!");
            }
            if (balance < amount) {
                throw new IllegalStateException("Dear " + accountHolderName + ", your account " + accountNumber + " does not have sufficient funds to complete the transaction. Please recharge your account to proceed.");
            }
            balance -= amount;
            System.out.println("Dear " + accountHolderName + ", an amount of " + amount + " has been deducted from your account " + accountNumber + ", and your balance is " + balance + ".");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

class SavingAccount extends BankAccount {
    private final double interestRate = 0.03;

    public SavingAccount(String newAccountNumber, String newAccountHolderName, double initialBalance) {
        super(newAccountNumber, newAccountHolderName, initialBalance);
    }

    @Override
    public void calculateInterest() {
        double interest = interestRate * getBalance();
        deposit(interest);
        System.out.println("Dear " + getAccountHolderName() + ", an interest amount of " + interest + " has been added to your saving account " + getAccountNumber() + ". Your new balance is " + getBalance() + ".");
    }
}

class TransactionAccount extends BankAccount {
    private final double overDraftLimit = 500;

    public TransactionAccount(String newAccountNumber, String newAccountHolderName, double initialBalance) {
        super(newAccountNumber, newAccountHolderName, initialBalance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Dear " + getAccountHolderName() + ", there is no interest applicable for your transaction account " + getAccountNumber() + ".");
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("The amount that you mentioned is not valid!");
            }
            if (balance + overDraftLimit < amount) {
                throw new IllegalStateException("Dear " + getAccountHolderName() + ", your account " + getAccountNumber() + " does not have sufficient funds to complete the transaction. Please recharge your account to proceed.");
            }
            balance -= amount;
            System.out.println("Dear " + getAccountHolderName() + ", an amount of " + amount + " has been deducted from your account " + getAccountNumber() + ", and your balance is " + balance + ".");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}


