# Filter Results Using WHERE and HAVING

## 1. Use BETWEEN to Filter Results
The `BETWEEN` operator is used to filter results within a specific range.

```sql
SELECT * FROM employees
WHERE salary BETWEEN 50000 AND 100000;
```

## 2. Use HAVING with Aggregate Functions
The `HAVING` clause is used to filter groups based on aggregate functions.

```sql
SELECT department, COUNT(*) AS employee_count
FROM employees
GROUP BY department
HAVING COUNT(*) > 5;
```

## 3. WHERE Clause with NULL/NOT NULL Values
The `WHERE` clause can be used to filter records that contain `NULL` values.

```sql
SELECT * FROM employees
WHERE manager_id IS NULL;
```

```sql
SELECT * FROM employees
WHERE manager_id IS NOT NULL;
```

## 4. Equality Condition
The `WHERE` clause returns rows that match the exact criteria.

```sql
SELECT * FROM employees
WHERE department = 'IT';
```

## 5. WHERE Clause with AND and OR
The `AND` and `OR` operators are used to combine multiple conditions.

```sql
SELECT * FROM employees
WHERE department = 'IT' AND salary > 60000;
```

```sql
SELECT * FROM employees
WHERE department = 'IT' OR department = 'HR';
```

## 6. Use IN to Return Rows with a Value Contained in a List
The `IN` clause is used to filter records based on multiple values.

```sql
SELECT * FROM employees
WHERE department IN ('IT', 'HR', 'Finance');
```

## 7. Use LIKE to Find Matching Strings and Substrings
The `LIKE` operator is used to search for patterns in text fields.

```sql
SELECT * FROM employees
WHERE name LIKE 'J%';  -- Names starting with 'J'
```

```sql
SELECT * FROM employees
WHERE name LIKE '%son';  -- Names ending with 'son'
```

## 8. WHERE EXISTS
The `EXISTS` clause checks whether a subquery returns any rows.

```sql
SELECT * FROM employees e
WHERE EXISTS (
    SELECT 1 FROM departments d
    WHERE e.department_id = d.department_id
);
```

## 9. Use HAVING to Check for Multiple Conditions in a Group
The `HAVING` clause allows filtering after grouping.

```sql
SELECT department, AVG(salary) AS avg_salary
FROM employees
GROUP BY department
HAVING AVG(salary) > 70000 AND COUNT(*) > 10;
