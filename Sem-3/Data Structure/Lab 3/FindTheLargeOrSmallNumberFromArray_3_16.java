import java.util.Scanner;

public class FindTheLargeOrSmallNumberFromArray_3_16 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the size of array");
            int n = sc.nextInt();
            int arr[] = new int[n];
            int Position_Large = 0;
            int Position_Small = 0;
            for (int i = 0; i < n; i++) {
                System.out.print("Enter the element a[" + i + "]: ");
                arr[i] = sc.nextInt();
            }

            int Largest = arr[0];
            int Smallest = arr[0];

            for (int i = 1; i < n; i++) {
                if (arr[i] > Largest) {
                    Largest = arr[i];
                    Position_Large = i;
                }
                if (arr[i] < Smallest) {
                    Smallest = arr[i];
                    Position_Small = i;
                }
            }
            System.out.println("Smallest number is = " + Smallest + " and its position is = " + Position_Small);
            System.out.println("Largest number is = " + Largest + " and its position is = " + Position_Large);
        }
    }
}