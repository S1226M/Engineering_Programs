import java.util.Scanner;

public class FindFecctorialOfAnumber_12_4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int ans = 1;
            for(int i=1;i<=a;i++){
                ans*=i;
            }
            System.out.println("Factorial of given number is : "+ans);
        }
    }
}
