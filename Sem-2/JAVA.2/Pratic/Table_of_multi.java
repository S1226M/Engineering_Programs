import java.util.*;
public class Table_of_multi{
    public static void multiplication(int n) {
        for (int i = 1; i <=10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        multiplication(input);
    }
}
