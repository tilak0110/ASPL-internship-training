package java9features.privateMethodInterface;

public class SavingAccount implements Bank{
    private double balance ;

    public SavingAccount(double balance) {
        this.balance = balance;
    }

    public double getAmount() {
        return balance;
    }

    public void setAmount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance ;

    }

    @Override
    public void deposit(double amount) {
        balance = balance+amount ;
    }

    @Override
    public void withdrawal(double amount) {
        balance = balance-amount ;
    }
}
