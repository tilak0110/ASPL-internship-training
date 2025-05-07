# 📂 Java 9 Feature: Try-With-Resources Enhancement

## 📘 Project: Try_With_Resource_Enhancement

This project showcases the **enhancement made to the Try-With-Resources statement** in **Java 9**. The improvement simplifies resource management by allowing **effectively final resources** to be used directly inside the `try` block without re-declaring them.

---

## 🤔 What is Try-With-Resources?

Introduced in **Java 7**, the `try-with-resources` statement is used to **automatically close** resources (like files, sockets, DB connections) when they are no longer needed. The resource must implement the `AutoCloseable` interface.

---

## 🔄 Limitation in Java 7/8

In Java 7/8, the resource **had to be declared inside** the `try()` block, like:

```java
try (FileOutputStream fos = new FileOutputStream("output.txt")) {
    // use fos
}

package Try_With_Resource_Enhancement;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWrite {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("outputfile.txt");

        try (fos) {
            fos.write("this is written by tilak".getBytes());
            System.out.println("String written in the file successfully");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fos.close(); // Not needed in Java 9+, kept here just to show old behavior
        }
    }
}
