# SQL Revision Guide

## 1. Databases and Tables
### Creating and Deleting Databases
- `CREATE DATABASE database_name;`
- `DROP DATABASE IF EXISTS database_name;`
- PostgreSQL: `\c database_name;` (Switch database)

### Creating Tables
- `CREATE TABLE table_name (column_name DATA_TYPE CONSTRAINTS);`
- `DROP TABLE IF EXISTS table_name;`
- `ALTER TABLE table_name ADD COLUMN column_name DATA_TYPE;`

## 2. Basic Queries
### Inserting Data
- `INSERT INTO table_name (column1, column2) VALUES (value1, value2);`
- `INSERT INTO table_name VALUES (value1, value2, value3);`

### Retrieving Data
- `SELECT * FROM table_name;`
- `SELECT column1, column2 FROM table_name;`
- `SELECT DISTINCT column_name FROM table_name;`

### Filtering Data
- `SELECT * FROM table_name WHERE condition;`
- `SELECT * FROM users WHERE age > 25;`
- `SELECT * FROM users WHERE name LIKE 'T%';`

### Sorting Data
- `SELECT * FROM table_name ORDER BY column_name ASC|DESC;`
- `SELECT * FROM users ORDER BY salary DESC;`

### Limiting Results
- `SELECT * FROM users LIMIT 5;`
- `SELECT * FROM users LIMIT 5 OFFSET 2;`

## 3. Updating and Deleting Data
### Updating Data
- `UPDATE table_name SET column1 = value1 WHERE condition;`
- `UPDATE users SET salary = salary + 5000 WHERE age > 30;`

### Deleting Data
- `DELETE FROM table_name WHERE condition;`
- `DELETE FROM users WHERE age < 26;`

## 4. Joins
### Inner Join
- `SELECT users.name, teams.name FROM users JOIN teams ON users.team_id = teams.id;`

### Left Join
- `SELECT users.name, teams.name FROM users LEFT JOIN teams ON users.team_id = teams.id;`

### Right Join
- `SELECT users.name, teams.name FROM users RIGHT JOIN teams ON users.team_id = teams.id;`

### Full Outer Join
- `SELECT users.name, teams.name FROM users FULL OUTER JOIN teams ON users.team_id = teams.id;`

## 5. Aggregation and Grouping
### Aggregate Functions
- `SELECT COUNT(*) FROM users;`
- `SELECT AVG(salary) FROM users;`
- `SELECT SUM(salary) FROM users;`

### Grouping Data
- `SELECT category, COUNT(*) FROM gadgets GROUP BY category;`
- `SELECT team_id, AVG(salary) FROM users GROUP BY team_id;`

## 6. Constraints
### Common Constraints
- `PRIMARY KEY (id)`
- `UNIQUE (email)`
- `NOT NULL`
- `CHECK (age > 18)`

## 7. Indexing
- `CREATE INDEX idx_name ON table_name(column_name);`
- `DROP INDEX idx_name;`

## 8. Views
- `CREATE VIEW view_name AS SELECT column1, column2 FROM table_name;`
- `DROP VIEW view_name;`

## 9. Stored Procedures (MySQL)
```sql
DELIMITER $$
CREATE PROCEDURE GetUsers()
BEGIN
   SELECT * FROM users;
END $$
DELIMITER;
```

## 10. Triggers (MySQL)
```sql
CREATE TRIGGER before_insert_users
BEFORE INSERT ON users
FOR EACH ROW
SET NEW.name = UPPER(NEW.name);
```

## 11. Transactions
- `START TRANSACTION;`
- `COMMIT;`
- `ROLLBACK;`

This document covers essential SQL concepts, ensuring a thorough revision of MySQL and PostgreSQL queries. 🚀

