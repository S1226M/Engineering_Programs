import java.util.Scanner;

public class Factor_Of_Number{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int Fac = 1;
        System.out.print("Factors of " + n + " are: ");
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}