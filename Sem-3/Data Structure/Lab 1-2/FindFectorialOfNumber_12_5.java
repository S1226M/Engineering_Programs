import java.util.Scanner;
public class FindFectorialOfNumber_12_5 {
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();
        sc.close();  
        int result = factorial(n);
        System.out.println("The factorial of " + n + " is " + result);
    }
}
