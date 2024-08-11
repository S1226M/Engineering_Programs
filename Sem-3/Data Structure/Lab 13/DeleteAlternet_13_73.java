class ll {
    class Node {
        int info;
        Node rptr;
        Node lptr;

        Node(int data) {
            this.info = data;
            this.rptr = null;
            this.lptr = null;
        }
    }

    Node first = null;

    void DLLIF(int x) {
        Node newNode = new Node(x);
        if (first != null) {
            newNode.rptr = first;
            first.lptr = newNode;
        }
        first = newNode;
    }

    void deleteAtAlternet() {
        if (first == null || first.rptr == null) {
            System.out.println("List is too short to delete alternates.");
            return;
        }

        Node current = first;
        while (current != null && current.rptr != null) {
            Node nodeToDelete = current.rptr;
            current.rptr = nodeToDelete.rptr;

            if (nodeToDelete.rptr != null) {
                nodeToDelete.rptr.lptr = current;
            }

            current = current.rptr;
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

public class DeleteAlternet_13_73 {
    public static void main(String[] args) {
        ll list = new ll();
        list.DLLIF(50);
        list.DLLIF(40);
        list.DLLIF(30);
        list.DLLIF(20);
        list.DLLIF(10);

        System.out.println("Before deleting alternates:");
        list.display();

        list.deleteAtAlternet();

        System.out.println("After deleting alternates:");
        list.display();
    }
}
