
import java.util.Scanner;

public class SelectionShort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0 ; i < n ; i++){
            System.out.print("Enter the element : "+(i+1));
            a[i] = sc.nextInt();
        }

        //5,4,3,2,1
        for(int i = 0 ; i< n ; i++){
            for(int j = i+1 ; j<n ; j++){
                if( a[i] > a[j] ){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for(int i=0 ; i<n ; i++){
            System.out.print(a[i]+" ");
        }
    }    
}
