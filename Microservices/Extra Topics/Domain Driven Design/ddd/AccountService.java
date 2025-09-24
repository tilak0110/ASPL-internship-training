package ddd;
public class AccountService {
    private AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void deposit(String accountId, double amount) {
        BankAccount account = repository.find(accountId);
        account.deposit(amount);
        repository.save(account);
    }

    public void withdraw(String accountId, double amount) {
        BankAccount account = repository.find(accountId);
        account.withdraw(amount);
        repository.save(account);
    }

    public void printStatement(String accountId) {
        BankAccount account = repository.find(accountId);
        System.out.println("Account ID: " + account.getAccountId());
        System.out.println("Balance: " + account.getBalance());
        for (Transaction tx : account.getTransactions()) {
            System.out.println(tx.getTimestamp() + " - " + tx.getType() + ": ₹" + tx.getAmount());
        }
    }
}