import java.util.Scanner;
import java.util.Stack;

class valueOfChar {
    public static int inputPS(char next) {
        if (next == '+' || next == '-') {
            return 1;
        } else if (next == '*' || next == '/') {
            return 3;
        } else if (next == '^') {
            return 6;
        } else if (Character.isLetter(next)) {
            return 7;
        } else if (next == '(') {
            return 9;
        } else if (next == ')') {
            return 0;
        }
        return -1;
    }

    public static int stackPS(char next) {
        if (next == '+' || next == '-') {
            return 2;
        } else if (next == '*' || next == '/') {
            return 4;
        } else if (next == '^') {
            return 5;
        } else if (Character.isLetter(next)) {
            return 8;
        } else if (next == '(') {
            return 0;
        }
        return -1;
    }

    public static int renk(char next) {
        if (next == '+' || next == '-' || next == '/' || next == '*') {
            return -1;
        }
        return 1;
    }

    public static String stringPost(String a) {
        Stack<Character> st = new Stack<>();
        StringBuilder police = new StringBuilder();
        st.push('(');
        a += ")";
        int renk = 0;

        for (int i = 0; i < a.length(); i++) {
            char current = a.charAt(i);
            if (st.isEmpty()) {
                return "Invalid";
            } else {
                while (stackPS(st.peek()) > inputPS(current)) {
                    char temp = st.pop();
                    police.append(temp);
                    renk += renk(temp);
                    if (renk < 1) {
                        return "Invalid";
                    }
                }
                if (stackPS(st.peek()) != inputPS(current)) {
                    st.push(current);
                } else {
                    st.pop();
                }
            }
        }
        return police.toString();
    }
}

public class InfixToPostfix_8_45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the infix expression : ");
        String a = sc.next();
        String postfix = valueOfChar.stringPost(a);
        System.out.println("Postfix expression = " + postfix);
    }
}