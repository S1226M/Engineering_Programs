public class ReversedTrianglePattern {
    public static void main(String[] args) {
        int rows = 20; // Adjust the number of rows as needed
        int num = 1;

        for (int i = 1; i <= rows; i++) {
            // Print numbers
            for (int j = 1; j <= i; j++) {
                System.out.printf("%3d", num);
                num++;
            }

            // Print spaces for alignment
            for (int k = 1; k <= rows - i; k++) {  
                System.out.print("   ");
            }

            System.out.println();
        }
    }
}