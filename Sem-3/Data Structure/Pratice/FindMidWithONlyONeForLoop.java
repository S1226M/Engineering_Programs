

class ll {
    static class Node {
        int info;
        Node link;

        public Node(int data) {
            this.info = data;
            this.link = null;
        }
    }
    Node first = null;

    public void insertAtFirst(int x) {
        Node newNode = new Node(x);
        if (first == null) {
            first = newNode;
        } else {
            newNode.link = first;
            first = newNode;
        }
    }

    void kthFind(){
        Node temp = first;
        Node save = first;
        while(save.link != null && save.link.link != null){
            temp = temp.link;
            save = save.link.link;
        }
        System.out.println(temp.info);
    }
} 

public class FindMidWithONlyONeForLoop {
    public static void main(String[] args) {
        ll list = new ll();
        list.insertAtFirst(32);
        list.insertAtFirst(54);
        list.insertAtFirst(60);
        list.insertAtFirst(21);
        list.insertAtFirst(94);
        list.insertAtFirst(94);
        list.kthFind();
    }    
}
