class ll {
    class Node {
        int info;
        Node link;

        Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

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

    void Swap() {
        if (first == null) {
            System.out.println("Underflow");
            return;
        }

        Node temp = first;
        Node prev = null;

        while (temp != null && temp.link != null) {
            Node next = temp.link;
            temp.link = next.link;
            next.link = temp;

            if (prev == null) {
                first = next;
            } else {
                prev.link = next;
            }

            prev = temp;
            temp = temp.link;
        }
    }

    void display() {
        if (first == null) {
            System.out.println("Underflow");
            return;
        }
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}

public class SwapConsicutive_12_68 {
    public static void main(String[] args) {
        ll list = new ll();
        list.insertAtEnd(18);
        list.insertAtEnd(6);
        list.insertAtEnd(10);
        list.insertAtEnd(3);

        System.out.println("Original List:");
        list.display();
        list.Swap();

        System.out.println("List after swapping consecutive nodes:");
        list.display();
    }
}