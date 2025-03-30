# Transactions in MySQL

## 1. What is a Transaction?
A **transaction** in MySQL is a sequence of one or more SQL statements executed as a single unit of work. A transaction ensures **data consistency, integrity, and reliability** by following the **ACID** properties:

### ACID Properties:
- **Atomicity**: Ensures that a transaction is either fully completed or fully rolled back.
- **Consistency**: Guarantees that the database remains in a valid state before and after the transaction.
- **Isolation**: Ensures that concurrent transactions do not interfere with each other.
- **Durability**: Ensures that once a transaction is committed, it remains permanently stored even in case of a system failure.

## 2. Enabling Transactions in MySQL
Transactions work with storage engines that support them, such as **InnoDB**. Ensure your tables use `InnoDB`:
```sql
CREATE TABLE Accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    balance DECIMAL(10,2) NOT NULL,
    CHECK (balance >= 0)
) ENGINE=InnoDB;
```

## 3. Transaction Control Statements
### 3.1 **Starting a Transaction**
Use `START TRANSACTION` or `BEGIN`:
```sql
START TRANSACTION;
-- OR
BEGIN;
```

### 3.2 **Committing a Transaction**
To permanently save changes:
```sql
COMMIT;
```

### 3.3 **Rolling Back a Transaction**
To undo changes if something goes wrong:
```sql
ROLLBACK;
```

### 3.4 **Setting Savepoints**
Savepoints allow partial rollbacks within a transaction:
```sql
SAVEPOINT sp1;
-- Some operations
ROLLBACK TO sp1;
```

## 4. Example: Bank Transfer with Transactions
```sql
START TRANSACTION;

UPDATE Accounts SET balance = balance - 500 WHERE id = 1; -- Deduct from sender
UPDATE Accounts SET balance = balance + 500 WHERE id = 2; -- Add to receiver

-- If both updates succeed, commit the transaction
COMMIT;

-- If any issue occurs, rollback the transaction
ROLLBACK;
```

## 5. Transaction Isolation Levels
Isolation levels define how transactions interact with each other.

### Available Levels:
1. **READ UNCOMMITTED** - Allows reading uncommitted changes (dirty reads).
2. **READ COMMITTED** - Only committed changes are visible.
3. **REPEATABLE READ** (Default in MySQL) - Ensures consistent reads during a transaction.
4. **SERIALIZABLE** - Strictest isolation, forcing transactions to execute sequentially.

### Changing the Isolation Level:
```sql
SET TRANSACTION ISOLATION LEVEL REPEATABLE READ;
```

## 6. Best Practices for Using Transactions
- Use **transactions only when necessary** to avoid performance overhead.
- Always **commit or rollback** explicitly to avoid hanging transactions.
- Use **indexes** to speed up transactional queries.
- Ensure **proper error handling** in applications using transactions.

---
### Conclusion
Transactions in MySQL ensure data integrity and consistency, making them essential for critical operations like financial transactions, order processing, and inventory management. By following best practices, you can optimize database performance and reliability.

