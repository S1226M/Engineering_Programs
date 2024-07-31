import java.util.*;

class stack{
    String s;
    char a[];
    int top;

    public void stack(String s){
        this.s=s;
        this.top=-1;
        a = new char[s.length()];
    }

    public void push(char x){
        if(top >= s.length()-1){
            System.out.println("Stack over flow");
        }
        else{
            top++;
            a[top++]=x;
        }
    }

    public void pop(){
        if(top == -1){
            System.out.println("Stack under flow");
        }
        else{
            top--;
            return;
        }
    }

    public void recognizeAIBI(String input){
        int length = input.length();
        if (length % 2 != 0) {
            System.out.println("Invalid string");
            return;
        }
        else{
            if(input.charAt(0) == input.charAt(2) && input.charAt(1)>=1 && input.charAt(3)>=1){
                System.out.println("Valid string");
            }
            else{
                System.out.println("Invalid string");
            }
        }
    }
}

public class StringRecognizeAIBI_7_40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string");
        String input = sc.next();
        stack s = new stack();
        s.recognizeAIBI(input);
    }
}