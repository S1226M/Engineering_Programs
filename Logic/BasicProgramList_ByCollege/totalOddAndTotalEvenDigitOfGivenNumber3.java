import java.util.Scanner;

public class totalOddAndTotalEvenDigitOfGivenNumber3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n > 0) {
            int temp = n % 10;
            if (temp % 2 == 0) {
                System.out.println("Even digit: " + temp);
            } else {
                System.out.println("Odd digit: " + temp);
            }
            n = n / 10;
        }
    }
}
