import java.util.Scanner;

public class Problem_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int arr[] = {2,3,5};
        for (int i : arr) {
            while(temp%i == 0){
                temp /= i;
            }
        }
        if(temp == 1){
            System.out.println(n+" is ugly number");
        }
        else{
            System.out.println(n+" is not ugly number");
        }
    }
}
