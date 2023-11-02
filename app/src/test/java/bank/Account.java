package bank;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {
    ArrayList<Transaction> transactionList = new ArrayList<>();
    public void deposit(Number credit) {
        Transaction transaction = new Transaction(credit, null);
        this.transactionList.add(transaction);
    }

    public void withdraw(Number debit) {
        Transaction transaction = new Transaction(null, debit);
        this.transactionList.add(transaction);
    }

    public String generateStatement() {
        return "you is broke!";
    }
    public void printList() {
        // For dev visibility and not for the functionality of the class
        for (Transaction transaction : this.transactionList) {
            System.out.println(transaction);
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
    }
}
