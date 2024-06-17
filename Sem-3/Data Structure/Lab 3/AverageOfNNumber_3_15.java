import java.util.*;
public class AverageOfNNumber_3_15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        int ans = 0;
        for(int i=0 ; i<n ; i++){
            System.out.print("Index a["+i+"] = ");
            arr[i] = sc.nextInt();
            ans=ans+arr[i];
        }
        int average = (ans/n);
        System.out.println("Answer is = "+average);
    }    
}
