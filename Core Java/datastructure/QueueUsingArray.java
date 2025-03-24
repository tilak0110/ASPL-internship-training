package datastructure;

class QueueUsingArray {
    private int front, rear, size;
    private int capacity;
    private int[] queueArray;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = this.size = 0;
        this.rear = capacity - 1;
    }

    public void enqueue(int value) {
        if (size == capacity) {
            System.out.println("Queue Overflow!");
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = value;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow!");
            return -1;
        }
        int item = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public int front() {
        return queueArray[front];
    }

    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Front element: " + queue.front());
        System.out.println("Dequeued: " + queue.dequeue());
    }
}
