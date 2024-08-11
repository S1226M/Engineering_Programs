class LL1 {
    class Node {
        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }
    }

    public Node first = null;

    void insertAtEnd(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
            return;
        } else {
            Node temp = first;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = newNode;
        }
    }

    void display() {
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
    }

    void deleteDuplicate() {
        Node temp = first;
        Node save = first;
        while (temp.link != null) {
            if (temp.info == temp.link.info) {
                if(temp.link.link==null){
                    System.out.println(save.info);
                    return;
                }
                else{
                    temp.link = temp.link.link;
                }
            } else {
                System.out.print(save.info + " ");
                temp = temp.link;
                save = temp;
            }
        }
        // System.out.println(temp.info);
    }
}
public class RemoveDuplicateFromLL_12_69 {
    public static void main(String[] args) {
        LL1 l1=new LL1();
        l1.insertAtEnd(10);
        l1.insertAtEnd(20);
        l1.insertAtEnd(20);
        l1.insertAtEnd(20);
        l1.insertAtEnd(30);
        l1.insertAtEnd(30);
        l1.insertAtEnd(40);
        l1.insertAtEnd(45);
        l1.insertAtEnd(45);
        l1.display();
        System.out.println("");
        l1.deleteDuplicate();
    }
    
}
