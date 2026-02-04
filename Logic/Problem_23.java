import java.util.Scanner;

public class Problem_23 {
    public static void main(String[] args) {
        
        int arr[] = { 10, 20, 30, 40, 50 };
        
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int n = arr.length;
        k = k%n;

        int newArr[] = new int[arr.length];
        
        for(int i=0 ; i<n ; i++ ){
            newArr[(i+k)%n] = arr[i];
        }
        
        for(int i=0 ; i<newArr.length ; i++){
            System.out.println(newArr[i]);
        }
    }
}
