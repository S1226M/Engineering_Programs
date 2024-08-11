class CircularLL {
    class Node {
        int data;
        Node link;

        public Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    public Node first;
    public Node tail;

    // Insert node at the end of the list
    public void insertAtLast(int data) {
        Node n1 = new Node(data);

        if (first == null) {
            n1.link = n1;
            first = n1;
            tail = n1;
            return;
        }

        tail.link = n1;
        n1.link = first;
        tail = n1;
    }

    // Split the circular linked list
    void splitCLL() {
        if (first == null) {
            System.out.println("Underflow");
            return;
        } else if (first.link == first) {
            System.out.println("Only one node is present in the list");
            return;
        }

        Node temp = first;
        int count = 1;

        // Count the number of nodes in the circular linked list
        while (temp.link != first) {
            temp = temp.link;
            count++;
        }

        Node first2 = null;
        Node tail1 = first;
        temp = first;

        // Move temp to the middle of the list
        for (int i = 0; i < (count / 2) - 1; i++) {
            temp = temp.link;
        }

        // Split the list
        first2 = temp.link;
        temp.link = first;
        tail1 = temp;

        // Find the last node of the second half and complete the circle
        Node tail2 = first2;
        while (tail2.link != first) {
            tail2 = tail2.link;
        }
        tail2.link = first2;

        // Display both halves
        System.out.println("First half:");
        display(first);
        System.out.println("Second half:");
        display(first2);
    }

    // Display the circular linked list
    void display(Node startNode) {
        if (startNode == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = startNode;
        do {
            System.out.print(temp.data + " ");
            temp = temp.link;
        } while (temp != startNode);
        System.out.println();
    }
}

public class SplitCirculLL_13_74 {
    public static void main(String[] args) {
        CircularLL list = new CircularLL();
        list.insertAtLast(10);
        list.insertAtLast(20);
        list.insertAtLast(30);
        list.insertAtLast(40);
        list.insertAtLast(50);
        list.insertAtLast(60);

        System.out.println("Original List:");
        list.display(list.first);

        list.splitCLL();
    }
}