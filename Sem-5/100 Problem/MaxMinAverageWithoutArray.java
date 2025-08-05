import java.util.Scanner;

public class MaxMinAverageWithoutArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers (n): ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        System.out.print("Enter number 1: ");
        int num = sc.nextInt();
        int max = num;
        int min = num;
        int sum = num;

        for (int i = 2; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            num = sc.nextInt();

            if (num > max)
                max = num;
            if (num < min)
                min = num;

            sum += num;
        }

        double average = (double) sum / n;

        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);
        System.out.println("Average: " + average);

        sc.close();
    }
}
