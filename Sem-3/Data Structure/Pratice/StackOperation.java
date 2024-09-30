class stack{
    int arr[];
    int top;

    stack(int n){
        arr = new int[n];
        top = -1;
    }

    void push(int n){
        if(top >= arr.length-1){
            System.out.println("stack is over flow");
            return;
        }
        else{
            arr[++top] = n;
            return;
        }
    }

    void pop(){
        if(top < 0){
            System.out.println("stack i under flow");
            return;
        }
        else{
            System.out.println("top element is = "+arr[top]);
            top--;
            return;
        }
    }

    void peep(int n){
        if(top-n+1 < 0){
            System.out.println("Stack is under flow");
            return;
        }
        else{
            System.out.println("peep element is = "+arr[top-n+1]);
            arr[top-n+1] = 0;
            return;
        }
    }

    void change(int n , int x){
        if(top-n+1 < 0){
            System.out.println("Stack is under flow");
            return;
        }
        else{
            System.out.println("Changed element is = "+arr[top-n+1]);
            arr[top-n+1] = x;
        }
    }
}

public class StackOperation {
    public static void main(String[] args) {
        // make the object and call the function 
    }
}