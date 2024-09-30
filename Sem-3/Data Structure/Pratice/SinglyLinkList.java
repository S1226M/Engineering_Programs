class list{
    class  Node {
        int info;
        Node link;
    
        public Node(int data){
            this.info = data;
            this.link = null;
        }
    }

    public Node first = null;

    void insertAtFront(int x){
        Node newNode = new Node(x);
        if(first == null){
            first = newNode;
        }
        else{
            newNode.link =  first;
            first = newNode;
        }
    }

    void inseerAtEnd(int x){
        Node  newNode = new Node(x);
        if(first  == null){
            first = newNode;
        }
        else{
            while(first != null){
                first = first.link;
            }
            first.link = newNode;
        }
    }

    void inseerAtPosition(int x , int data){
        int count = 1;
        Node temp = first;
        while(temp != null){
            temp = temp.link;
            count++;
        }
        temp = first;
        for(int i = 1 ; i < count ; i++){
            temp = temp.link;
        }
        Node newNode = new Node(data);
        newNode.link = temp.link;
        temp.link = newNode;
    }

    void deletAtFirst(){
        if(first == null){
            return;
        }
        else{
            first = first.link;
        }
    }


    void deletAtLast(){
        Node temp = first;
        while(temp.link.link != null){
            temp = temp.link;
        }
        temp.link = null;
    }

}

public class SinglyLinkList {
    public static void main(String[] args) {
        
    }
}
