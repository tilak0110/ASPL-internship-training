package datastructure;

public class DequeUsingArray {
    private int[] deque;
    private int front, rear, size;

    // Constructor
    public DequeUsingArray(int size) {
        this.size = size;
        deque = new int[size];
        front = -1;
        rear = -1;
    }

    // Check if deque is full
    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (front == rear + 1);
    }

    // Check if deque is empty
    public boolean isEmpty() {
        return front == -1;
    }

    // Insert at front
    public void insertFront(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at front.");
            return;
        }
        if (front == -1) { // Empty deque
            front = rear = 0;
        } else if (front == 0) {
            front = size - 1; // Circular behavior
        } else {
            front--;
        }
        deque[front] = value;
    }

    // Insert at rear
    public void insertRear(int value) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot insert at rear.");
            return;
        }
        if (rear == -1) { // Empty deque
            front = rear = 0;
        } else if (rear == size - 1) {
            rear = 0; // Circular behavior
        } else {
            rear++;
        }
        deque[rear] = value;
    }

    // Delete from front
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from front.");
            return;
        }
        if (front == rear) { // Single element case
            front = rear = -1;
        } else if (front == size - 1) {
            front = 0; // Circular behavior
        } else {
            front++;
        }
    }

    // Delete from rear
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot delete from rear.");
            return;
        }
        if (front == rear) { // Single element case
            front = rear = -1;
        } else if (rear == 0) {
            rear = size - 1; // Circular behavior
        } else {
            rear--;
        }
    }

    // Get front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        return deque[front];
    }

    // Get rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        return deque[rear];
    }

    // Display the deque
    public void display() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }
        System.out.print("Deque: ");
        int i = front;
        while (true) {
            System.out.print(deque[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size; // Circular behavior
        }
        System.out.println();
    }

    // Main function to test the deque
    public static void main(String[] args) {
        DequeUsingArray deque = new DequeUsingArray(5);

        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertFront(5);
        deque.insertFront(1);
        deque.display();

        System.out.println("Front: " + deque.getFront());
        System.out.println("Rear: " + deque.getRear());

        deque.deleteFront();
        deque.display();

        deque.deleteRear();
        deque.display();
    }
}
