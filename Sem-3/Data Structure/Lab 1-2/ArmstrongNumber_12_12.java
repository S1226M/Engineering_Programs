import java.util.Scanner;

public class ArmstrongNumber_12_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int originalNumber = sc.nextInt();
        int number = originalNumber;
        int sum = 0;
        int count = 0;
        
        while (number > 0) {
            count++;
            number = number / 10;
        }

        int digitCount = count;
        number = originalNumber;

        while (number > 0) {
            int lastDigit = number % 10;
            sum = sum + (int) Math.pow(lastDigit, digitCount);
            number = number / 10;
        }

        if (sum == originalNumber) {
            System.out.println("Given number is an Armstrong number");
        } else {
            System.out.println("Given number is not an Armstrong number");
        }

        sc.close();
    }
}
