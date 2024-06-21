import java.util.Scanner;

public class InsertNumberAndShortArray_4_23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size = sc.nextInt();
        int arr1[] = new int[size];
        
        // Input the array elements
        for(int i = 0; i < size; i++) {
            System.out.println("Enter element " + i + ":");
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the number to add to the array:");
        int number = sc.nextInt();
        int arr2[] = new int[size + 1];
        boolean inserted = false;
        
        // Inserting the number into the new array in sorted order
        for(int i = 0, j = 0; i < size; i++, j++) {
            if (!inserted && number < arr1[i]) {
                arr2[j] = number;
                j++;
                inserted = true;
            }
            arr2[j] = arr1[i];
        }
        
        // If the number is greater than all elements, add it at the end
        if (!inserted) {
            arr2[size] = number;
        }

        // Output the new array
        System.out.println("New array:");
        for(int i = 0; i < size + 1; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}

