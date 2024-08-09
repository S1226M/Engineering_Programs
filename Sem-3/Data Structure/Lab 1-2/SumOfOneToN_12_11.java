import java.util.Scanner;

public class SumOfOneToN_12_11 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = scanner.nextInt();
            int totalSum = 0;
            
            for (int i = 1; i <= n; i++) {
                //Sum of first i natural numbers is i * (i + 1) / 2
                int sumOfFirstINumbers = i * (i + 1) / 2;
                totalSum += sumOfFirstINumbers;
            }
            System.out.println("The sum of the series is: " + totalSum);
        }
    }
}
