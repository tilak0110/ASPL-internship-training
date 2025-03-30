# LIKE Operator in MySQL

The `LIKE` operator is used in SQL to search for a specified pattern in a column. It is often used with the `WHERE` clause to filter results based on patterns. Wildcards are used to define the pattern.

## 1. Match Open-Ended Pattern
This allows you to find values that start or end with a specific substring.

```sql
SELECT * FROM employees WHERE name LIKE 'A%'; -- Finds names starting with 'A'
SELECT * FROM employees WHERE name LIKE '%son'; -- Finds names ending with 'son'
```

## 2. Single Character Match
Use the `_` wildcard to match a single character at a specific position.

```sql
SELECT * FROM employees WHERE name LIKE 'J_n'; -- Matches 'Jon', 'Jan', etc.
```

## 3. ESCAPE Statement in the LIKE-query
If you need to search for actual wildcard characters (`%` or `_`), use `ESCAPE`.

```sql
SELECT * FROM files WHERE path LIKE 'C:\\%backup' ESCAPE '\\'; -- Finds paths like 'C:\backup'
```

## 4. Search for a Range of Characters
Use square brackets `[]` to specify character ranges or sets (not supported in MySQL, but can be emulated using `LIKE`).

```sql
SELECT * FROM products WHERE code LIKE 'A[0-9]%'; -- Emulated with REGEXP
SELECT * FROM products WHERE code REGEXP '^A[0-9]';
```

## 5. Match by Range or Set
Use `LIKE` with `REGEXP` for more complex patterns.

```sql
SELECT * FROM students WHERE name REGEXP '^[A-C]'; -- Names starting with A, B, or C
```

## 6. Wildcard Characters in LIKE
| Wildcard | Description |
|----------|-------------|
| `%`      | Matches zero or more characters |
| `_`      | Matches a single character |

Example:

```sql
SELECT * FROM customers WHERE email LIKE '%@gmail.com'; -- Find Gmail users
```

---

This section provides an in-depth explanation of the `LIKE` operator in MySQL. Let me know if you need modifications or the next section! 🚀

