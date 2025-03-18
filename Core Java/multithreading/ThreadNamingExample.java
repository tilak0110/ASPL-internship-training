package multithreading;

class MyNamedThread extends Thread {
    public MyNamedThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println("Thread Name: " + getName() + ", Thread ID: " + getId());
    }
}

public class ThreadNamingExample {
    public static void main(String[] args) {
        MyNamedThread t1 = new MyNamedThread("Worker-1");
        MyNamedThread t2 = new MyNamedThread("Worker-2");

        t1.start();
        t2.start();
    }
}
