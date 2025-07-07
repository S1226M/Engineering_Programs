import java.util.Scanner;
//------------------Iterative Approach------------------//
// public class Fibonacci_Series {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         System.out.println("Enter the number of terms: ");
//         int n = sc.nextInt();
//         int a = 0, b = 1, c;
//         System.out.println("Fibonacci Series: ");
//         System.out.print(a + " " + b + " ");
//         for(int i = 1 ; i<=n-2 ; i++) {
//             c = a + b;
//             a = b;
//             b = c;
//             System.out.print(c + " ");
//         }
//     }   
// }

//------------------Recursive Approach------------------//
public class Fibonacci_Series {
    public static int print_fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return print_fibonacci(n - 1) + print_fibonacci(n - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of terms: ");
        int n = sc.nextInt();
        System.out.println("Fibonacci series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(print_fibonacci(i) + " ");
        }
        print_fibonacci(n);
    }
}