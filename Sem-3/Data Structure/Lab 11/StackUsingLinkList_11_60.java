//push , pop , peek , change
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

    // push
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

    // pop
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

    // peep
    void findTheElement(int x) {
        Node last = first;
        int count = 1;
        if (first == null) {
            System.out.println("LL not found");
        } else if (first.link == null) {
            System.out.println(first.info);
        } else {
            while (last.link != null) {
                last = last.link;
                count++;
            }
            if (x <= 0 || x > count) {
                System.out.println("node dose not exist");
                return;
            }
            Node save = first;
            for (int i = 1; i < (count - x + 1); i++) {
                save = save.link;
            }
            System.out.println(save.info);
        }
    }

    // change
    void changeTheElement(int x, int y) {
        Node temp = first;
        while (temp.info != x) {
            temp = temp.link;
            if (temp.link == null && temp.info != x) {
                System.out.println("node does not exist");
                return;
            }
        }
        temp.info = y;
        System.out.println(temp.info);
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

public class StackUsingLinkList_11_60 {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtEnd(40);
        list.insertAtEnd(30);
        list.insertAtEnd(20);
        list.insertAtEnd(10);
        list.insertAtEnd(5);
        list.deleteAtLast();
        list.display();
        list.findTheElement(5);
        list.changeTheElement(15, 0);
        list.display();
    }
}