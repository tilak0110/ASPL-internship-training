package ddd;

public class Main {
    public static void main(String[] args) {
        AccountRepository repo = new AccountRepository();
        AccountService service = new AccountService(repo);

        BankAccount account = new BankAccount("ACC123");
        repo.save(account);

        service.deposit("ACC123", 1000);
        service.withdraw("ACC123", 300);
        service.printStatement("ACC123");
    }
}