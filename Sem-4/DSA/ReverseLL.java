class LL{
    class  Node{
        int info;
        Node link;

        Node(int data){
            this.info = data;
            this.link = null;
        }
    }
    Node first = null;

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

    void reverse() {
        if (first == null || first.link == null) {
            return;
        }
        Node prev = null;
        Node current = first;
        while (current != null) {
            Node next = current.link;
            current.link = prev;
            prev = current;
            current = next;
        }
        first = prev;
    }
    boolean isPelindrom(){
        Node temp = first;
        int count = 1;
        while(temp.link != null){
            temp = temp.link;
            count++;
        }
        
    }
    
}

public class ReverseLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(20);
        list.insertAtEnd(10);
        list.display();
        list.reverse();
        list.display();
    }    
}
