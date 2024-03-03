//3
import java.util.Scanner;
public class arraya_avg {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] ar=new int[4];
        System.out.println("plese enter an array");
        for(int i=0;i<ar.length;i++){
            ar[i]=sc.nextInt();
        }
        int sun=0;
        for(int i=0;i<ar.length;i++){
            sun=sun+ar[i];
        }
        double avg;
        avg=(double)sun/4;
        System.out.println("the avg of thr 4 numbers is"+avg);
        sc.close();
    }
}
