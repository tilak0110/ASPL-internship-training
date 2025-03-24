package datastructure.tree;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a node into BST
    Node insert(Node root, int value) {
        if (root == null) return new Node(value);
        if (value < root.data) root.left = insert(root.left, value);
        else root.right = insert(root.right, value);
        return root;
    }

    // Search for a value in BST
    boolean search(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return key < root.data ? search(root.left, key) : search(root.right, key);
    }

    // Inorder Traversal (Sorted Order)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    // Delete a node in BST
    Node delete(Node root, int key) {
        if (root == null) return root;

        // Find the node to delete
        if (key < root.data) root.left = delete(root.left, key);
        else if (key > root.data) root.right = delete(root.right, key);
        else {
            // Case 1: No child or one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 2: Two children, find inorder successor (smallest in right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // Find the smallest value in a subtree (for inorder successor)
    int minValue(Node root) {
        int minV = root.data;
        while (root.left != null) {
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }


    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into BST
        bst.root = bst.insert(bst.root, 8);
        bst.insert(bst.root, 3);
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 1);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 14);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 7);
        bst.insert(bst.root, 13);

        // Inorder Traversal (Sorted)
        System.out.println("Inorder Traversal:");
        bst.inorder(bst.root);  // Output: 1 3 4 6 7 8 10 13 14

        // Search operation
        System.out.println("\nSearch 6: " + bst.search(bst.root, 6)); // true
        System.out.println("Search 15: " + bst.search(bst.root, 15)); // false
    }
}
