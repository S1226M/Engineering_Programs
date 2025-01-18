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
    boolean isPalindrome() {
        Node temp = first;
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        while (temp != null) {
            stack.push(temp.info);
            temp = temp.link;
        }
        temp = first;
        while (temp != null) {
            if (temp.info != stack.pop()) {
                return false;
            }
            temp = temp.link;
        }
        return true;
    }    
}
public class ReverseLL {
    public static void main(String[] args) {
        LL list = new LL();
        list.insertAtEnd(30);
        list.insertAtEnd(20);
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        System.out.print("Original List: ");
        list.display();

        list.reverse();
        System.out.print("Reversed List: ");
        list.display();

        boolean isPalindrome = list.isPalindrome();
        System.out.println("Is Palindrome: " + isPalindrome);
    }
}
