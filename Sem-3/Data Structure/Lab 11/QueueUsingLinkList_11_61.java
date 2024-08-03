class LL {
    class Node {
        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    public Node first = null;

    public void insertAtEnd(int x) {
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

    int deleteAtFirst() {
        if (first == null) {
            return -1;
        } else {
            int temp = first.info;
            first = first.link;
            return temp;
        }
    }

    void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}

public class QueueUsingLinkList_11_61 {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.display();
        list.deleteAtFirst();
        list.display();
    }
}
