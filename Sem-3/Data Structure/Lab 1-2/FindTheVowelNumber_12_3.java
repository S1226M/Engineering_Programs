import java.util.Scanner;

public class FindTheVowelNumber_12_3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the character to check if it is a vowel: ");
            char ch = sc.next().charAt(0);
            
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                System.out.println("Given character is a vowel");
            } else {
                System.out.println("Given character is not a vowel");
            }
        }
    }
}
