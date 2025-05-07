package java9features.privateMethodInterface;

public class Test {
    public static void main(String[] args) {
        Bank b = new SavingAccount(1000) ;
        b.executeTransection("DEPOSIT",200);
        b.executeTransection("WITHDRAWAL" , 300);
        System.out.println("--------------------------------------");
        System.out.println("Current balance in account is "+ b.getBalance());
    }
}
