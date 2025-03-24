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
//public class SinglyCircularLinkedList {
//    private Node last;
//
//    // Insert at Beginning
//    public void insertAtBeginning(int data) {
//        Node newNode = new Node(data);
//        if (last == null) {  // First node
//            last = newNode;
//            last.next = last; // Circular link
//        } else {
//            newNode.next = last.next;
//            last.next = newNode;
//        }
//    }
//
//    // Insert at End
//    public void insertAtEnd(int data) {
//        Node newNode = new Node(data);
//        if (last == null) {
//            last = newNode;
//            last.next = last;
//        } else {
//            newNode.next = last.next;
//            last.next = newNode;
//            last = newNode; // Move last pointer
//        }
//    }
//
//    // Delete a Node
//    public void deleteNode(int key) {
//        if (last == null) return;
//        Node temp = last, prev = null;
//
//        // If the only node needs to be deleted
//        if (last.next == last && last.data == key) {
//            last = null;
//            return;
//        }
//
//        // If the first node needs to be deleted
//        if (last.next.data == key) {
//            last.next = last.next.next;
//            return;
//        }
//
//        // Search for the key
//        do {
//            prev = temp;
//            temp = temp.next;
//            if (temp.data == key) {
//                prev.next = temp.next;
//                if (temp == last) last = prev;
//                return;
//            }
//        } while (temp != last.next);
//    }
//
//    // Display the List
//    public void displayList() {
//        if (last == null) {
//            System.out.println("List is empty.");
//            return;
//        }
//        Node temp = last.next;
//        do {
//            System.out.print(temp.data + " → ");
//            temp = temp.next;
//        } while (temp != last.next);
//        System.out.println("(Back to Head)");
//    }
//
//    public static void main(String[] args) {
//        SinglyCircularLinkedList list = new SinglyCircularLinkedList();
//        list.insertAtEnd(10);
//        list.insertAtEnd(20);
//        list.insertAtEnd(30);
//        list.displayList();
//        list.deleteNode(20);
//        list.displayList();
//    }
//}
