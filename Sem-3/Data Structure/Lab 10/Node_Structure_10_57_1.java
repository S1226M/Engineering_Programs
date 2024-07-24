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

    public void insertAtFirst(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            return;
        } else {
            newNode.link = first;
            first = newNode;
        }
    }

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

    void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
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

    int deleteAtLast() {
        if (first == null) {
            return -1; 
        } else if (first.link == null) { 
            int temp = first.info;
            first = null;
            return temp;
        } else {
            Node temp = first;
            while (temp.link.link != null) {
                temp = temp.link;
            }
            int lastInfo = temp.link.info;
            temp.link = null;
            return lastInfo;
        }
    }
}

public class Node_Structure_10_57_1 {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(30);
        list.insertAtEnd(40);
        list.deleteAtFirst();
        list.deleteAtLast();
        list.display();
    }
}
