import java.util.Scanner;

public class ReplaceNumber1WithNumber2_3_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0; i<size ; i++){
            arr[i] = sc.nextInt();
        }
        int index1 = sc.nextInt();
        int index2 = sc.nextInt();
        int a = arr[index1];
        int b = arr[index2];
        arr[index1] = b;
        arr[index2] = a;
        for(int i=0 ; i<size ; i++){
            System.out.print(arr[i]+" ,");
        }
    }
}
