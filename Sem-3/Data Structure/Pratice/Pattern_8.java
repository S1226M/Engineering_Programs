// #include <stdio.h>
// int main()
// {
//     int i, j, n, k;
//     printf("plese enter a number\n");
//     scanf("%d", &n);
//     for (i = 1; i <= n; i++)
//     {
//         for (j = 1; j <= n - i; j++)
//         {
//             printf(" ");
//         }
//         for (j = 1; j <= 2 * i - 1; j++)
//         {
//             printf("*");
//         }
//         printf("\n");
//     }
//     for (i = n-1; i >= 1; i--)
//     {
//         for (j = n - i; j >= 1; j--)
//         {
//             printf(" ");
//         }
//         for (j = 2 * i - 1; j >= 1; j--)
//         {
//             printf("*");
//         }
//         printf("\n");
//     }
//     return 0;
// }
import java.util.*;

public class Pattern_8 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a number:");
        int n = sc.nextInt();
        
        // Top part of the pattern
        for (int i = 1; i <= n; i++) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Bottom part of the pattern
        for (int i = n - 1; i >= 1; i--) {
            // Print spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
