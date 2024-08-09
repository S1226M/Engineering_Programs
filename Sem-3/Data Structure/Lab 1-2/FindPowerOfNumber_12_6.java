import java.util.Scanner;

public class FindPowerOfNumber_12_6 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int base = sc.nextInt();
            int power = sc.nextInt();
            int ans = 1;
            for(int i=1 ; i<=power ; i++){
                ans *= base; 
            }
            System.out.println(ans);
        }
    }
}