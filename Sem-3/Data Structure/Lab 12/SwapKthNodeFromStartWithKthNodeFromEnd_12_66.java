
import java.util.Scanner;
class LL {
    class Node {
        int info;
        Node link;

        Node(int data) {
            this.info = data;
            this.link = null;
        }
    }
    
    Node first = null;

    void insertAtEnd(int x) {
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

    void Swap(int ks , int ke){
        int count = 1;
        Node countNode = first;
        Node temp = first;
        Node save = first;
        
        for(int i = 1 ; i < ks ; i++){
            temp = temp.link;
        }
        
        while(countNode.link != null){
            countNode = countNode.link;
            count++;
        }
        
        int kthe = (count-ke+1);
        for(int i=1 ; i < kthe ; i++){
            save = save.link;
        }

        if(kthe > ks){
            int a = temp.info;
            temp.info = save.info;
            save.info = a;
        } else{
            System.out.println("Link list have only "+count+" Node so,enter valid number");
        }
    }

    void displayList() {
        Node temp = first;
        if (temp == null) {
            System.out.println("Linked list is empty");
            return;
        }
        while (temp != null) {
            System.out.print(temp.info + " ");
            temp = temp.link;
        }
        System.out.println();
    }
}
public class SwapKthNodeFromStartWithKthNodeFromEnd_12_66 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter from kth");
        int ks = sc.nextInt();
        System.out.println("Enter kth from end");
        int ke = sc.nextInt();
        LL list = new LL();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(4);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.displayList();
        list.Swap(ks,ke);
        list.displayList();
        sc.close();
    }
}
