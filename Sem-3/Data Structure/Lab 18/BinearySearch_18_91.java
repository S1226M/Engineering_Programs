import java.util.Scanner;

public class BinearySearch_18_91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[10];
        arr[] = {1,2,3,4,5,6,7,8,9,10}
        int a = sc.nextInt();
        int first = arr[0];
        int last = arr[10];
        int mid = 0;
        boolean isFound = flase;
        while(mid <= max){
            mid = (first + last)/2;
            if(mid == a){
                isFound = true;
                break;
            }
            else if(arr[mid] < a){
                min = mid + 1;
            }
            else if(arr[mid] > a){
                max = mid - 1;
            }
        }
    }
}