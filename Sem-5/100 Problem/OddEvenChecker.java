import java.util.Scanner;

public class OddEvenChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        // Use bitwise AND to check last bit
        if ((num & 1) == 1) {
            System.out.println(num + " is Odd");
        } else {
            System.out.println(num + " is Even");
        }

        scanner.close();
    }
}
