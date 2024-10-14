import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sie of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i<n ; i++){
            System.out.println("Enter the element at index "+i);
            arr[i] = sc.nextInt();
        }

        for(int i = 0 ; i< arr.length ; i++){
            if(arr[i] == 5){
                System.out.println("Element found at index "+i);
            }
        }
    } 
}
