
import java.util.Scanner;

public class MultiplicationOf2Matrix_13 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for the first matrix : ");
        int rows1 = sc.nextInt();
        System.out.print("Enter the number of columns for the first matrix : ");
        int cols1 = sc.nextInt();
        System.out.println("Enter the elements of the first matrix : ");
        int[][] matrix1 = new int[rows1][cols1];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols1; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the number of rows for the second matrix : ");
        int rows2 = sc.nextInt();
        System.out.print("Enter the number of columns for the second matrix : ");
        int cols2 = sc.nextInt();
        if (cols1 != rows2) {
            System.out.println("Matrix multiplication is not possible with the given dimensions.");
            return;
        }
        int[][] matrix2 = new int[rows2][cols2];
        System.out.println("Enter the elements of the second matrix : ");
        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix2[i][j] = sc.nextInt();
            }
        }
        int[][] result = new int[rows1][cols2];
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Resultant matrix after multiplication:");
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
