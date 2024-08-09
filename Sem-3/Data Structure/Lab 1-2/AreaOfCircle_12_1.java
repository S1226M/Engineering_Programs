import java.util.Scanner;

public class AreaOfCircle_12_1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter the value of radious of a circle :");
            int r = sc.nextInt();
            double ans = 3.14*r*r;
            System.err.println("Radious of circle is ="+ans);
        }
    }
}