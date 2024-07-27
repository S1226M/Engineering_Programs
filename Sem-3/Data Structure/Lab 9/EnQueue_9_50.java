import java.util.Scanner;

class Queue{
    int arr[];
    int n;
    int f=0;
    int r=0;

    Queue(int n){
        this.n = n;
        arr = new int[n];
    }

    void enqueue(int x){
        if(r>=n){
            System.out.println("over flow");
            return;
        }
        else{
            r++;
            arr[r] = x;
            if(f==0){
                f=1;
            }
            return;
        }
    }

    int dequeue(){
        if(f==0){
            System.out.println("Under flow");
            return;
        }
        else{
            int y = arr[f];
            if(f==r){
                f=0;
                r=0;
            }
            else{
                f++;
            }
            return y;
        }
    }

    void display(){
        for(int i=f ; i<=r ; i++){
            System.out.print(arr[i]+" ");
        }
    }
} 
public class EnQueue_9_50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue q = new Queue(n);
        System.out.println("Full Queue");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();
        System.out.println("Queue after dequeue");
        q.dequeue();
    }
}
