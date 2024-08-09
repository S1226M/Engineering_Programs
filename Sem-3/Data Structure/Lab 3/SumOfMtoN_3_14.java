import java.util.Scanner;

public class SumOfMtoN_3_14 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the value of n");
            int n = sc.nextInt();
            System.out.println("Enter the value of m");
            int m = sc.nextInt();
            int ans = 0;
            for(int i=n ; i<=m ; i++){
                ans =ans+i;
            }
            System.out.println("sum of n to m :"+ans);
        }
    }    
}
