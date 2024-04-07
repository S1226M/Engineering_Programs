public class SumOfIntegers {
    public static void main(String[] args) {
        int n = 10; // Change this to the desired number
        int sum = 0;

        // Calculate the sum of integers from 1 to n
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        // Print the result
        System.out.println("Sum of integers from 1 to " + n + " is: " + sum);
    }
}
