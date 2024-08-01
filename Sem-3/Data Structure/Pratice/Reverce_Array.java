import java.util.Scanner;

public class Reverce_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0 ; i<n ; i++){
            System.out.println("enter the element "+i+" of array");
            arr1[i] = sc.nextInt();
        }
        int arr2[] = new int[n];
        int j = n-1;
        for(int i=0 ; i<n ; i++){
            arr2[i] = arr1[j];
            j--;
        }
        for(int i=0 ; i<n ; i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        for(int i=0 ; i<n ; i++){
            System.out.print(arr2[i]+" ");
        }
    }    
}
