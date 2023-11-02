package bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AccountTest {
    public static String getDate() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }
    @Test
    public void TestShouldInitialiseAccountWithAnEmptyTransactionListArrayList() {
        Account account = new Account();
        int numOfTransactions = account.transactionList.size();
        int expected = 0;
        Assert.assertEquals(expected, numOfTransactions);
    }
    @Test
    public void TestDepositShouldAddAnItemToTheTransactionListArrayList() {
        Account account = new Account();
        account.deposit(1000);
        int numOfTransactions = account.transactionList.size();
        int expected = 1;
        Assert.assertEquals(expected, numOfTransactions);
    }
    @Test
    public void TestMultipleDepositsShouldAddEqualNumberOfItemsToTheTransactionListArrayList() {
        Account account = new Account();
        account.deposit(1000);
        account.deposit(300.00);
        account.deposit(10.0);
        int numOfTransactions = account.transactionList.size();
        int expected = 3;
        Assert.assertEquals(expected, numOfTransactions);
    }
    @Test
    public void TestWithdrawalShouldAddAnItemToTheTransactionListArrayList() {
        Account account = new Account();
        account.withdraw(1000);
        int numOfTransactions = account.transactionList.size();
        int expected = 1;
        Assert.assertEquals(expected, numOfTransactions);
    }
    @Test
    public void TestMultipleWithdrawalsShouldAddEqualNumberOfItemsToTheTransactionListArrayList() {
        Account account = new Account();
        account.withdraw(1000);
        account.withdraw(300.00);
        account.withdraw(10.0);
        int numOfTransactions = account.transactionList.size();
        int expected = 3;
        Assert.assertEquals(expected, numOfTransactions);
    }
    @Test
    public void TestGenerateStatementReturnsHeaderWhenNoTransactionsHaveBeenMade() {
        Account account = new Account();
        String expected = "date || credit || debit || balance";
        String actual = account.generateStatement();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGenerateStatementReturnsProperlyFormattedStatementWithSingleDeposit() {
        Account account = new Account();
        account.deposit(1000);
        String expected = "date || credit || debit || balance\n"
                + MainTest.getDate() + " || 1000.00 || - || 1000.00";
        String actual = account.generateStatement();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGenerateStatementReturnsProperlyFormattedStatementWithSingleWithdrawal() {
        Account account = new Account();
        account.withdraw(1000);
        String expected = "date || credit || debit || balance\n"
                + MainTest.getDate() + " || - || 1000.00 || -1000.00";
        String actual = account.generateStatement();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGenerateStatementReturnsProperlyFormattedStatementWithMultipleTransactionsInReverseOrder() {
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

