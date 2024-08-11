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

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    void insertGCDs() {
        Node temp = first;
        while (temp != null && temp.link != null) {
            int gcdValue = gcd(temp.info, temp.link.info);
            Node newNode = new Node(gcdValue);

            newNode.link = temp.link;
            temp.link = newNode;

            temp = newNode.link;
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

public class GCDOfTwoNodeBetweenTwoNode_12_67 {
    public static void main(String[] args) {
        ll list = new ll();
        list.insertAtEnd(18);
        list.insertAtEnd(6);
        list.insertAtEnd(10);
        list.insertAtEnd(3);

        System.out.println("Original List:");
        list.display();

        list.insertGCDs();

        System.out.println("List after inserting GCDs:");
        list.display();
    }
}
