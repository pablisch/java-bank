package bank;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
    ArrayList<Transaction> transactionList = new ArrayList<>();
    public void deposit(Number credit) {
        Double creditDouble = credit.doubleValue();
        Transaction transaction = new Transaction(creditDouble, null);
        this.transactionList.add(transaction);
    }

    public void withdraw(Number debit) {
        Double debitDouble = debit.doubleValue();
        Transaction transaction = new Transaction(null, debitDouble);
        this.transactionList.add(transaction);
    }

    public String generateStatement() {
        double balance = 0.0;
        ArrayList<String> statementLines = new ArrayList<>();
        for (Transaction transaction : this.transactionList) {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = transaction.date.format(formatter);

            if (transaction.credit != null) balance += transaction.credit;
            else balance -= transaction.debit;

            String formattedCredit = String.format("%.2f", transaction.credit);
            String formattedDebit = String.format("%.2f", transaction.debit);
            String formattedBalance = String.format("%.2f", balance);

            String statementLine = formattedDate + " || " + (transaction.credit != null
                    ? formattedCredit : "-") + " || " + (transaction.debit != null
                    ? formattedDebit : "-") + " || " + formattedBalance;
            statementLines.add(0, statementLine);
        }
        String header = "date || credit || debit || balance";
        statementLines.add(0, header);
        //        System.out.println(statement);
        return String.join("\n", statementLines);
    }

    public static void main(String[] args) {
    }
}