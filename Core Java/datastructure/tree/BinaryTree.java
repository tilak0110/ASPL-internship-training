package datastructure.tree;

//class Node {
//    int data;
//    Node left, right;
//
//    public Node(int data) {
//        this.data = data;
//        this.left = this.right = null;
//    }
//}

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("PreOrder Traversal: ");
        tree.preOrder(tree.root);

        System.out.print("\nInOrder Traversal: ");
        tree.inOrder(tree.root);

        System.out.print("\nPostOrder Traversal: ");
        tree.postOrder(tree.root);
    }
}
