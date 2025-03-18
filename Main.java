public class Main {
    public static void main(String[] args) {
        BankCustomers bank = new BankCustomers();

        TransactionAccount transactionAccount1 = new TransactionAccount("6037991564987401","John Kransinki",102800 );
        TransactionAccount transactionAccount2 = new TransactionAccount("6037991579184720", "Jenna Fischer", 8943);
        TransactionAccount transactionAccount3 = new TransactionAccount("6037991554808832", "Steve Carell", 200);

        SavingAccount savingAccount1 = new SavingAccount("6037991566558833", "Ellie Kemper",5800);
        SavingAccount savingAccount2 = new SavingAccount("6037991511143670","Ed Helms",10890);
        SavingAccount savingAccount3 = new SavingAccount("6037991575938766","Melora Hardin",1589);
        
        bank.addAccount(transactionAccount1);
        bank.addAccount(transactionAccount2);
        bank.addAccount(transactionAccount3);
        bank.addAccount(savingAccount1);
        bank.addAccount(savingAccount2);
        bank.addAccount(savingAccount3);

        bank.findAccount("6037991564987401");
        bank.findAccount("6037941564987401");

        System.out.println(savingAccount1.balance);
        savingAccount1.deposit(690);
        System.out.println(savingAccount1.balance);


        savingAccount1.deposit(-950);

        savingAccount2.calculateInterest();
        System.out.println(savingAccount2.balance);
        transactionAccount2.calculateInterest();
        System.out.println(transactionAccount2.balance);

        savingAccount1.withdraw(150);
        savingAccount2.withdraw(-250);
        savingAccount3.withdraw(2500);

        transactionAccount1.withdraw(85);
        transactionAccount2.withdraw(-360);
        transactionAccount3.withdraw(300);

        bank.showAllBalances();


    }
}