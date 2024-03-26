import java.util.Scanner;

public class Sum_of_n_natural_numa{
    static int sum(int n){
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = sum(n);
        System.out.println("Sum of numbers from 0 to " + n + " is: " + result);
    }
}
