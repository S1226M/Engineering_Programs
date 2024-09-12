import java.util.Scanner;

public class InsersationShort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0 ; i < n ; i++){
            System.out.print("Enter the element : "+(i+1));
            a[i] = sc.nextInt();
        }
        //5,4,3,2,1,0
        for(int i=0 ; i<= n-1 ; i++){
            int j=i;
            while(j>0 && a[j-1]>a[j]){
                int temp = a[j-1];
                a[j-1] = a[j];
                a[j] = temp;
                j--;
            }
        }    
        for(int i=0 ; i<n ; i++){
            System.out.print(a[i]+" ");
        }  
    }
}