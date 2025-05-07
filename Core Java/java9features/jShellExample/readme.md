# 💻 Java 9 Feature: JShell (REPL)

## 📘 Project: JShell_Introduction

JShell, also known as the **Java Shell tool**, is an interactive REPL (Read-Eval-Print-Loop) introduced in **Java 9**. It allows developers to quickly write and test snippets of Java code **without needing to write full classes or methods**.

---

## 🤔 What is REPL?

**R**ead → **E**valuate → **P**rint → **L**oop

It means:
- You write a line of Java code
- JShell executes it immediately
- Shows the result
- Waits for the next line

---

## 🔧 How to Start JShell

```bash
jshell

jshell> int x = 5;
x ==> 5

jshell> int y = 10;
y ==> 10

jshell> x + y
$3 ==> 15

jshell> System.out.println("Hello from JShell!");
Hello from JShell!



✅ Benefits of JShell
Test code instantly without boilerplate

Great for learning and experimenting

Write, run, and debug expressions or APIs quickly

Supports variables, methods, classes, imports, and more!

📌 Additional Features
Use /vars, /methods, /classes to inspect code

Save your session: /save myfile.jsh

Load from saved: /open myfile.jsh

Exit: /exit

🎯 Use Cases
Learning Java

API testing (like Streams, Collections, etc.)

Debugging small logic quickly

Interview prep & coding practice


👨‍💻 Author
Created by: [Tilak]

