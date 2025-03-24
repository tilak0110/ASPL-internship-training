# Java Fundamentals

## 1. Introduction to Java

- Java is a high-level, object-oriented programming language.
- It follows the **Write Once, Run Anywhere (WORA)** principle.
- Java applications run on **JVM (Java Virtual Machine)**.

### Features of Java

- Platform Independent
- Object-Oriented
- Secure and Robust
- Multi-threaded
- High Performance (JIT Compiler)
- Memory Management (Garbage Collection)

### Setting up Java Environment

1. Install **JDK (Java Development Kit)**
2. Install **IDE** (IntelliJ IDEA, Eclipse, or VS Code)
3. Verify installation:
   ```sh
   java -version
   javac -version
   ```

---

## 2. Basics of Java Programming

### Hello World Program

```java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

### Java Syntax & Rules

- Case-sensitive
- Class names start with an uppercase letter
- Statements end with `;`
- Curly braces `{}` define code blocks

---

## 3. Data Types & Variables

### Primitive Data Types

| Type    | Size | Example |
| ------- | ---- | ------- |
| byte    | 1B   | 100     |
| short   | 2B   | 30000   |
| int     | 4B   | 100000  |
| long    | 8B   | 100000L |
| float   | 4B   | 3.14f   |
| double  | 8B   | 3.14159 |
| char    | 2B   | 'A'     |
| boolean | 1b   | true    |

### Variable Declaration

```java
int age = 25;
double price = 99.99;
char grade = 'A';
boolean isJavaFun = true;
```

---

## 4. Operators in Java

### Arithmetic Operators

```java
int sum = 10 + 5; // 15
int remainder = 10 % 3; // 1
```

### Logical Operators

```java
boolean result = (10 > 5) && (5 < 3); // false
```

### Assignment Operators

```java
int a = 10;
a += 5; // a = 15
```

---

## 5. Control Statements

### If-Else

```java
int age = 18;
if (age >= 18) {
    System.out.println("You can vote.");
} else {
    System.out.println("You cannot vote.");
}
```

### Switch Case

```java
int day = 2;
switch (day) {
    case 1: System.out.println("Monday"); break;
    case 2: System.out.println("Tuesday"); break;
    default: System.out.println("Other Day");
}
```

### Loops

#### For Loop

```java
for(int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

#### While Loop

```java
int i = 1;
while(i <= 5) {
    System.out.println(i);
    i++;
}
```

---

## 6. Arrays

### Declaration & Initialization

```java
int[] numbers = {10, 20, 30, 40, 50};
System.out.println(numbers[2]); // 30
```

### Looping Through an Array

```java
for(int num : numbers) {
    System.out.println(num);
}
```

---

## 7. Object-Oriented Programming (OOPs)

### Classes & Objects

```java
class Car {
    String brand;
    int speed;
    
    void display() {
        System.out.println(brand + " is moving at " + speed + " km/h");
    }
}
```

### Encapsulation

```java
class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
```

### Inheritance

```java
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog barks");
    }
}
```

---

## 8. Exception Handling

### Try-Catch Block

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

### Throwing an Exception

```java
void checkAge(int age) {
    if (age < 18) {
        throw new IllegalArgumentException("Not eligible to vote");
    }
}
```

---

## 9. File Handling

### Reading from a File

```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}
```

---

##

