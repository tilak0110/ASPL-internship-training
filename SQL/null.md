# NULL Handling in SQL

## 1. Filtering NULL Values in Queries
```sql
-- Retrieve employees who do not have a manager (ManagerId is NULL)
SELECT * FROM Employees WHERE ManagerId IS NULL;

-- Retrieve employees who have a manager (ManagerId is NOT NULL)
SELECT * FROM Employees WHERE ManagerId IS NOT NULL;
```

## 2. Creating a Table with NULL and NOT NULL Constraints
```sql
CREATE TABLE MyTable (
    MyCol1 INT NOT NULL, -- Cannot be NULL
    MyCol2 INT NULL      -- Can accept NULL values
);
```

## 3. Inserting NULL Values
```sql
-- This works because MyCol2 allows NULL
INSERT INTO MyTable (MyCol1, MyCol2) VALUES (1, NULL);

-- This will fail because MyCol1 does not allow NULL
-- INSERT INTO MyTable (MyCol1, MyCol2) VALUES (NULL, 2);
```

## 4. Updating a Field to NULL
```sql
-- Set the ManagerId of an employee to NULL (meaning they have no manager)
UPDATE Employees
SET ManagerId = NULL
WHERE Id = 4;
```

## 5. Inserting a Row with NULL Values
```sql
INSERT INTO Employees
(Id, FName, LName, PhoneNumber, ManagerId, DepartmentId, Salary, HireDate)
VALUES
(5, 'Jane', 'Doe', NULL, NULL, 2, 800, '2016-07-22');
```

## 6. Using COALESCE to Replace NULL with a Default Value
```sql
-- Show employee names and their manager IDs, replacing NULL with 'No Manager'
SELECT Id, FName, LName, COALESCE(CAST(ManagerId AS VARCHAR), 'No Manager') AS Manager
FROM Employees;
```

## 7. Handling NULL in Aggregations
```sql
-- Count total employees, including those with NULL ManagerId
SELECT COUNT(*) FROM Employees;

-- Count employees with a ManagerId (ignores NULL values)
SELECT COUNT(ManagerId) FROM Employees;
```

