package bank;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

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
        Transaction pay1 = new Transaction(1000.00, null);
        System.out.println(pay1.credit + " & " + pay1.debit);
        Transaction pay2 = new Transaction(null, 500.00);
        System.out.println(pay2.credit + " & " + pay2.debit);
    }
}
