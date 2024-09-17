class BinaryTreeIsSymmetric {
    class Node {
        int info;
        Node lptr;
        Node rptr;

        Node(int data) {
            this.info = data;
            this.lptr = null;
            this.rptr = null;
        }
    }

    Node root = null;

    // Insert elements manually to form a symmetric tree
    void createSymmetricTree() {
        root = new Node(1);

        root.lptr = new Node(2);
        root.rptr = new Node(2);

        root.lptr.lptr = new Node(3);
        root.lptr.rptr = new Node(4);

        root.rptr.lptr = new Node(4);
        root.rptr.rptr = new Node(3);
    }

    // Method to check if the tree is symmetric
    boolean isSymmetric() {
        return isMirror(root, root);
    }

    // Helper method to check if two subtrees are mirror images of each other
    boolean isMirror(Node node1, Node node2) {
        // Base case: Both nodes are null, return true
        if (node1 == null && node2 == null) {
            return true;
        }

        // One of the nodes is null but the other isn't, return false
        if (node1 == null || node2 == null) {
            return false;
        }

        // Check if:
        // 1. The values of both nodes are the same
        // 2. The left child of node1 is a mirror of the right child of node2
        // 3. The right child of node1 is a mirror of the left child of node2
        return (node1.info == node2.info)
                && isMirror(node1.lptr, node2.rptr)
                && isMirror(node1.rptr, node2.lptr);
    }

    // Pre-order traversal to visualize the tree (optional)
    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.info + " ");
        preOrder(node.lptr);
        preOrder(node.rptr);
    }

    void preOrder() {
        preOrder(root);
    }
}

public class CheckIfTreeIsSymmetric {
    public static void main(String[] args) {
        BinaryTreeIsSymmetric tree = new BinaryTreeIsSymmetric();

        // Create a symmetric tree
        tree.createSymmetricTree();

        // Pre-order traversal of the tree
        System.out.print("Pre-order traversal: ");
        tree.preOrder();
        System.out.println();

        // Check if the tree is symmetric
        if (tree.isSymmetric()) {
            System.out.println("The tree is symmetric.");
        } else {
            System.out.println("The tree is not symmetric.");
        }
    }
}