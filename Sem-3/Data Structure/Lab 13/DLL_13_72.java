import java.util.Scanner;

class DoublyLinkedList {
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

    private Node first = null;

    // Insert a node at the front of the linked list
    void insertFront(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
        } else {
            newNode.rptr = first;
            first.lptr = newNode;
            first = newNode;
        }
    }

    // Insert a node at the end of the linked list
    void insertEnd(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.rptr != null) {
                temp = temp.rptr;
            }
            temp.rptr = newNode;
            newNode.lptr = temp;
        }
    }

    // Delete a node from the specified position
    void deletePosition(int pos) {
        if (first == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = first;
        if (pos == 1) {
            if (first.rptr == null) {
                first = null;
            } else {
                first = first.rptr;
                first.lptr = null;
            }
            return;
        }

        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.rptr;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        if (temp.rptr != null) {
            temp.rptr.lptr = temp.lptr;
        }
        if (temp.lptr != null) {
            temp.lptr.rptr = temp.rptr;
        }
    }

    // Display all nodes
    void display() {
        Node temp = first;
        if (temp == null) {
            System.out.println("The list is empty.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.rptr;
        }
        System.out.println();
    }
}

public class DLL_13_72 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert node at the front");
            System.out.println("2. Insert node at the end");
            System.out.println("3. Delete node from specified position");
            System.out.println("4. Display all nodes");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at the front: ");
                    int frontValue = scanner.nextInt();
                    list.insertFront(frontValue);
                    break;
                case 2:
                    System.out.print("Enter value to insert at the end: ");
                    int endValue = scanner.nextInt();
                    list.insertEnd(endValue);
                    break;
                case 3:
                    System.out.print("Enter position to delete: ");
                    int pos = scanner.nextInt();
                    list.deletePosition(pos);
                    break;
                case 4:
                    System.out.println("List contents:");
                    list.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
