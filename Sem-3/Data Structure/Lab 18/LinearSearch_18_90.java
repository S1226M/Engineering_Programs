import java.util.Scanner;

public class LinearSearch_18_90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        for(int i=0 ; i<n ; i++){
            if(arr[i] == a){
                System.out.println("no a found at index "+i+" and position is = "+(i+1));
            }
        }
    }
}