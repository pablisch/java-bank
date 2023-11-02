package bank;

import java.time.LocalDate;

public class Transaction {
    Number credit;
    Number debit;
    LocalDate date;
    public Transaction(Number credit, Number debit) {
        this.credit = credit;
        this.debit = debit;
        this.date = LocalDate.now();
    }

    @Override
    public String toString() {
        // Formats printout of Transaction objects
        // This is for dev visibility and not for the functionality of the class
        return "Transaction: Credit=" + credit + ", Debit=" + debit + ", Date=" + date;
    }
    public static void main(String[] args) {
//        Transaction pay1 = new Transaction(1000.00, null);
//        System.out.println(pay1.credit + " & " + pay1.debit + " & " + pay1.date);

    }
}
