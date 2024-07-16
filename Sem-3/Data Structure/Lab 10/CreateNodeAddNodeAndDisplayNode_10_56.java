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
}

public class CreateNodeAddNodeAndDisplayNode_10_56 {
    public static void main(String[] args) {
        ll list = new ll();
        list.insertAtFirst(32);
        list.insertAtFirst(54);
        list.insertAtFirst(60);
        list.insertAtFirst(21);
        list.insertAtFirst(94);
        list.display();
    }    
}