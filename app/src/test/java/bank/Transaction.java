package bank;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transaction {
    Double credit;
    Double debit;
    LocalDate date;
    public Transaction(Double credit, Double debit) {
        this.credit = credit;
        this.debit = debit;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        // Formats printout of Transaction objects
        // This is for dev visibility and not for the functionality of the class
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);

        String formattedCredit = String.format("%.2f", credit);
        String formattedDebit = String.format("%.2f", debit);

        return formattedDate + " || " + (credit != null ? formattedCredit : "-") + " || " + (debit != null ? formattedDebit : "-") + " || ";
    }

    public static void main(String[] args) {
//        Transaction pay1 = new Transaction(1000.00, null);
//        System.out.println(pay1.credit + " & " + pay1.debit + " & " + pay1.date);

    }
}
