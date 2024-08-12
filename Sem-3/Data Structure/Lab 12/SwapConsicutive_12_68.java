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

    // Method to insert at the end of the list
    void insertAtEnd(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    // Method to swap alternate nodes
    void Swap() {
        if (first == null || first.link == null) {
            System.out.println("List is empty or has only one node. No swapping needed.");
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

    // Method to handle custom swapping logic (you can customize this if needed)
    void swapping() {
        if (first == null || first.link == null) {
            System.out.println("List is empty or has only one node. No swapping needed.");
            return;
        }

        Node temp = first;
        while (temp != null && temp.link != null) {
            Node next = temp.link;
            int data = temp.info;
            temp.info = next.info;
            next.info = data;

            temp = next.link;
        }
    }

    // Method to display the list
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

public class SwapConsicutive_12_68 {
    public static void main(String[] args) {
        ll list = new ll();
        list.insertAtEnd(18);
        list.insertAtEnd(6);
        list.insertAtEnd(10);
        list.insertAtEnd(3);

        System.out.println("Original List:");
        list.displayList();

        // list.swapping();  // Swaps alternate nodes by value
        // System.out.println("List after swapping alternate nodes:");
        // list.displayList();

        list.Swap();  // Swaps alternate nodes by changing links
        System.out.println("List after swapping alternate nodes (by changing links):");
        list.displayList();
    }
}
