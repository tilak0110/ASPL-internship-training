# 📅 Date and Time in MySQL (Detailed Explanation)

MySQL provides various **date and time functions** to handle and manipulate temporal data. It includes **DATE, TIME, DATETIME, TIMESTAMP, and YEAR** data types, along with functions to extract, format, and compute date and time values.

---

## 1️⃣ **Date and Time Data Types in MySQL**
| Data Type    | Description |
|-------------|------------|
| `DATE`      | Stores only the date (YYYY-MM-DD) |
| `TIME`      | Stores only time (HH:MI:SS) |
| `DATETIME`  | Stores both date and time (YYYY-MM-DD HH:MI:SS) |
| `TIMESTAMP` | Similar to `DATETIME`, but with automatic timezone conversion |
| `YEAR`      | Stores only year values (YYYY) |

### 📌 **Examples:**
```sql
CREATE TABLE events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    event_name VARCHAR(100),
    event_date DATE,
    event_time TIME,
    created_at DATETIME DEFAULT NOW(),
    event_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## 2️⃣ **Getting the Current Date and Time**
| Function | Description |
|----------|------------|
| `NOW()`  | Returns current date & time (`YYYY-MM-DD HH:MI:SS`) |
| `CURDATE()` | Returns current date (`YYYY-MM-DD`) |
| `CURTIME()` | Returns current time (`HH:MI:SS`) |
| `UTC_TIMESTAMP()` | Returns UTC timestamp |
| `SYSDATE()` | Returns system's current date and time |

### 📌 **Examples:**
```sql
SELECT NOW();         -- Current Date & Time
SELECT CURDATE();     -- Current Date
SELECT CURTIME();     -- Current Time
SELECT UTC_TIMESTAMP(); -- UTC Date-Time
SELECT SYSDATE();     -- System Date & Time
```

---

## 3️⃣ **Extracting Components from Date/Time**
| Function | Description |
|----------|------------|
| `YEAR(date)` | Extracts year from a date |
| `MONTH(date)` | Extracts month from a date |
| `DAY(date)` | Extracts day from a date |
| `HOUR(time)` | Extracts hour from a time |
| `MINUTE(time)` | Extracts minutes from a time |
| `SECOND(time)` | Extracts seconds from a time |

### 📌 **Examples:**
```sql
SELECT YEAR('2025-03-30'); -- 2025
SELECT MONTH('2025-03-30'); -- 3 (March)
SELECT DAY('2025-03-30'); -- 30
SELECT HOUR('12:45:30'); -- 12
SELECT MINUTE('12:45:30'); -- 45
SELECT SECOND('12:45:30'); -- 30
```

---

## 4️⃣ **Formatting Dates and Times**
| Function | Description |
|----------|------------|
| `DATE_FORMAT(date, format)` | Formats a date into a specific pattern |
| `TIME_FORMAT(time, format)` | Formats time values |

### 📌 **Examples:**
```sql
SELECT DATE_FORMAT(NOW(), '%W, %M %e, %Y'); -- Sunday, March 30, 2025
SELECT TIME_FORMAT('18:30:45', '%h:%i %p'); -- 06:30 PM
```

---

## 5️⃣ **Date Calculations (Add / Subtract)**
| Function | Description |
|----------|------------|
| `DATE_ADD(date, INTERVAL value unit)` | Adds a time interval |
| `DATE_SUB(date, INTERVAL value unit)` | Subtracts a time interval |
| `TIMESTAMPADD(unit, value, datetime)` | Adds an interval to a timestamp |
| `TIMESTAMPDIFF(unit, datetime1, datetime2)` | Difference between two timestamps |

### 📌 **Examples:**
```sql
SELECT DATE_ADD('2025-03-30', INTERVAL 7 DAY); -- 2025-04-06
SELECT DATE_SUB('2025-03-30', INTERVAL 1 MONTH); -- 2025-02-28
SELECT TIMESTAMPDIFF(DAY, '2025-03-01', '2025-03-30'); -- 29 Days
```

---

## 6️⃣ **Comparing Dates**
| Operator | Usage |
|----------|-------|
| `=`      | Equals |
| `!=` or `<>` | Not Equal |
| `<`      | Before a date |
| `>`      | After a date |

### 📌 **Examples:**
```sql
SELECT * FROM events WHERE event_date > '2025-04-01';
SELECT * FROM events WHERE event_time BETWEEN '10:00:00' AND '15:00:00';
```

---

## 7️⃣ **Finding Differences Between Dates**
| Function | Description |
|----------|------------|
| `DATEDIFF(date1, date2)` | Returns the difference in days |
| `TIMEDIFF(time1, time2)` | Returns the difference in time |

### 📌 **Examples:**
```sql
SELECT DATEDIFF('2025-04-10', '2025-03-30'); -- 11 Days
SELECT TIMEDIFF('14:30:00', '10:00:00'); -- 04:30:00
```

---

## 📜 **SQL File for Date & Time Functions**

### 📌 **date_time_functions.sql**
```sql
-- Create a table with date and time columns
CREATE TABLE events (
    event_id INT PRIMARY KEY AUTO_INCREMENT,
    event_name VARCHAR(100),
    event_date DATE,
    event_time TIME,
    created_at DATETIME DEFAULT NOW(),
    event_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Inserting sample data
INSERT INTO events (event_name, event_date, event_time)
VALUES ('Conference', '2025-06-15', '10:00:00'),
       ('Workshop', '2025-07-20', '14:30:00');

-- Get current date & time
SELECT NOW(), CURDATE(), CURTIME();

-- Extracting date components
SELECT YEAR(event_date), MONTH(event_date), DAY(event_date) FROM events;

-- Formatting dates and times
SELECT DATE_FORMAT(event_date, '%W, %M %e, %Y') FROM events;
SELECT TIME_FORMAT(event_time, '%h:%i %p') FROM events;

-- Date calculations
SELECT DATE_ADD(event_date, INTERVAL 7 DAY) FROM events;
SELECT DATE_SUB(event_date, INTERVAL 1 MONTH) FROM events;

-- Date comparisons
SELECT * FROM events WHERE event_date > '2025-07-01';

-- Date differences
SELECT DATEDIFF('2025-07-20', '2025-06-15') AS days_difference;
SELECT TIMEDIFF('18:30:00', '14:30:00') AS time_difference;

-- Convert string to date
SELECT STR_TO_DATE('15-06-2025', '%d-%m-%Y');
```


