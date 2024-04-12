import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Stone_Paper_Sizer_game_with_Computer {
    public static void main(String[] args) {
        // 0 is stone
        // 1 is paper
        // 2 is sizer
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                // Input by user
                System.out.println("Enter 0 for stone, 1 for paper, or 2 for sizer:");
                int a = sc.nextInt();

                if (a < 0 || a > 2) {
                    System.out.println("Please enter a valid number between 0 and 2.");
                    continue; // Prompt user again for valid input
                }

                // Input by computer
                Random random = new Random();
                int computerInput = random.nextInt(3);

                if (a == computerInput) {
                    System.out.println("Draw!");
                } 
                else if ((a == 0 && computerInput == 2) || (a == 1 && computerInput == 0) || (a == 2 && computerInput == 1)) {
                    System.out.println("You win!");
                } 
                else {
                    System.out.println("Oops! You lose!");
                }
                System.out.println("Computer chose: " + computerInput);
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Please enter an integer number.");
                sc.next(); // Clear the invalid input from the scanner
            }
        }
        sc.close(); // Close the scanner
    }
}
