# CREATE TABLE in MySQL - A Detailed Guide

## Introduction
The `CREATE TABLE` statement in MySQL is used to create a new table in the database. It allows defining column names, data types, constraints, indexes, and storage options.

---
## Basic Syntax
```sql
CREATE TABLE table_name (
    column1 datatype constraints,
    column2 datatype constraints,
    ...
);
```

### Example:
```sql
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INT CHECK (age >= 18),
    department_id INT,
    salary DECIMAL(10,2),
    joining_date DATE DEFAULT CURRENT_DATE
);
```

---
## Column Data Types
MySQL supports various data types. Here are some common ones:

### Numeric Data Types
- `INT`, `BIGINT`, `TINYINT`, `SMALLINT`, `MEDIUMINT`
- `DECIMAL(m, d)`, `FLOAT`, `DOUBLE`

### String Data Types
- `VARCHAR(n)`, `TEXT`, `CHAR(n)`, `ENUM`, `SET`

### Date & Time Data Types
- `DATE`, `DATETIME`, `TIMESTAMP`, `TIME`

---
## Adding Constraints
Constraints help enforce rules at the database level.

### PRIMARY KEY
Ensures unique identification of each row.
```sql
CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(100) UNIQUE
);
```

### NOT NULL
Ensures that a column cannot have NULL values.
```sql
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);
```

### UNIQUE
Ensures all values in a column are unique.
```sql
CREATE TABLE users (
    email VARCHAR(255) UNIQUE NOT NULL
);
```

### CHECK
Defines conditions for column values.
```sql
CREATE TABLE products (
    price DECIMAL(10,2) CHECK (price > 0)
);
```

### DEFAULT
Sets a default value if no value is provided.
```sql
CREATE TABLE orders (
    order_date DATE DEFAULT CURRENT_DATE
);
```

### FOREIGN KEY
Creates a relationship between tables.
```sql
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
```

---
## Table Options
You can specify storage engines and other options.

### Example:
```sql
CREATE TABLE logs (
    log_id INT PRIMARY KEY,
    log_message TEXT
) ENGINE=InnoDB;
```

### AUTO_INCREMENT
Automatically increases the column value.
```sql
CREATE TABLE invoices (
    invoice_id INT PRIMARY KEY AUTO_INCREMENT
);
```

---
## Temporary Tables
These tables exist only during a session.
```sql
CREATE TEMPORARY TABLE temp_sales (
    id INT,
    amount DECIMAL(10,2)
);
```

---
## Creating Tables from Other Tables
```sql
CREATE TABLE backup_employees AS
SELECT * FROM employees;
```

---
## Partitioning Tables
MySQL allows partitioning for large datasets.
```sql
CREATE TABLE sales (
    sale_id INT NOT NULL,
    sale_date DATE NOT NULL
) PARTITION BY RANGE(YEAR(sale_date)) (
    PARTITION p0 VALUES LESS THAN (2020),
    PARTITION p1 VALUES LESS THAN (2025)
);
```

---
## Conclusion
The `CREATE TABLE` statement is fundamental to MySQL database design. Understanding its syntax, data types, constraints, and options helps in creating efficient and structured databases.

