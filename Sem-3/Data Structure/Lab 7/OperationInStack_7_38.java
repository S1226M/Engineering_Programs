class Stackx{
    int arr[];
    int top;
    Stackx(int n){
        arr=new int[n];
        top=-1;
    }
    void push(int x){
        if(top>=arr.length){
            System.out.println("Stack is full");
        }
        else{
            top++;
            arr[top]=x;
            return;
        }
    }
    int pop(){
        if(top==-1){
            System.out.println("Stack is empty");
            return 0;
        }
            top--;
            System.out.println(arr[top+1]);
            arr[top+1]=0;
            return arr[top+1];
    }
    void displayStack(){
        for(int i=0;i<=top;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    int peep(int i){
        if(top-i+1<0){
            System.out.println("Stack is empty");
            return 0;
        }
        else{
            System.out.println(arr[top-i+1]);
            arr[top-i+1]=0;
            return arr[top-i+1];
        }
    }
    void change(int i,int x){
        if(top-i+1<0){
            System.out.println("Stack is empty");
        }
        else{
            arr[top-i+1]=x;
        }
    }
}
public class OperationInStack_7_38{
    public static void main(String[] args) {
        Stackx s=new Stackx(5);
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.displayStack();
        s.pop();
        s.displayStack();
        s.peep(3);
        s.displayStack();
        s.change(3,5);
        s.displayStack();
    }
}