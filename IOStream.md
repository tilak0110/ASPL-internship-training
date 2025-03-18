# Java IO Streams - Detailed Revision

## 1. Introduction to Java IO Streams
Java provides a powerful I/O (Input/Output) framework that allows reading and writing data from various sources like files, keyboard input, network sockets, etc.

### Key Concepts:
- **Stream**: A sequence of data.
- **Input Stream**: Used to read data.
- **Output Stream**: Used to write data.
- **Byte Streams**: Read and write binary data (e.g., `InputStream`, `OutputStream`).
- **Character Streams**: Read and write text data (e.g., `Reader`, `Writer`).
- **Buffered Streams**: Improve efficiency by using a buffer.
- **Data Streams**: Read and write primitive data types.

---

## 2. Byte Streams (Binary Data)
Byte streams handle raw binary data and are used for reading and writing files, images, and audio.

### 2.1 InputStream (Abstract Class)
```java
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 2.2 OutputStream (Abstract Class)
```java
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String data = "Hello, Java IO!";
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 3. Character Streams (Text Data)
Character streams are used to handle text-based input/output operations.

### 3.1 Reader (Abstract Class)
```java
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("example.txt")) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 3.2 Writer (Abstract Class)
```java
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("output.txt")) {
            fw.write("Java IO Streams are powerful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 4. Buffered Streams (Efficient I/O)
Buffered streams improve performance by reducing direct interactions with the underlying system.

### 4.1 BufferedInputStream & BufferedOutputStream
```java
import java.io.*;

public class BufferedStreamExample {
    public static void main(String[] args) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("example.txt"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("copy.txt"))) {
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 4.2 BufferedReader & BufferedWriter
```java
import java.io.*;

public class BufferedReaderExample {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 5. Data Streams (Reading/Writing Primitive Data)
Used for reading and writing primitive data types and Strings.

```java
import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"))) {
            dos.writeInt(100);
            dos.writeDouble(99.99);
            dos.writeUTF("Hello");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"))) {
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 6. Object Streams (Serialization)
Used for serializing and deserializing objects.

```java
import java.io.*;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class ObjectStreamExample {
    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            Person p = new Person("Alice", 30);
            oos.writeObject(p);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person p = (Person) ois.readObject();
            System.out.println("Name: " + p.name + ", Age: " + p.age);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 7. Conclusion
- **Byte Streams**: For handling raw binary data.
- **Character Streams**: For handling text data.
- **Buffered Streams**: For performance improvement.
- **Data Streams**: For reading/writing primitive data types.
- **Object Streams**: For object serialization.

Using the appropriate stream based on the use case improves efficiency and performance. 🚀

---

This document provides a detailed revision of Java IO Streams with practical examples for a strong understanding of Java’s powerful I/O system.

