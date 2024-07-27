import java.util.Scanner;

class CQueue{
    int arr[];
    int n;
    int f = -1;
    int r = -1;

    CQueue(int n){
        this.n = n;
        arr = new int[n];
    }

    void cQueueInsert(int x){
        if((r + 1) % n == f){
            System.out.println("Overflow");
            return;
        }
        if(r == -1){
            r = 0;
            f = 0;
        } else {
            r = (r + 1) % n;
        }
        arr[r] = x;
    }

    int cQueueDelete(){
        if(f == -1){
            System.out.println("Underflow");
            return -1;
        }
        int y = arr[f];
        if(f == r){
            f = -1;
            r = -1;
        } else {
            f = (f + 1) % n;
        }
        return y;
    }

    void display(){
        if(r == -1){
            System.out.println("Queue is empty");
            return;
        }
        int i = f;
        while(true){
            System.out.print(arr[i] + " ");
            if(i == r){
                break;
            }
            i = (i + 1) % n;
        }
        System.out.println();
    }
}

public class CQueue_9_51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the queue: ");
        int n = sc.nextInt();
        CQueue q = new CQueue(n);
        q.cQueueInsert(10);
        q.cQueueInsert(20);
        q.cQueueInsert(30);
        q.cQueueInsert(40);
        q.cQueueInsert(50);
        q.display();
        System.out.println("Deleted element: " + q.cQueueDelete());
        q.display();
    }
}
