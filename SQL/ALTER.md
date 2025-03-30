# ALTER TABLE in MySQL

The `ALTER TABLE` statement in MySQL is used to modify an existing table structure. It allows you to add, delete, or modify columns, constraints, and other table properties.

---

## 1. Adding a Column
To add a new column to a table, use the `ADD COLUMN` statement.
```sql
ALTER TABLE employees ADD COLUMN salary DECIMAL(10,2);
```
✅ Adds a `salary` column of type `DECIMAL(10,2)` to the `employees` table.

You can also specify the column's position:
```sql
ALTER TABLE employees ADD COLUMN age INT AFTER name;
```
✅ Adds the `age` column after the `name` column.

---

## 2. Dropping a Column
To remove an existing column from a table, use `DROP COLUMN`:
```sql
ALTER TABLE employees DROP COLUMN age;
```
✅ Removes the `age` column from the `employees` table.

⚠ **Note:** Dropping a column is irreversible and will delete all its data.

---

## 3. Modifying a Column
To change a column's data type or attributes, use `MODIFY COLUMN`:
```sql
ALTER TABLE employees MODIFY COLUMN salary BIGINT;
```
✅ Changes the `salary` column's data type to `BIGINT`.

If you need to rename the column and change its type, use `CHANGE COLUMN`:
```sql
ALTER TABLE employees CHANGE COLUMN salary annual_salary DECIMAL(12,2);
```
✅ Renames `salary` to `annual_salary` and changes its data type.

---

## 4. Renaming a Table
To rename an existing table:
```sql
ALTER TABLE employees RENAME TO staff;
```
✅ Renames the `employees` table to `staff`.

---

## 5. Adding Constraints
### Adding a PRIMARY KEY
```sql
ALTER TABLE employees ADD PRIMARY KEY (id);
```
✅ Sets the `id` column as the primary key.

### Adding a FOREIGN KEY
```sql
ALTER TABLE orders ADD CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(id);
```
✅ Creates a foreign key `fk_customer` linking `orders.customer_id` to `customers.id`.

### Adding a UNIQUE Constraint
```sql
ALTER TABLE employees ADD CONSTRAINT unique_email UNIQUE (email);
```
✅ Ensures that all `email` values in the `employees` table are unique.

---

## 6. Dropping Constraints
### Dropping a PRIMARY KEY
```sql
ALTER TABLE employees DROP PRIMARY KEY;
```
✅ Removes the primary key constraint.

### Dropping a FOREIGN KEY
```sql
ALTER TABLE orders DROP FOREIGN KEY fk_customer;
```
✅ Removes the `fk_customer` foreign key constraint.

### Dropping a UNIQUE Constraint
```sql
ALTER TABLE employees DROP INDEX unique_email;
```
✅ Removes the unique constraint on `email`.

---

## 7. Changing Auto-Increment Value
To reset an `AUTO_INCREMENT` column:
```sql
ALTER TABLE employees AUTO_INCREMENT = 1000;
```
✅ Resets the auto-increment counter to `1000`.

---

## 8. Changing the Storage Engine
To change a table's storage engine (e.g., from `MyISAM` to `InnoDB`):
```sql
ALTER TABLE employees ENGINE = InnoDB;
```
✅ Converts the table to use the `InnoDB` storage engine.

---

## Summary
| Operation | SQL Command |
|-----------|------------|
| Add a column | `ALTER TABLE table_name ADD COLUMN column_name data_type;` |
| Drop a column | `ALTER TABLE table_name DROP COLUMN column_name;` |
| Modify a column | `ALTER TABLE table_name MODIFY COLUMN column_name new_data_type;` |
| Rename a column | `ALTER TABLE table_name CHANGE COLUMN old_name new_name new_data_type;` |
| Rename a table | `ALTER TABLE old_table_name RENAME TO new_table_name;` |
| Add a primary key | `ALTER TABLE table_name ADD PRIMARY KEY (column_name);` |
| Drop a primary key | `ALTER TABLE table_name DROP PRIMARY KEY;` |
| Add a foreign key | `ALTER TABLE table_name ADD CONSTRAINT fk_name FOREIGN KEY (column) REFERENCES other_table(column);` |
| Drop a foreign key | `ALTER TABLE table_name DROP FOREIGN KEY fk_name;` |
| Set auto-increment value | `ALTER TABLE table_name AUTO_INCREMENT = value;` |
| Change storage engine | `ALTER TABLE table_name ENGINE = InnoDB;` |

---

This guide provides a comprehensive overview of how to use `ALTER TABLE` in MySQL to modify table structures effectively. 🚀

