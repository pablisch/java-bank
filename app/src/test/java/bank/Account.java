package bank;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    ArrayList<Transaction> transactionList = new ArrayList<>();
    public void deposit(Number credit) {
        Double creditDouble = credit.doubleValue();
        Transaction transaction = new Transaction(creditDouble, null);
        this.transactionList.add(0, transaction);
    }

    public void withdraw(Number debit) {
        Double debitDouble = debit.doubleValue();
        Transaction transaction = new Transaction(null, debitDouble);
        this.transactionList.add(0, transaction);
    }

    public String generateStatement() {

        // collate transaction in reverse order
        // format output, possibly using toString override
        // add header line
        return "you is broke!\nyou is stonez\by broke!";
    }
    public void printList() {
        // For dev visibility and not for the functionality of the class
        double balance = 0.0;

        for (Transaction transaction : this.transactionList) {
            balance = balance + transaction.credit - transaction.debit;
            System.out.print(transaction + "" + balance + transaction.credit + "\n" );
            // The above will invoke the custom toString() method in Transaction
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(1000.00);
        account.withdraw(700.00);
        account.deposit(400);
        account.withdraw(150);
        account.printList();
        System.out.println(account.generateStatement());
    }
}
