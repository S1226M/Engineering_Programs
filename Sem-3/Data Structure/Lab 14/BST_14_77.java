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

    boolean searchNode(int x) {
        Node temp = root;
        while (temp != null) {
            if (x == temp.info) {
                return true;
            } else if (x < temp.info) {
                temp = temp.lptr;
            } else {
                temp = temp.rptr;
            }
        }
        return false;
    }
}

public class BST_14_77 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insertInBTS(20);
        tree.insertInBTS(8);
        tree.insertInBTS(4);
        tree.insertInBTS(12);
        tree.insertInBTS(10);
        tree.insertInBTS(14);
        tree.insertInBTS(22);

        System.out.print("Pre-order traversal of the BST: ");
        tree.preOrder();
        System.out.println();

        int searchValue = 10;
        if (tree.searchNode(searchValue)) {
            System.out.println("Node " + searchValue + " is found.");
        } else {
            System.out.println("Node " + searchValue + " is not found.");
        }
    }
}
