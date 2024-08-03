class Node {
    int info;
    Node link;

    Node(int data) {
        this.info = data;
        this.link = null;
    }
}

class LL {
    Node first = null;

    void insertAtEnd(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            return;
        }
        Node temp = first;
        while (temp.link != null) {
            temp = temp.link;
        }
        temp.link = newNode;
    }

    void reverseLinkList() {
        if (first == null) {
            System.out.println("Linked list does not exist");
            return;
        }
        Node prev = null;
        Node current = first;
        Node next = null;
        while (current != null) {
            next = current.link;
            current.link = prev;
            prev = current;
            current = next;
        }
        first = prev;
    }

    void displayList() {
        Node temp = first;
        if (temp == null) {
            System.out.println("Linked list is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}

public class RevarceLL_12_64 {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);

        System.out.println("Original Linked List:");
        list.displayList();

        list.reverseLinkList();

        System.out.println("Reversed Linked List:");
        list.displayList();
    }
}