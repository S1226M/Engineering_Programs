import java.util.Scanner;

public class MergeTwoUnsortedArrays_4_26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of first array");
        int a = sc.nextInt();
        int arr1[] = new int[a];
        System.out.println("Size of second array");
        int b = sc.nextInt();
        int arr2[] = new int[b];
        
        System.out.println("Enter elements of first array:");
        for(int i = 0; i < a; i++){
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter elements of second array:");
        for(int i = 0; i < b; i++){
            arr2[i] = sc.nextInt();
        }

        int c = a + b;
        int[] arr3 = new int[c];

        for(int i = 0; i < a; i++){
            arr3[i] = arr1[i];
        }

        for(int i = 0; i < b; i++){
            arr3[a + i] = arr2[i];
        }

        System.out.println("Merged array:");
        for(int i = 0; i < c; i++){
            System.out.print(arr3[i] + " ");
        }
    }
}