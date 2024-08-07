import java.util.Scanner;

public class CircularLL_13_71 {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node first;
    public Node tail;

    public void printData() {
        if (first == null) {
            System.out.println("Empty");
            return;
        }

        Node temp = first;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != first);
        System.out.println();
    }

    public void insertAtFirst(int data) {
        Node n1 = new Node(data);

        if (first == null) {
            n1.next = n1;
            first = n1;
            tail = n1;
            return;
        }

        n1.next = first;
        first = n1;
        tail.next = first;
    }

    public void insertAtLast(int data) {
        Node n1 = new Node(data);

        if (first == null) {
            n1.next = n1;
            first = n1;
            tail = n1;
            return;
        }

        tail.next = n1;
        n1.next = first;
        tail = n1;
    }

    public void deleteAtPosition(int position) {
        if (first == null) {
            System.out.println("Empty");
            return;
        }
        if (position == 0) {
            if (first == tail) {
                first = null;
                tail = null;
            } else {
                first = first.next;
                tail.next = first;
            }
            return;
        }

        Node temp = first;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
            if (temp == first) {
                System.out.println("Position out of bounds");
                return;
            }
        }
        if (temp.next == first) {
            tail = temp;
            tail.next = first;
        } else {
            temp.next = temp.next.next;
        }
    }

    public static void main(String[] args) {
        CircularLL_13_71 l1 = new CircularLL_13_71();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert at first");
            System.out.println("2. Insert at last");
            System.out.println("3. Delete at position");
            System.out.println("4. Print list");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to insert at first: ");
                    int dataFirst = sc.nextInt();
                    l1.insertAtFirst(dataFirst);
                    break;
                case 2:
                    System.out.print("Enter the element to insert at last: ");
                    int dataLast = sc.nextInt();
                    l1.insertAtLast(dataLast);
                    break;
                case 3:
                    System.out.print("Enter the position to delete (0-based index): ");
                    int position = sc.nextInt();
                    l1.deleteAtPosition(position);
                    break;
                case 4:
                    System.out.println("List content:");
                    l1.printData();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}