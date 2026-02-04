import java.util.Scanner;
public class Problem_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n*n;
        int len = String.valueOf(n).length();
        int divisor = 1;
        for (int i = 0; i < len; i++) {
            divisor *= 10;
        }
        if((temp%divisor) == n){
            System.out.println("Number is Automorphic");
        }
        else{
            System.out.println("Number is not Automorphic");
        }
    }
}