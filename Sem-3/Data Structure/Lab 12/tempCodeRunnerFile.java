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