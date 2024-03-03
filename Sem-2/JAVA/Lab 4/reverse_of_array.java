//4
import java.util.Scanner;
public class reverse_of_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ar[] = new int[5];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = sc.nextInt();
        }
        int[] b = new int[5];
        System.out.println("the reverse of  this array is:-");
        for (int i = b.length - 1; i >= 0; i--) {
            b[i] = ar[i];
            System.out.println(b[i]);
        }
        sc.close();
    }
}
