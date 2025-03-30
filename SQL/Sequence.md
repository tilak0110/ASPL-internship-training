# SEQUENCE in PostgreSQL

## Introduction
A **SEQUENCE** in PostgreSQL is a database object used to generate unique numeric values. It is commonly used for **auto-incrementing** primary keys.

## Creating a SEQUENCE
To create a sequence, use the `CREATE SEQUENCE` command:
```sql
CREATE SEQUENCE my_sequence
START WITH 1  -- Initial value
INCREMENT BY 1; -- Step value
```
- `START WITH`: Defines the starting value.
- `INCREMENT BY`: Specifies the step size.

## Using a SEQUENCE
To get the next value from a sequence:
```sql
SELECT nextval('my_sequence');
```
To get the current value without incrementing:
```sql
SELECT currval('my_sequence');
```
To reset a sequence:
```sql
ALTER SEQUENCE my_sequence RESTART WITH 1;
```

## Using SEQUENCE with a Table
You can use a sequence in a table column:
```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY, -- Uses an implicit sequence
    name VARCHAR(100)
);
```
Alternatively, explicitly link a sequence:
```sql
CREATE TABLE orders (
    id INT PRIMARY KEY DEFAULT nextval('my_sequence'),
    order_name VARCHAR(255)
);
```

## Dropping a SEQUENCE
To remove a sequence permanently:
```sql
DROP SEQUENCE my_sequence;
```

## Conclusion
Sequences in PostgreSQL provide an efficient way to generate unique numeric identifiers, ensuring consistency and avoiding conflicts in auto-generated values.

