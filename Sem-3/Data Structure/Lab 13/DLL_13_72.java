class ll {
    class Node {
        int info;
        Node lptr;
        Node rptr;

        Node(int data) {
            this.info = data;
            this.lptr = null;
            this.rptr = null;
        }
    }

    private Node first = null;

    void DLLIF(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
        } else {
            newNode.rptr = first;
            first.lptr = newNode;
            first = newNode;
        }
    }

    void DLLIL(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
        } else {
            Node temp = first;
            while (temp.rptr != null) {
                temp = temp.rptr;
            }
            temp.rptr = newNode;
            newNode.lptr = temp;
        }
    }

    void DLLDP(int x) {
        if (first == null) {
            System.out.println("The list is empty.");
            return;
        }

        Node temp = first;

        if (x == 1) {
            if (first.rptr == null) {
                first = null;
            } else {
                first = first.rptr;
                first.lptr = null;
            }
            return;
        }
        for (int i = 1; i < x && temp != null; i++) {
            temp = temp.rptr;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        if (temp.rptr != null) {
            temp.rptr.lptr = temp.lptr;
        }
        if (temp.lptr != null) {
            temp.lptr.rptr = temp.rptr;
        }
    }

    void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.rptr;
        }
        System.out.println();
    }
}

public class DLL_13_72 {
    public static void main(String[] args) {
        ll list = new ll();
        list.DLLIF(40);
        list.DLLIF(30);
        list.DLLIF(20);
        list.DLLIF(10);
        list.display();

        list.DLLIL(50);
        list.display();

        list.DLLDP(3);
        list.display();
    }
}
