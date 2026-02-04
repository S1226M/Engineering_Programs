import java.util.ArrayList;

public class HappyNumber {
    public static void main(String[] args) {
        int n = 8;
        int sum = 0;
        ArrayList<Integer> sequence = new ArrayList<>();

        while (n != 1) {

            if (sequence.contains(n)) {
                break;
            }

            sequence.add(n);
            sum = 0;

            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }

            n = sum;
        }
        if (n == 1) {
            System.out.println("Happy");
        } else {
            System.out.println("UnHappy");
        }
    }
}
