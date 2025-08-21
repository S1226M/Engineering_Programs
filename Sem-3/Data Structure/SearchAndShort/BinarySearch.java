
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i<n ; i++){
            arr[i] = sc.nextInt();
            
        }

        System.out.println("Which element would you like to find");
        int a = sc.nextInt();
        int first = 0;
        int last = arr.length-1;
        int mid = 0 ;

        while(last>=first){
            if(arr[first]==a || arr[last]==a){
                System.out.println("Number found in array ");
                return;
            }

            mid = (first+last)/2;
            if(arr[mid] == a){
                System.out.println("Number found in the array at index : "+mid);
                return;
            }
            else if(arr[mid] > a){
                last = mid-1;
            }
            else if(arr[mid] < a){
                first = mid+1 ;
            }
        }
        System.out.println("Number not found in the array");
    }    
}
