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

    // Method to insert a node at the end of the linked list
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

    void sortList() {
        if (first == null) {
            System.out.println("underflow");
            return;
        }
        Node prev, next;
        for (prev = first; prev != null; prev = prev.link) {
            for (next = prev.link; next != null; next = next.link) {
                if (prev.info > next.info) {
                    int temp = prev.info;
                    prev.info = next.info;
                    next.info = temp;
                }
            }
        }
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

public class ShortLL_12_65 {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtEnd(4);
        list.insertAtEnd(1);
        list.insertAtEnd(3);
        list.insertAtEnd(2);
        
        System.out.println("Linked list before sorting:");
        list.displayList();

        list.sortList();
        
        System.out.println("Linked list after sorting:");
        list.displayList();
    }
}
