import java.util.Scanner;
 
public class SelectionShort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sie of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            System.out.println("Enter the element at index "+i);
            arr[i] = sc.nextInt();
        }

        //[5,2,6,4,1]
        for(int  i = 0 ; i<n-1 ; i++){
           for(int j=i+1 ; j<n ; j++){
            if(arr[i]>arr[j]){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
           }
        }

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}