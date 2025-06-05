import java.util.Scanner;
public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        
        // Reading array elements
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }

        // Bubble Sort algorithm
        for (int i = 0; i < n - 1; i++) { // Outer loop for the number of passes
            for (int j = 0; j < n - i - 1; j++) { // Inner loop for each pass
                if (a[j] > a[j + 1]) {
                    // Swap elements
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        // Printing sorted array
        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}