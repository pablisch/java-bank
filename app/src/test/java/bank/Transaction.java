package bank;

import java.time.LocalDate;

public class Transaction {
    Double credit;
    Double debit;
    LocalDate date;
    public Transaction(Double credit, Double debit) {
        this.credit = credit;
        this.debit = debit;
        this.date = LocalDate.now();
    }

    public static void main(String[] args) {

    }
}
