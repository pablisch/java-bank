package bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainTest {
    public static String getDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
    @Test
    public void testReturnsHeaderWhenThereAreNoTransactions() throws Exception {
        Account account = new Account();
        String expected = "date || credit || debit || balance";
        String actual = account.generateStatement();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testReturnsProperlyFormattedStatementWithSingleDeposit() throws Exception {
        Account account = new Account();
        account.deposit(1000);
        String expected = "date || credit || debit || balance\n"
                + MainTest.getDate() + " || 1000.00 || - || 1000.00";
        String actual = account.generateStatement();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testReturnsProperlyFormattedStatementWithSingleWithdrawal() {
        Account account = new Account();
        account.withdraw(1000);
        String expected = "date || credit || debit || balance\n"
                + MainTest.getDate() + " || - || 1000.00 || -1000.00";
        String actual = account.generateStatement();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testReturnsProperlyFormattedStatementWithMultipleTransactionsInReverseOrder() throws Exception {
        Account account = new Account();
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(800);
        account.withdraw(300);
        String expected = "date || credit || debit || balance\n"
                + MainTest.getDate() + " || - || 300.00 || 1000.00\n"
                + MainTest.getDate() + " || 800.00 || - || 1300.00\n"
                + MainTest.getDate() + " || - || 500.00 || 500.00\n"
                + MainTest.getDate() + " || 1000.00 || - || 1000.00";
        String actual = account.generateStatement();
        Assert.assertEquals(expected, actual);
    }
}
