import java.util.Scanner;

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

    void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.lptr);
        postOrder(node.rptr);
        System.out.println(node.info + " ");
    }

    void postOrder(){
        postOrder(root);
    }

}

public class BTSOperation_14_78 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Insert a node");
            System.out.println("2. Perform pre-order traversal");
            System.out.println("3. Perform post-order traversal");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the value to insert:");
                    int value = sc.nextInt();
                    tree.insertInBTS(value);
                    break;

                case 2:
                    System.out.println("Pre-order traversal of the tree:");
                    tree.preOrder();
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Post-order traversal of the tree:");
                    tree.postOrder();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        }
    }
}