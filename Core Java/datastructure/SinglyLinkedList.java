//package datastructure;
//
//class Node {
//    int data;
//    Node next;
//
//    public Node(int data) {
//        this.data = data;
//        this.next = null;
//    }
//}
//
//public class SinglyLinkedList {
//    private Node head;
//
//    // Insert at Beginning
//    public void insertAtBeginning(int data) {
//        Node newNode = new Node(data);
//        newNode.next = head;
//        head = newNode;
//    }
//
//    // Insert at End
//    public void insertAtEnd(int data) {
//        Node newNode = new Node(data);
//        if (head == null) {
//            head = newNode;
//            return;
//        }
//        Node temp = head;
//        while (temp.next != null) {
//            temp = temp.next;
//        }
//        temp.next = newNode;
//    }
//
//    // Insert at Position
//    public void insertAtPosition(int data, int position) {
//        Node newNode = new Node(data);
//        if (position == 0) {
//            newNode.next = head;
//            head = newNode;
//            return;
//        }
//        Node temp = head;
//        for (int i = 0; i < position - 1 && temp != null; i++) {
//            temp = temp.next;
//        }
//        if (temp == null) return;
//        newNode.next = temp.next;
//        temp.next = newNode;
//    }
//
//
//
//
//
//
//
//    // Delete a Node
//    public void deleteNode(int key) {
//        Node temp = head, prev = null;
//        if (temp != null && temp.data == key) {
//            head = temp.next;
//            return;
//        }
//        while (temp != null && temp.data != key) {
//            prev = temp;
//            temp = temp.next;
//        }
//        if (temp == null) return;
//        prev.next = temp.next;
//    }
//
//
//
//
//
//    // Search a Node
//    public boolean searchNode(int key) {
//        Node temp = head;
//        while (temp != null) {
//            if (temp.data == key) return true;
//            temp = temp.next;
//        }
//        return false;
//    }
//
//    // Display the List
//    public void displayList() {
//        Node temp = head;
//        while (temp != null) {
//            System.out.print(temp.data + " → ");
//            temp = temp.next;
//        }
//        System.out.println("null");
//    }
//
//    public static void main(String[] args) {
//        SinglyLinkedList list = new SinglyLinkedList();
//        list.insertAtBeginning(10);
//        list.insertAtEnd(20);
//        list.insertAtPosition(15, 1);
//        list.displayList();
//        list.deleteNode(15);
//        list.displayList();
//        System.out.println("Search 20: " + list.searchNode(20));
//    }
//}
