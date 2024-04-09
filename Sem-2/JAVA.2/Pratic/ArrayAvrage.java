import java.util.*;
public class ArrayAvrage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of array");
        int size = sc.nextInt();
        int a[]=new int[size];
        for(int i=0;i<a.length;i++){
            System.out.println("enter the value of array");
            a[i]=sc.nextInt();
        }
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum += a[i];
        }
        System.out.println("sum of array is ="+sum);
        System.out.println("avrage of sum is ="+(sum/(size)));
    }
}
