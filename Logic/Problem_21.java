import java.util.Scanner;

public class Problem_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i<n ; i++){
            System.out.print("Enter "+(i+1)+"th Element : ");
            arr[i] = sc.nextInt();
        }

        for(int i=0 ; i<n-1 ; i++){
            for(int j=i+1 ; j<n ; j++){
                if(arr[j] < arr[i]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
