
public class Pattern {

    public static void main(String[] args) {
        int numberOfRows = 5; // You can change this value to print more or fewer rows
        for (int i = 1; i <= numberOfRows; i++) {
            // Print leading spaces
            for (int j = 1; j <= numberOfRows - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            // Move to the next line after each row
            System.out.println();
        }
    }
}
