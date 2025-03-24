package datastructure;

public class DoublyCircularLinkedList {
    private DNode last;

    // Insert at Beginning
    public void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);
        if (last == null) {
            last = newNode;
            last.next = last.prev = last;
        } else {
            newNode.next = last.next;
            newNode.prev = last;
            last.next.prev = newNode;
            last.next = newNode;
        }
    }

    // Insert at End
    public void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (last == null) {
            last = newNode;
            last.next = last.prev = last;
        } else {
            newNode.next = last.next;
            newNode.prev = last;
            last.next.prev = newNode;
            last.next = newNode;
            last = newNode; // Move last pointer
        }
    }

    // Delete a Node
    public void deleteNode(int key) {
        if (last == null) return;
        DNode temp = last.next;

        // If only one node exists
        if (last == last.next && last.data == key) {
            last = null;
            return;
        }

        // Search for the key
        do {
            if (temp.data == key) {
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                if (temp == last) last = temp.prev;
                return;
            }
            temp = temp.next;
        } while (temp != last.next);
    }

    // Display the List
    public void displayList() {
        if (last == null) {
            System.out.println("List is empty.");
            return;
        }

        System.out.print("Forward: ");
        DNode temp = last.next;
        do {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        } while (temp != last.next);
        System.out.println("(Back to Head)");

        System.out.print("Backward: ");
        temp = last;
        do {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.prev;
        } while (temp != last);
        System.out.println("(Back to Tail)");
    }

    public static void main(String[] args) {
        DoublyCircularLinkedList list = new DoublyCircularLinkedList();
        list.insertAtBeginning(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.displayList();
        list.deleteNode(20);
        list.displayList();
    }
}
