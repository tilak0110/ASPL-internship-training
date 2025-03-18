# Exception Handling in Java - Revision Guide

## 1️⃣ What is Exception Handling?
Exception handling is a mechanism in Java to handle runtime errors and ensure the program runs smoothly without crashing.

## 2️⃣ Types of Exceptions
### (a) Checked Exceptions
Checked exceptions are checked at compile-time. The compiler forces handling these exceptions using `try-catch` or `throws`.
**Examples:**
- `IOException`
- `SQLException`
- `FileNotFoundException`

### (b) Unchecked Exceptions
Unchecked exceptions occur at runtime and are not checked at compile-time.
**Examples:**
- `NullPointerException`
- `ArrayIndexOutOfBoundsException`
- `ArithmeticException`

## 3️⃣ Exception Handling Keywords
Java provides five keywords for handling exceptions:
- **try** – Defines a block of code to be tested for errors.
- **catch** – Handles the exception thrown in the try block.
- **finally** – Code inside this block is always executed, whether an exception occurs or not.
- **throw** – Used to explicitly throw an exception.
- **throws** – Declares exceptions that a method might throw.

## 4️⃣ Try-Catch Mechanism
```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Exception caught: " + e.getMessage());
}
```

## 5️⃣ Multiple Catch Blocks
```java
try {
    int[] arr = new int[5];
    arr[10] = 100;
} catch (ArithmeticException e) {
    System.out.println("Arithmetic Exception");
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Array Index Out of Bounds: " + e);
}
```

## 6️⃣ Finally Block
```java
try {
    int num = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Exception caught");
} finally {
    System.out.println("Finally block always executes");
}
```

## 7️⃣ Throw vs Throws
- `throw` is used to explicitly throw an exception.
- `throws` is used to declare an exception in a method signature.

```java
void checkAge(int age) throws Exception {
    if (age < 18) {
        throw new Exception("Age must be 18 or above");
    }
}
```

## 8️⃣ Custom Exceptions
You can create your own exceptions by extending `Exception` or `RuntimeException`.
```java
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}
```

## 9️⃣ Nested Try Blocks
```java
try {
    try {
        int result = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Inner try block caught: " + e);
    }
    int[] arr = new int[5];
    arr[10] = 50;
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Outer try block caught: " + e);
}
```

## 🔟 Exception Propagation
If an exception is not handled at one level, it propagates up the call stack.
```java
static void method1() {
    int num = 10 / 0; // Exception occurs here
}

static void method2() {
    method1();
}

public static void main(String[] args) {
    try {
        method2();
    } catch (ArithmeticException e) {
        System.out.println("Exception propagated: " + e);
    }
}
```

## 1️⃣1️⃣ Try-with-Resources (AutoCloseable)
```java
try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
    System.out.println(br.readLine());
} catch (IOException e) {
    System.out.println("Exception caught: " + e);
}
```

## 1️⃣2️⃣ Finalize() Method
- The `finalize()` method is used for cleanup before an object is garbage collected.
```java
protected void finalize() {
    System.out.println("Object is garbage collected");
}
```

---
This revision guide covers everything you need to know about **Exception Handling in Java**! 🚀 Happy Coding! 🎯

