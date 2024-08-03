import java.util.Scanner;

class Stack {
    char a[];
    int top;
    String s;

    Stack(String s) {
        this.s = s;
        this.top = -1;
        a = new char[s.length()];
    }

    void push(char c) {
        a[++top] = c;
    }

    char pop() {
        return a[top--];
    }

    void checkStringIsTrueOrNot() {
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                push(currentChar);
            } 
            else if (currentChar == '}' || currentChar == ')' || currentChar == ']') {
                if (top == -1) {
                    System.out.println("Invalid string");
                    return;
                }
                char tempPop = pop();
                if (currentChar == '}' && tempPop == '{') {
                    continue;
                } else if (currentChar == ')' && tempPop == '(') {
                    continue;
                } else if (currentChar == ']' && tempPop == '[') {
                    continue;
                } else {
                    System.out.println("Invalid string");
                    return;
                }
            }
        }
        if (top == -1) {
            System.out.println("Valid string");
        } else {
            System.out.println("Invalid string");
        }
    }
}

public class CheckGivenStringIsBalanceOrNot_7_41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack stack = new Stack(s);
        stack.checkStringIsTrueOrNot();
    }
}