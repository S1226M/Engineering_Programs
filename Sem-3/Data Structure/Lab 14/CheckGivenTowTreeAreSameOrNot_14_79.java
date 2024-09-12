class BinaryTree {
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

    void insertInBTS(int x) {
        Node newNode = new Node(x);
        if (root == null) {
            root = newNode;
        } else {
            Node temp = root;
            Node parent = null;

            while (temp != null) {
                parent = temp;
                if (x < temp.info) {
                    temp = temp.lptr;
                } else {
                    temp = temp.rptr;
                }
            }

            if (x < parent.info) {
                parent.lptr = newNode;
            } else {
                parent.rptr = newNode;
            }
        }
    }

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

    // Method to check if two trees are identical
    boolean areIdentical(Node node1, Node node2) {
        // If both nodes are null, trees are identical at this level
        if (node1 == null && node2 == null) {
            return true;
        }

        // If one node is null and the other is not, trees are not identical
        if (node1 == null || node2 == null) {
            return false;
        }

        // Check if current nodes are identical and their subtrees are identical
        return (node1.info == node2.info) &&
                areIdentical(node1.lptr, node2.lptr) &&
                areIdentical(node1.rptr, node2.rptr);
    }

    boolean areIdentical(BinaryTree otherTree) {
        return areIdentical(this.root, otherTree.root);
    }
}

public class CheckGivenTowTreeAreSameOrNot_14_79 {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree();
        BinaryTree tree2 = new BinaryTree();
        
        // Insert elements into tree1
        tree1.insertInBTS(20);
        tree1.insertInBTS(10);
        tree1.insertInBTS(4);
        tree1.insertInBTS(12);
        tree1.insertInBTS(10);
        tree1.insertInBTS(14);
        tree1.insertInBTS(22);

        // Insert elements into tree2
        tree2.insertInBTS(20);
        tree2.insertInBTS(8);
        tree2.insertInBTS(4);
        tree2.insertInBTS(12);
        tree2.insertInBTS(10);
        tree2.insertInBTS(14);
        tree2.insertInBTS(22);

        // Pre-order traversal of tree1
        System.out.print("Pre-order traversal of tree1: ");
        tree1.preOrder();
        System.out.println();

        // Pre-order traversal of tree2
        System.out.print("Pre-order traversal of tree2: ");
        tree2.preOrder();
        System.out.println();

        // Check if tree1 and tree2 are identical
        if (tree1.areIdentical(tree2)) {
            System.out.println("The two trees are identical.");
        } else {
            System.out.println("The two trees are not identical.");
        }
    }
}
