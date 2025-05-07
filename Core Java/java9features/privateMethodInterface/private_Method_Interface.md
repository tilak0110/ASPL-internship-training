# 💡 Java 9 Feature: Private Methods in Interface

## 📘 Project: Private_Methods_in_Interface

This Java project demonstrates one of the major enhancements introduced in **Java 9** — **Private Methods in Interfaces**. With this feature, developers can now write reusable logic inside interfaces using `private` and `private static` methods, which helps avoid code duplication.

---

## 🧠 Concept Overview

Prior to Java 9:
- Interfaces could only have `abstract`, `default`, and `static` methods.
- Repeating logic in multiple `default` methods was common and error-prone.

With Java 9:
- Interfaces can now have `private` and `private static` methods.
- These can be used **only inside the interface**, to support code reuse between `default` and `static` methods.

---

## 📁 Files in This Project


---

## 🔍 Code Explanation

### 🏦 1. Bank.java

The `Bank` interface defines:
- `getBalance()`, `deposit()`, and `withdrawal()` as abstract methods.
- `executeTransection(...)` as a default method to handle deposit or withdrawal.
- `logTransaction(...)` as a **private method** to log transaction details (Java 9 feature).

```java
package Private_Methods_in_Interface;

public interface Bank {

    double getBalance();

    void deposit(double amount);

    void withdrawal(double amount);

    default void executeTransection(String type , double amount) {
        if (type.equals("WITHDRAWAL")) {
            withdrawal(amount);
            logTransaction(type, amount);
        } else if (type.equals("DEPOSIT")) {
            deposit(amount);
            logTransaction(type, amount);
        } else {
            System.out.println("Transaction Failed");
        }
    }

    private void logTransaction(String type , double amount) {
        // Java 9 feature: Private method inside interface
        System.out.println("Transaction type :" + type);
        System.out.println("Transaction amount :" + amount);
        System.out.println("Final Balance:" + getBalance());
    }
}

package Private_Methods_in_Interface;

public class SavingAccount implements Bank {
    private double balance;

    public SavingAccount(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
    }

    @Override
    public void withdrawal(double amount) {
        balance = balance - amount;
    }
}

package Private_Methods_in_Interface;

public class Test {
    public static void main(String[] args) {
        Bank b = new SavingAccount(1000);
        b.executeTransection("DEPOSIT", 200);
        b.executeTransection("WITHDRAWAL", 300);
        System.out.println("--------------------------------------");
        System.out.println("Current balance in account is " + b.getBalance());
    }
}

Transaction type :DEPOSIT
Transaction amount :200.0
Final Balance:1200.0
Transaction type :WITHDRAWAL
Transaction amount :300.0
Final Balance:900.0
--------------------------------------
Current balance in account is 900.0
