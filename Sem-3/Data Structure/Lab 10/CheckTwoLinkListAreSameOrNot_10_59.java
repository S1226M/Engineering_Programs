class LinkedList {
    class Node {
        int info;
        Node link;

        Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    Node first = null;

    void addNode(int data) {
        Node newNode = new Node(data);
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

    int getNodeCount() {
        int count = 0;
        Node temp = first;
        while (temp != null) {
            count++;
            temp = temp.link;
        }
        return count;
    }

    boolean compareLists(LinkedList list2) {
        if (this.getNodeCount() != list2.getNodeCount()) {
            return false;
        }

        Node temp1 = this.first;
        Node temp2 = list2.first;

        while (temp1 != null && temp2 != null) {
            if (temp1.info != temp2.info) {
                return false;
            }
            temp1 = temp1.link;
            temp2 = temp2.link;
        }

        return true;
    }
}

public class CheckTwoLinkListAreSameOrNot_10_59 {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(3);

        list2.addNode(1);
        list2.addNode(2);
        list2.addNode(3);

        boolean ans = list1.compareLists(list2);

        if (ans) {
            System.out.println("The two linked lists are the same.");
        } else {
            System.out.println("The two linked lists are not the same.");
        }
    }
}
