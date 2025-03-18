# Object-Oriented Programming (OOP) in Java

## 🔥 Introduction
Object-Oriented Programming (OOP) is a paradigm that models real-world entities using **objects** and promotes **code reusability, modularity, and scalability**. Java follows OOP principles strictly, making it an ideal language for enterprise applications.

## 🏆 Key OOP Concepts
1. **Encapsulation** – Data hiding using access modifiers.
2. **Inheritance** – Code reusability via parent-child relationships.
3. **Polymorphism** – Multiple behaviors of a single entity (method overloading/overriding).
4. **Abstraction** – Hiding implementation details.
5. **Association, Aggregation, Composition** – Relationships between objects.

---

## 1️⃣ Encapsulation (Data Hiding)
Encapsulation refers to **binding data and methods together** while restricting direct access to object data.

### ✅ Key Features:
- Use `private` variables to hide data.
- Provide `public` getter and setter methods for controlled access.

### 💻 Example:
```java
class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }
}
```

---

## 2️⃣ Inheritance (Code Reusability)
Inheritance allows a **child class to acquire properties and methods** of a parent class.

### ✅ Key Features:
- Use `extends` keyword.
- Supports **single, multilevel, hierarchical inheritance**.
- **Constructors are not inherited** but can be called using `super()`.

### 💻 Example:
```java
class Vehicle {
    void fuel() {
        System.out.println("Vehicle needs fuel to run.");
    }
}

class Car extends Vehicle {
    void drive() {
        System.out.println("Car is driving...");
    }
}
```

---

## 3️⃣ Polymorphism (Method Overloading & Overriding)

### 📌 Method Overloading (Compile-time Polymorphism)
Allows **multiple methods with the same name but different parameters**.
```java
class MathUtils {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
}
```

### 📌 Method Overriding (Runtime Polymorphism)
Allows a **subclass to provide a specific implementation** of a parent class method.
```java
class Parent {
    void show() {
        System.out.println("Parent class method.");
    }
}
class Child extends Parent {
    @Override
    void show() {
        System.out.println("Child class method.");
    }
}
```

---

## 4️⃣ Abstraction (Hiding Implementation Details)
Abstraction allows defining **only necessary details** while hiding the implementation.

### ✅ Key Features:
- Achieved using **abstract classes** and **interfaces**.
- Cannot instantiate an **abstract class**.
- Must override abstract methods in child classes.

### 💻 Example:
```java
abstract class Shape {
    abstract void draw();
}
class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a circle");
    }
}
```

---

## 5️⃣ Interface (Multiple Inheritance in Java)
An interface defines a **contract** with abstract methods that must be implemented.

### ✅ Key Features:
- Achieves **100% abstraction**.
- Supports **multiple inheritance**.
- Uses `interface` keyword.

### 💻 Example:
```java
interface Animal {
    void sound();
}
interface Walkable {
    void walk();
}
class Dog implements Animal, Walkable {
    public void sound() { System.out.println("Dog barks"); }
    public void walk() { System.out.println("Dog walks"); }
}
```

---

## 6️⃣ Association, Aggregation, and Composition
### 📌 Association (Independent Relationship)
Two independent entities are related but **do not depend on each other**.
```java
class Author {
    String name;
    public Author(String name) { this.name = name; }
}
class Book {
    String title;
    Author author;  // Association
    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }
}
```

### 📌 Aggregation (Weak "Has-A" Relationship)
One object contains another, but both can exist independently.
```java
class Department {
    String deptName;
    public Department(String deptName) { this.deptName = deptName; }
}
class Employee {
    String empName;
    Department department; // Aggregation
    public Employee(String empName, Department department) {
        this.empName = empName;
        this.department = department;
    }
}
```

### 📌 Composition (Strong "Has-A" Relationship)
The child object **cannot exist** without the parent.
```java
class CPU {
    void process() {
        System.out.println("CPU is processing...");
    }
}
class Computer {
    private final CPU cpu; // Composition
    public Computer() {
        cpu = new CPU();
    }
    void start() {
        cpu.process();
        System.out.println("Computer is running...");
    }
}
```

---

## 🔥 OOP Principles Summary
| Concept | Description | Example |
|---------|------------|---------|
| **Encapsulation** | Hiding data using `private` variables and getter/setters | `Employee` |
| **Inheritance** | Child class inherits parent class properties | `Car extends Vehicle` |
| **Polymorphism** | Method Overloading & Overriding | `add(int, int)` & `add(double, double)` |
| **Abstraction** | Hiding implementation using `abstract` class | `Shape` with `draw()` |
| **Interfaces** | Defines a contract for multiple classes | `Dog implements Animal, Walkable` |
| **Association** | Two independent classes related | `Book - Author` |
| **Aggregation** | Weak "Has-A" relationship | `Employee - Department` |
| **Composition** | Strong "Has-A" relationship | `Computer - CPU` |

---

## 🚀 Conclusion
Mastering **OOPs in Java** helps build **scalable, maintainable, and reusable** applications. Understanding how **Encapsulation, Inheritance, Polymorphism, and Abstraction** work will make you a better Java developer! 🔥

---


