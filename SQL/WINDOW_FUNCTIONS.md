# Window Functions in MySQL

## Introduction
Window functions in MySQL allow you to perform calculations across a set of table rows related to the current row. Unlike aggregate functions (like `SUM`, `AVG`, `COUNT`), window functions **do not collapse rows**; instead, they compute values over a "window" of rows defined by an `OVER()` clause.

### Key Characteristics of Window Functions:
- They **perform calculations across multiple rows** without grouping them.
- They are often used for **ranking, running totals, moving averages, and percentiles**.
- They operate within a **window (partition)** defined using `PARTITION BY` and `ORDER BY`.

---

## 1. Syntax of Window Functions
```sql
SELECT column_name,
       window_function() OVER (PARTITION BY column_name ORDER BY column_name) AS alias_name
FROM table_name;
```
- `window_function()`: Any supported window function (e.g., `ROW_NUMBER()`, `RANK()`, `SUM()`, etc.).
- `PARTITION BY`: Divides the result set into partitions where the function is applied separately.
- `ORDER BY`: Defines the logical order of rows within each partition.

---

## 2. Types of Window Functions in MySQL

### A. Ranking Functions

1. **ROW_NUMBER()** – Assigns a unique rank to each row.
   ```sql
   SELECT id, name, salary,
          ROW_NUMBER() OVER (ORDER BY salary DESC) AS row_num
   FROM employees;
   ```

2. **RANK()** – Assigns a rank to each row, but **ties (duplicates) get the same rank**, and the next rank is skipped.
   ```sql
   SELECT id, name, salary,
          RANK() OVER (ORDER BY salary DESC) AS rank_num
   FROM employees;
   ```

3. **DENSE_RANK()** – Similar to `RANK()`, but **does not skip** ranks.
   ```sql
   SELECT id, name, salary,
          DENSE_RANK() OVER (ORDER BY salary DESC) AS dense_rank_num
   FROM employees;
   ```

---

### B. Aggregate Window Functions

4. **SUM()** – Running total over a partition.
   ```sql
   SELECT id, name, department, salary,
          SUM(salary) OVER (PARTITION BY department ORDER BY id) AS running_total
   FROM employees;
   ```

5. **AVG()** – Running average.
   ```sql
   SELECT id, name, department, salary,
          AVG(salary) OVER (PARTITION BY department ORDER BY id) AS running_avg
   FROM employees;
   ```

6. **COUNT()** – Running count of records.
   ```sql
   SELECT id, name, department,
          COUNT(*) OVER (PARTITION BY department ORDER BY id) AS count_per_dept
   FROM employees;
   ```

7. **MAX() / MIN()** – Fetches maximum and minimum values within partitions.
   ```sql
   SELECT id, name, department, salary,
          MAX(salary) OVER (PARTITION BY department) AS max_salary_per_dept,
          MIN(salary) OVER (PARTITION BY department) AS min_salary_per_dept
   FROM employees;
   ```

---

### C. Navigation Functions

8. **LAG()** – Retrieves the value from the **previous row**.
   ```sql
   SELECT id, name, salary,
          LAG(salary, 1, 0) OVER (ORDER BY id) AS prev_salary
   FROM employees;
   ```

9. **LEAD()** – Retrieves the value from the **next row**.
   ```sql
   SELECT id, name, salary,
          LEAD(salary, 1, 0) OVER (ORDER BY id) AS next_salary
   FROM employees;
   ```

10. **FIRST_VALUE()** – Returns the first value in the partition.
    ```sql
    SELECT id, name, department, salary,
           FIRST_VALUE(salary) OVER (PARTITION BY department ORDER BY id) AS first_salary
    FROM employees;
    ```

11. **LAST_VALUE()** – Returns the last value in the partition.
    ```sql
    SELECT id, name, department, salary,
           LAST_VALUE(salary) OVER (PARTITION BY department ORDER BY id ROWS BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING) AS last_salary
    FROM employees;
    ```

12. **NTILE(n)** – Splits data into `n` equal buckets.
    ```sql
    SELECT id, name, salary,
           NTILE(4) OVER (ORDER BY salary DESC) AS quartile
    FROM employees;
    ```

---

## 3. Practical Examples

### Example 1: Find Employee Rank Based on Salary
```sql
SELECT id, name, salary,
       RANK() OVER (ORDER BY salary DESC) AS rank
FROM employees;
```

### Example 2: Find Previous and Next Salary of Each Employee
```sql
SELECT id, name, salary,
       LAG(salary) OVER (ORDER BY salary) AS previous_salary,
       LEAD(salary) OVER (ORDER BY salary) AS next_salary
FROM employees;
```

### Example 3: Calculate Running Total of Salaries per Department
```sql
SELECT id, name, department, salary,
       SUM(salary) OVER (PARTITION BY department ORDER BY id) AS running_total
FROM employees;
```

---

## 4. Key Differences Between Aggregate and Window Functions

| Feature             | Aggregate Functions (`GROUP BY`) | Window Functions (`OVER()`) |
|---------------------|--------------------------------|---------------------------|
| Row Preservation   | Collapses rows                | Retains all rows         |
| Result per Row     | One result per group          | One result per row       |
| Use of PARTITION   | Requires `GROUP BY`          | Uses `PARTITION BY`      |
| Use of ORDER       | Not applicable               | Uses `ORDER BY`          |
| Example            | `SUM(salary) GROUP BY dept`  | `SUM(salary) OVER(PARTITION BY dept)` |

---

## 5. Best Practices for Using Window Functions

- **Use `PARTITION BY` wisely** – Too many partitions can slow queries.
- **Be mindful of performance** – Large datasets with complex window functions can slow execution.
- **Avoid unnecessary sorting** – `ORDER BY` inside `OVER()` adds computation time.
- **Use indexing for performance** – Indexing `ORDER BY` columns helps.
- **Compare with `GROUP BY`** – Sometimes aggregate functions are more efficient.

---

## 6. Conclusion
Window functions in MySQL are powerful for analytical queries, allowing ranking, running totals, moving averages, and data comparisons. They help retain all rows while computing results over a defined window, making them a better choice for reporting and analytical queries compared to traditional aggregate functions.

---

### Next Steps:
- Try these queries in MySQL to practice.
- Experiment with different partitions and orderings.
- Use them in real-world analytics, like sales trends and employee rankings.

