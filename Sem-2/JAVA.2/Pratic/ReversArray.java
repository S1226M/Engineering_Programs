import java.util.*;
public class ReversArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int size = sc.nextInt();
        int a[]=new int[size];
        int b[] = new int[size];
        for(int i=0;i<a.length;i++){
            System.out.println("enter the value of array");
            a[i]=sc.nextInt();
        }
        for(int i=a.length;i>=0;i--){
            for(int j=0;i<b.length;j++){
                a[i]=b[j];
                System.out.println(" = "+b[j]);
            }
        }
      
    }
}
