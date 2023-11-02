package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Account {
    ArrayList<Transaction> transactionList = new ArrayList<>();
    public void deposit(Number credit) throws Exception {
        if (credit == null) {
            throw new IllegalArgumentException("Deposit value cannot be null");
        }
        Double creditDouble = credit.doubleValue();
        Transaction transaction = new Transaction(creditDouble, null);
        this.transactionList.add(transaction);
    }
    public void withdraw(Number debit) {
        if (debit == null) {
            throw new IllegalArgumentException("Withdrawal value cannot be null");
        }
        Double debitDouble = debit.doubleValue();
        Transaction transaction = new Transaction(null, debitDouble);
        this.transactionList.add(transaction);
    }
    public String generateStatement() {
        double balance = 0.0;
        ArrayList<String> statementLines = new ArrayList<>();
        for (Transaction transaction : this.transactionList) {
            balance = calculateBalance(transaction, balance);
            String statementLine = formatStatementLine(transaction, balance);
            statementLines.add(0, statementLine);
        }
        String header = "date || credit || debit || balance";
        statementLines.add(0, header);
        return String.join("\n", statementLines);
    }
    private static String formatStatementLine(Transaction transaction, Double balance) {
        String date = transaction.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String credit = String.format("%.2f", transaction.credit);
        String debit = String.format("%.2f", transaction.debit);
        String formattedBalance = String.format("%.2f", balance);
        return date + " || " + (transaction.credit != null ? credit : "-") + " || " +
                (transaction.debit != null ? debit : "-") + " || " + formattedBalance;
    }
    private static Double calculateBalance(Transaction transaction, Double balance) {
        if (transaction.credit != null) balance += transaction.credit;
        else balance -= transaction.debit;
        return balance;
    }
    public static void main(String[] args) {
    }
}