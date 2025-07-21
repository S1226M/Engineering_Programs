import java.util.*;

public class ArmstrongNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String n = sc.nextLine();
        int len = n.length();
        int sum = 0;

        for (int i = 0; i < len; i++) {
            int digit = n.charAt(i) - '0'; // convert char to int
            sum += Math.pow(digit, len);   // raise to power of number of digits
        }

        int original = Integer.parseInt(n);
        if (sum == original) {
            System.out.println(original + " is an Armstrong number.");
        } else {
            System.out.println(original + " is not an Armstrong number.");
        }

        sc.close();
    }
}
