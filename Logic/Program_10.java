import java.util.Scanner;

public class Program_10{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter The Size Of Array:");
        int n = sc.nextInt();

        int[] arr = new int[n+1];

        System.out.print("Enter Array Element:");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Which Element Enter:");
        int elem = sc.nextInt();

        System.out.print("Enter Position:");
        int pos = sc.nextInt();

        if(pos<1 || pos>n+1){
            System.out.print("Invalid Operation.");
        }
        else{
            for(int i=n;i>=pos;i--){
                arr[i] = arr[i-1];
            }
            arr[pos-1] = elem;

            System.out.println("Array:");
            for(int i=0;i<=n;i++){
                System.out.print(arr[i]+" ");
            }
        }
        sc.close();
    }
}