import java.util.Scanner;

public class ShellShort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0 ; i < n ; i++){
            System.out.print("Enter the element : "+(i+1));
            a[i] = sc.nextInt();
        }

        for(int gap = n/2 ; gap>=1 ; gap/=2){
            for(int i = gap ; i < n ; i++){
                for(int j = i-gap ; j>=0 ; j-=gap){
                    if(a[j] > a[j+gap]){
                        int temp = a[j];
                        a[j] = a[j+gap];
                        a[j+gap] = temp;
                    }
                }
            }
        }

        for(int i=0 ; i<n ; i++){
            System.out.print(a[i]+" ");
        }
    }
}