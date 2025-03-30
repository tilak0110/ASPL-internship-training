# Keys in MySQL

## Introduction
Keys in MySQL are essential for establishing relationships between tables and ensuring data integrity. They help in indexing, speeding up queries, and enforcing constraints to maintain consistency in a database.

## Types of Keys

### 1. Primary Key
A **Primary Key** is a unique identifier for a record in a table. It ensures that no duplicate or NULL values exist in the specified column(s).

#### Syntax
```sql
CREATE TABLE students (
    student_id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT
);
```
#### Example
```sql
ALTER TABLE students ADD PRIMARY KEY (student_id);
```
- Only one primary key is allowed per table.
- A primary key can be composed of multiple columns (**Composite Key**).

### 2. Unique Key
A **Unique Key** ensures that all values in a column are distinct, except NULL values (which are allowed).

#### Syntax
```sql
CREATE TABLE employees (
    emp_id INT UNIQUE,
    emp_name VARCHAR(100),
    email VARCHAR(100) UNIQUE
);
```
#### Example
```sql
ALTER TABLE employees ADD UNIQUE (email);
```
- Unlike the primary key, multiple unique keys can exist in a table.

### 3. Foreign Key
A **Foreign Key** establishes a relationship between two tables, ensuring referential integrity.

#### Syntax
```sql
CREATE TABLE orders (
    order_id INT PRIMARY KEY,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);
```
#### Example
```sql
ALTER TABLE orders ADD CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(customer_id);
```
- It prevents actions that would destroy relationships between tables (e.g., deleting a referenced row without handling dependencies).

### 4. Composite Key
A **Composite Key** is a primary or unique key that consists of multiple columns.

#### Syntax
```sql
CREATE TABLE enrollment (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id)
);
```
#### Example
```sql
ALTER TABLE enrollment ADD PRIMARY KEY (student_id, course_id);
```
- Used when a single column cannot uniquely identify a record.

### 5. Super Key
A **Super Key** is a set of attributes that uniquely identifies a record. It may contain redundant attributes that are not necessary for uniqueness.

Example: If `{student_id, name}` uniquely identifies a student, then `student_id` alone may be sufficient.

### 6. Candidate Key
A **Candidate Key** is a minimal super key. It can be used as a primary key because it uniquely identifies records.

Example: In the `students` table, both `student_id` and `email` could be candidate keys.

### 7. Alternate Key
An **Alternate Key** is a candidate key that was not chosen as the primary key.

Example: If `student_id` is chosen as the primary key, then `email` becomes an alternate key.

### 8. Surrogate Key
A **Surrogate Key** is an artificial key (e.g., an auto-incremented column) used when no natural primary key exists.

#### Syntax
```sql
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    email VARCHAR(100)
);
```

## Conclusion
Keys are fundamental in MySQL for enforcing data integrity and optimizing queries. Choosing the right type of key depends on the data model and the relationships between tables.

