import java.util.*;

public class RemoveDuplicateFromArray_4_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        
        int uniqueIndex = 0;
        
        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[uniqueIndex]) {
                uniqueIndex++;
                arr[uniqueIndex] = arr[i];
            }
        }
        
        System.out.println("Array without duplicates: ");
        for (int i = 0; i <= uniqueIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
