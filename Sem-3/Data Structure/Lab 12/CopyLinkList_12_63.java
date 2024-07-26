class ll{
    static class Node{
        int info;
        Node link;

        public Node(int data){
            this.info = data;
            this.link = null;
        }
    }

    public Node first = null;

    public void insertAtFirst(int x){
        Node newNode = new Node(x);
        if(first == null){
            first = newNode;
        } else {
            newNode.link = first;
            first = newNode;
        }
    }

    public void display(){
        Node temp = first;
        while(temp != null){
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }

    public void CopyLinkList(){
        Node temp = first;
        Node tail = null;
        Node head = null;
        System.out.println("");
        while(temp!= null){
            Node newNode = new Node(temp.info);
            if(head == null){
                head = newNode;
                tail = newNode;
                System.out.print(head.info+" ");
            }
            else{
                tail.link = newNode;
                tail = tail.link;
                System.out.print(tail.info+" ");
            }
            temp=temp.link;
        }
    }
}
public class CopyLinkList_12_63 {
    public static void main(String[] args) {
        ll list1 = new ll();
        list1.insertAtFirst(32);
        list1.insertAtFirst(54);
        list1.insertAtFirst(60);
        list1.insertAtFirst(21);
        list1.insertAtFirst(94);
        list1.display();
        list1.CopyLinkList();
    }    
}