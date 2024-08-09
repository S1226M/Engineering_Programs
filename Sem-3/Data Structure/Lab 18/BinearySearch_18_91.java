import java.util.Scanner;

public class BinearySearch_18_91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int a = sc.nextInt();
        int mid = 0;
        int first = 0;
        int last = arr.length - 1; 
        boolean isFound = false;
        while(mid <= last){
            mid = (first + last)/2;
            if(mid == a){
                isFound = true;
                break;
            }
            else if(arr[mid] < a){
                first = mid + 1;
            }
            else if(arr[mid] > a){
                last = mid - 1;
            }
        }
    }
}