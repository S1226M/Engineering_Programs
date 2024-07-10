import java.util.*;

class stack {
    String s;
    char a[];
    int top;
    
    stack(String s) {
        this.s = s;
        a = new char[s.length()];
        top = -1;
    }
    
    public void push(char x) {
        if (top >= a.length - 1) {
            System.out.println("Stack overflow");
        } else {
            top++;
            a[top] = x;
        }
    }
    
    public char pop() {
        if (top == -1) {
            System.out.println("Stack underflow");
            return 0;
        } else {
            top--;
            return a[top + 1];
        }
    }
    
    public void recognize() {
        push('c');
        int i = 0;
        char c = s.charAt(i);
        while (c != 'c') {
            if (c == ' ') {
                System.out.println("Invalid String");
                return;
            } else {
                push(c);
                i++;
                if (i >= s.length()) {
                    System.out.println("Invalid String");
                    return;
                }
                c = s.charAt(i);
            }
        }

        if (i == s.length() - 1) {
            System.out.println("Invalid String");
            return;
        }

        i++; // Move past 'c'
        while (i < s.length()) {
            c = s.charAt(i);
            char x = pop();
            if (c != x) {
                System.out.println("Invalid String");
                return;
            }
            i++;
        }

        if (top != 0) {
            System.out.println("Invalid String");
        } else {
            System.out.println("Valid String");
        }
    }
}

public class StringRecognize_7_39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please Enter String: ");
        String input = sc.next();
        stack s = new stack(input);
        s.recognize();
    }
}
