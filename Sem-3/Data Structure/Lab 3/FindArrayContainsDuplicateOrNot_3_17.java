import java.util.Scanner;

public class FindArrayContainsDuplicateOrNot_3_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array :");
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0 ; i<size ; i++){
            arr[i] = sc.nextInt();
        }
        int num = 0;
        for(int i=0 ; i<size ; i++){
            for(int j=(i+1) ; j<size ; j++){
                if(arr[i]==arr[j]){
                    num++;
                }
            }
        }
        if(num == 0){
            System.out.println("given array dont have a duplicate number");
        }
        else{
            System.out.println("given array have a duplicate number");
        }
    }    
}
