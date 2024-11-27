
import java.util.*;

public class RemoveDuplicateFromArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i<n ; i++){
            System.out.println("enter element the "+(i+1)+"element");
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int repeatCount=1;
        for(int i=0 ; i<n-1 ; i++){
            if(arr[i] == arr[i+1]){
                int j=i;
                while(arr[j] == arr[j+1]){
                    repeatCount++;
                    j++;
                }
                j = i+1;
                for(int k = j ; k<n ; k++){
                    arr[k] = arr[j];
                    arr[j] = 0;
                    j++;
                }
            }
        }
        for(int i = 0 ; i<n ; i++){
            System.out.println(arr[i]+",");
        }
    }
}
