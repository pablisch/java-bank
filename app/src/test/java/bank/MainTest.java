package bank;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testReturnsProperlyFormattedStatementWithSingleDeposit() {
        Account account = new Account();
        account.deposit(1000);
        String expected = "date || credit || debit || balance\n02/11/2023 || 1000.00 || - || 1000.00";
        String actual = account.generateStatement();
        Assert.assertEquals(expected, actual);
    }
//    @Test
//    public void testReturnsProperlyFormattedStatementWithTransactionInReverseOrder() {
//        Account account = new Account();
//        account.deposit(1000);
//        account.deposit(2000);
//        account.withdraw(500);
//        String actual = account.generateStatement();
//    }
}
