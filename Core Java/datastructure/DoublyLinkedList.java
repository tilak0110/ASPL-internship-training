package datastructure;

class DNode {
    int data;
    DNode prev, next;

    public DNode(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class DoublyLinkedList {
    private DNode head;

    // Insert at Beginning
    public void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insert at End
    public void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete a Node
    public void deleteNode(int key) {
        DNode temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp == head) head = temp.next;
    }

    // Display List (Forward & Backward)
    public void displayList() {
        DNode temp = head, last = null;
        System.out.print("Forward: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            last = temp;
            temp = temp.next;
        }
        System.out.println("null");

        System.out.print("Backward: ");
        while (last != null) {
            System.out.print(last.data + " <-> ");
            last = last.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.displayList();
        list.deleteNode(20);
        list.displayList();
    }
}
