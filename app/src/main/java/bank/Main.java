package bank;

public class Main {
    public static void main(String[] args) throws Exception {
        Account account = new Account();
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        System.out.println(account.generateStatement());
    }
}