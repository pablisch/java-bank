package bank;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class TransactionTest {
    public static LocalDate getDate() {
        return LocalDate.now();
    }
    @Test
    public void TestReturnsDepositTransactionObjectWithPositiveCreditValue() {
        Transaction transaction = new Transaction(1000.0, null);
        Double credit = transaction.credit;
        Double expected = 1000.0;
        Assert.assertEquals(expected, credit);
    }@Test
    public void TestReturnsNullDepositTransactionObjectNullCreditValue() {
        Transaction transaction = new Transaction(null, null);
        Double credit = transaction.credit;
        Double expected = null;
        Assert.assertEquals(expected, credit);
    }
    @Test
    public void TestReturnsWithdrawalTransactionObjectWithNullCreditValue() {
        Transaction transaction = new Transaction(null, 1000.0);
        Double credit = transaction.credit;
        Assert.assertNull(credit);
    }
    @Test
    public void TestReturnsWithdrawalTransactionObjectWithPositiveDebitValue() {
        Transaction transaction = new Transaction(null, 1000.0);
        Double debit = transaction.debit;
        Double expected = 1000.0;
        Assert.assertEquals(expected, debit);
    }
    @Test
    public void TestReturnsNullWithdrawalTransactionObjectNullCreditValue() {
        Transaction transaction = new Transaction(null, null);
        Double debit = transaction.debit;
        Double expected = null;
        Assert.assertEquals(expected, debit);
    }
    @Test
    public void TestReturnsDepositTransactionObjectWithNullDebitValue() {
        Transaction transaction = new Transaction(1000.0, null);
        Double credit = transaction.debit;
        Assert.assertNull(credit);
    }
    @Test
    public void TestReturnsTransactionObjectWithDate() {
        Transaction transaction = new Transaction(1000.0, null);
        LocalDate date = transaction.date;
        LocalDate expectedDate = TransactionTest.getDate();
        Assert.assertEquals(expectedDate, date);
    }
}
