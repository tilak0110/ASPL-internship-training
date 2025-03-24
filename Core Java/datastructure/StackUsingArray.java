package datastructure;

class StackUsingArray {
    private int maxSize;
    private int top;
    private int[] stackArray;

    public StackUsingArray(int size) {
        this.maxSize = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack Overflow!");
            return;
        }
        stackArray[++top] = value;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return stackArray[top--];
    }

    public int peek() {
        return (top == -1) ? -1 : stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(3);
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
    }
}
