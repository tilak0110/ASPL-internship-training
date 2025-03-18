# **Multithreading in Java - Detailed Revision Guide**

## **1. Introduction to Multithreading**
Multithreading is a technique where multiple threads execute simultaneously, improving CPU utilization and performance.

### **Key Terms:**
- **Thread:** A lightweight process executing independently.
- **Concurrency:** Multiple tasks running at the same time.
- **Parallelism:** True simultaneous execution on multiple cores.
- **Synchronization:** Controlling thread access to shared resources.
- **Thread Safety:** Ensuring code execution without race conditions.

---

## **2. Thread Lifecycle in Java**
A thread goes through the following states:

1. **NEW:** Thread is created but not started.
2. **RUNNABLE:** Ready to run but waiting for CPU.
3. **RUNNING:** Actively executing.
4. **BLOCKED:** Waiting for a lock.
5. **WAITING:** Waiting indefinitely for another thread's action.
6. **TIMED_WAITING:** Waiting for a specified time.
7. **TERMINATED:** Execution completed.

### **Example: Thread Lifecycle Demonstration**
```java
class LifecycleDemo extends Thread {
    public void run() {
        System.out.println("Thread is running...");
        try {
            Thread.sleep(2000); // Moves to TIMED_WAITING
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread execution completed.");
    }
}

public class ThreadLifecycle {
    public static void main(String[] args) {
        LifecycleDemo thread = new LifecycleDemo();
        System.out.println("Thread State: " + thread.getState()); // NEW
        thread.start();
        System.out.println("Thread State: " + thread.getState()); // RUNNABLE
    }
}
```

---

## **3. Creating Threads in Java**

### **Method 1: Extending `Thread` Class**
```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}
public class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Calls run()
    }
}
```

### **Method 2: Implementing `Runnable` Interface**
```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }
}
public class RunnableExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
}
```

---

## **4. Thread Synchronization**
Ensures that multiple threads don’t cause inconsistency while modifying shared resources.

### **Synchronized Method**
```java
class Counter {
    private int count = 0;
    public synchronized void increment() {
        count++;
    }
    public int getCount() {
        return count;
    }
}
```

### **Synchronized Block**
```java
class Counter {
    private int count = 0;
    public void increment() {
        synchronized (this) {
            count++;
        }
    }
}
```

---

## **5. Thread Communication**
Threads communicate using `wait()`, `notify()`, and `notifyAll()`.

```java
class SharedResource {
    private boolean flag = false;
    
    public synchronized void waitMethod() {
        while (!flag) {
            try { wait(); } catch (InterruptedException e) { }
        }
        System.out.println("Resumed Execution");
    }

    public synchronized void notifyMethod() {
        flag = true;
        notify();
    }
}
```

---

## **6. Thread Pooling**
Creates reusable threads to optimize performance.

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> System.out.println("Thread: " + Thread.currentThread().getName()));
        }
        executor.shutdown();
    }
}
```

---

## **7. Callable & Future**
Used to return values from threads.

```java
import java.util.concurrent.*;

class SumTask implements Callable<Integer> {
    public Integer call() {
        return 10 + 20;
    }
}

public class CallableExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(new SumTask());
        System.out.println("Result: " + future.get());
        executor.shutdown();
    }
}
```

---

## **8. Fork/Join Framework (Parallel Processing)**

```java
import java.util.concurrent.*;

class SumTask extends RecursiveTask<Integer> {
    private final int start, end;
    private final int[] arr;

    public SumTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 2) {
            int sum = 0;
            for (int i = start; i < end; i++) sum += arr[i];
            return sum;
        }
        int mid = (start + end) / 2;
        SumTask left = new SumTask(arr, start, mid);
        SumTask right = new SumTask(arr, mid, end);
        left.fork();
        int rightResult = right.compute();
        int leftResult = left.join();
        return leftResult + rightResult;
    }
}
```

---

## **9. Atomic Variables (Thread-Safe Operations)**
```java
import java.util.concurrent.atomic.AtomicInteger;

class Counter {
    private final AtomicInteger count = new AtomicInteger(0);
    public void increment() { count.incrementAndGet(); }
    public int getValue() { return count.get(); }
}
```

---

## **Conclusion**
Multithreading is crucial for optimizing Java applications. We covered:
- **Thread Lifecycle & Creation**
- **Synchronization & Communication**
- **Thread Pooling & Executors**
- **Advanced Concepts: Fork/Join, Atomic Variables**

Understanding these ensures efficient, scalable, and high-performance Java applications.

