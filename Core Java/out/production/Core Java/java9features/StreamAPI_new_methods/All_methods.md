# 🔁 Java 9 Feature: Stream API Enhancements

## 📘 Project: Java9_Stream_API_Features

Java 8 introduced the powerful **Stream API** which allowed developers to process collections in a functional style. With **Java 9**, even more powerful and expressive methods were added to improve the Stream experience.

This project demonstrates three new methods introduced in **Java 9**:

- `takeWhile(Predicate)`
- `dropWhile(Predicate)`
- Overloaded `iterate(...)`

---

## 🚀 Why These Features?

| Problem in Java 8 | Solution in Java 9 |
|-------------------|--------------------|
| No easy way to stop processing after a condition becomes false | `takeWhile()` added |
| No way to skip elements until condition fails, then process the rest | `dropWhile()` added |
| `Stream.iterate()` lacked support for termination | New `iterate(seed, condition, next)` added |

---

## 🧠 Feature Breakdown

---

### 📌 1. `takeWhile(Predicate)`

- Returns elements from the stream **until the predicate becomes false**.
- Once false, stream **terminates immediately**.

#### ✅ Example:

```java
List<Integer> list = List.of(1, 2, 3, 6, 7, 4, 1);

list.stream()
    .takeWhile(n -> n < 5)
    .forEach(System.out::println);

List<Integer> list = List.of(1, 2, 3, 6, 7, 4, 1);

list.stream()
    .dropWhile(n -> n < 5)
    .forEach(System.out::println);

Stream.iterate(1, n -> n + 1)
      .limit(5)
      .forEach(System.out::println);


import java.util.List;
import java.util.stream.Stream;

public class StreamApiJava9Features {
    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 6, 7, 4, 1);

        System.out.println("🔹 takeWhile(n < 5):");
        list.stream()
            .takeWhile(n -> n < 5)
            .forEach(System.out::println);

        System.out.println("\n🔹 dropWhile(n < 5):");
        list.stream()
            .dropWhile(n -> n < 5)
            .forEach(System.out::println);

        System.out.println("\n🔹 Stream.iterate(1, n <= 5, n + 1):");
        Stream.iterate(1, n -> n <= 5, n -> n + 1)
              .forEach(System.out::println);
    }
}
