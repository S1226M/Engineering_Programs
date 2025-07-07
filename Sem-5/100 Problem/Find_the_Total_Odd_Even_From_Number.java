
import java.util.Scanner;

public class Find_the_Total_Odd_Even_From_Number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String number = sc.nextLine();
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            if ((digit - '0') % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Total Even Digits: " + evenCount);
        System.out.println("Total Odd Digits: " + oddCount);
    }
}
