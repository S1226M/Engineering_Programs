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

    Node first = null;

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

    void deleteAtAlternet(){
        Node nodeCount = first;
        int count = 1;
        while(nodeCount.rptr != null){
            nodeCount = nodeCount.rptr;
            count++;
        }
        if(count >= 3){
            Node temp = first;
            Node save = temp.rptr.rptr;
        } else if(count ==2){
            System.out.println(first.info);
            return;
        } else {
            System.out.println("In LL only one node");
            return;
        }
        if(count % 2 == 0){
            Node temp = first;
            Node save = temp.rptr.rptr;
            while(save.rptr.rptr != null){
                temp.rptr = save;
                save.lptr = temp;
                temp = save;
                save = save.rptr.rptr;
            }
            save.rptr = null;
        } else {
            Node temp = first;
            Node save = temp.rptr.rptr;
            for(int i=1 ; i <= (count/2) ; i++){
                temp.rptr = save;
                save.lptr = temp;
                temp = save;
                save = save.rptr.rptr;
            }
        }
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
        list.deleteAtAlternet();
        // list.display();
    }
}
