class ll {
    static class Node { // Renamed to avoid conflict with org.w3c.dom.Node
        int info;
        Node link;

        public Node(int data) { // Corrected the constructor
            this.info = data;
            this.link = null;
        }
    }

    Node first = null;
    int count = 0;


    public void insertAtFirst(int x) {
        Node newNode = new Node(x);
        count++;
        if (first == null) {
            first = newNode;
        } else {
            newNode.link = first;
            first = newNode;
        }
        System.out.println("No of nodes = " + count);
    }

    public void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}

public class CountNumberOfNode_10_58 {
    public static void main(String[] args) {
        ll list = new ll();
        list.insertAtFirst(32);
        list.insertAtFirst(54);
        list.insertAtFirst(60);
        list.insertAtFirst(21);
        list.insertAtFirst(94);
        list.display();
    }
}
