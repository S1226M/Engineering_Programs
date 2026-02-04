import java.util.Scanner;

public class Problem_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            
            for (int s = 0; s < rows - i; s++) {
                System.out.print(" ");
            }

            int num = 1; 
            for (int j = 0; j <= i; j++) {
                System.out.print(num + " ");
            
                num = num * (i - j) / (j + 1);
            }
            System.out.println(); 
        }
        sc.close();
    }
}