import java.util.ArrayList;
import java.util.Scanner;

public class Rotate_Array_K_Step {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = sc.nextInt();

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            if (i < a.length - k) {
                first.add(a[i]);
            } else {
                second.add(a[i]);
            }
        }
        System.out.println("Second = " + second);
        System.out.println("first = " + first);

        // Add both Second + First
    }
}
