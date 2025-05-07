# ⚙️ Java 9 Feature: Enhanced Process API

## 📘 Project: Process_API

This project demonstrates the use of **enhanced Process API** introduced in **Java 9**. It simplifies the interaction with **operating system processes**, making it much easier to gather information about running processes directly from Java code — something that was previously very difficult and often required native code or external libraries.

---

## 🚀 Why This Feature?

### 🔙 Before Java 9:
- Interacting with OS-level processes was **complex**.
- Developers had to use **native code**, third-party libraries, or platform-specific tricks.
- No unified, simple way to manage or monitor processes from Java.

### 🆕 With Java 9:
- New classes and methods added in `java.lang.ProcessHandle` and `ProcessHandle.Info`.
- Enables you to:
  - Access current process information
  - Monitor, control, and destroy processes
  - Get PID, start time, command line, and user info

---

## 📂 Project Structure



---

## 📄 Code Overview

### 🔧 Process_API_Test.java

```java
package Process_API;

public class Process_API_Test {
    public static void main(String[] args) {
        /*
        Prior to Java 9, interacting with processes was difficult.
        Native code or 3rd-party libraries were often required.
        Java 9 introduced enhancements to the Process API to simplify this.
        */

        ProcessHandle ph = ProcessHandle.current();          // Gets current JVM process
        ProcessHandle.Info info = ph.info();                 // Retrieves info about the process

        System.out.println("🔍 Complete process information:");
        System.out.println(info);

        System.out.println("\n👤 User: " + info.user().get());
        System.out.println("📂 Command: " + info.command().get());
        System.out.println("⏱️ Start Time: " + info.startInstant().get());

        // Optional: You can also display PID and check if process is alive
        System.out.println("🆔 PID: " + ph.pid());
        System.out.println("✅ Is Alive: " + ph.isAlive());
    }
}

🔍 Complete process information:
Optional[info about the current process]

👤 User: Tilak
📂 Command: /path/to/java
⏱️ Start Time: 2025-04-09T10:15:30.123Z
🆔 PID: 12345
✅ Is Alive: true
