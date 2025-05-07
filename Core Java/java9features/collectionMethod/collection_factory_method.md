
---

## 📄 2. `README.md` for **Collection Factory Methods**

```markdown
# 📦 Java 9 Feature: Collection Factory Methods

## 📘 Project: Collection_Factory_Methods

Java 9 introduced convenient **factory methods** to create **immutable** collections like List, Set, and Map in a single line — reducing boilerplate code and improving readability.

---

## 🤯 Problem in Java 8

Creating small collections was verbose:

```java
List<String> list = new ArrayList<>();
list.add("apple");
list.add("banana");
list.add("cherry");

List<String> fruits = List.of("apple", "banana", "cherry");

Set<String> colors = Set.of("red", "green", "blue");

Map<Integer, String> idMap = Map.of(1, "Tilak", 2, "Amit", 3, "Ravi");

Map<String, String> countryCodes = Map.ofEntries(
    Map.entry("IN", "India"),
    Map.entry("US", "United States"),
    Map.entry("JP", "Japan")
);

⚠️ Note
These collections are immutable.

Adding/modifying/removing elements will throw UnsupportedOperationException.

java
Copy
Edit
List<String> list = List.of("one", "two");
list.add("three"); // ❌ Exception

🎯 Benefits
Feature	Benefit
One-liner syntax	Less code
Immutable collections	Thread-safe & bug-resistant
Factory methods	No need for new ArrayList<>() etc.

import java.util.*;

public class CollectionFactoryExample {
    public static void main(String[] args) {
        List<String> cities = List.of("Mumbai", "Delhi", "Pune");
        Set<Integer> numbers = Set.of(1, 2, 3, 4);
        Map<String, String> langMap = Map.of("Java", "Oracle", "Python", "PSF");

        System.out.println("Cities: " + cities);
        System.out.println("Numbers: " + numbers);
        System.out.println("Language Map: " + langMap);
    }
}


🖥️ Output
yaml
Copy
Edit
Cities: [Mumbai, Delhi, Pune]
Numbers: [1, 2, 3, 4]
Language Map: {Java=Oracle, Python=PSF}

⚙️ Requirements
Java 9 or higher

Any Java IDE or terminal

Created by: [Tilak]

