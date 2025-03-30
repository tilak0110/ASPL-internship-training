# Chapter 2: Identifier

## Overview
This topic covers identifiers, which are the syntax rules for naming tables, columns, and other database objects. The examples include variations used by different SQL implementations.

## Section 2.1: Unquoted Identifiers
Unquoted identifiers can use letters (`a-z`), digits (`0-9`), and underscore (`_`), but must start with a letter.

### Allowed Special Characters in Different SQL Implementations:
- **MS SQL:** `@`, `$`, `#`, and other Unicode letters.
- **MySQL:** `$`.
- **Oracle:** `$`, `#`, and other letters from the database character set.
- **PostgreSQL:** `$` and other Unicode letters.

### Case Sensitivity Handling:
- **MS SQL:** Case-preserving, sensitivity defined by database character set (can be case-sensitive).
- **MySQL:** Case-preserving, sensitivity depends on database setting and underlying file system.
- **Oracle:** Converted to uppercase, then handled like a quoted identifier.
- **PostgreSQL:** Converted to lowercase, then handled like a quoted identifier.
- **SQLite:** Case-preserving; case insensitivity applies only to ASCII characters.

### Examples of Valid and Invalid Identifiers:
#### Valid Identifiers:
```sql
user_id   -- Valid (uses letters and underscore)
orderDate -- Valid (camelCase naming convention)
```

#### Invalid Identifiers:
```sql
_tempTable  -- Invalid (starts with an underscore)
1stColumn   -- Invalid (starts with a digit)
```

Each SQL implementation may have its own specific rules, so always check the respective documentation for precise behavior.

