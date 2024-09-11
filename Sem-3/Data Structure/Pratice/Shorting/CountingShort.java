import java.util.Scanner;

public class CountingShort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0 ; i < n ; i++){
            System.out.print("Enter the element : "+(i+1));
            a[i] = sc.nextInt();
        }

        int max = a[0];
        for(int i = 1 ; i < n ; i++){
            if(max < a[i]){
                max = a[i];
            }
        }

        int b[] = new int[max];
        int count = 0;
        for(int i = 1 ; i <= max ; i++){
            for(int j = 0 ; j < n ; j++){
                if(a[j] == i){
                    count++;
                }
            }
            b[i-1] = count;
        }

        for(int i=0 ; i<n ; i++){
            System.out.print(b[i]+" ");
        }
    }
}
