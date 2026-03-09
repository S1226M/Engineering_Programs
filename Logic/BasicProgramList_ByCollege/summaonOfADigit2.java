public class summaonOfADigit2 {
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n % 10 + sumOfDigits(n / 10);
        }
    }

    public static void main(String[] args) {
        int n = 12345;
        int result = sumOfDigits(n);
        System.out.println("Sum of digits of " + n + " is: " + result);
    }
}
