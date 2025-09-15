import java.util.Scanner;

public class SadelPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix");
        int n = sc.nextInt();
        int arr[][] = new int[n][n];

        for(int i=0 ; i < n ; i++){
            for(int j=0 ; j<n ; j++){
                System.out.print("Enter the element ("+i+","+j+") : ");
                arr[i][j] = sc.nextInt();
            }
        }

        boolean found = false;

        for(int i=0; i<n; i++) {
            int rowMin = arr[i][0];
            int colIndex = 0;
            for(int j=1; j<n; j++) {
                if(arr[i][j] < rowMin) {
                    rowMin = arr[i][j];
                    colIndex = j;
                }
            }

            boolean isSaddle = true;
            for(int k=0; k<n; k++) {
                if(arr[k][colIndex] > rowMin) {
                    isSaddle = false;
                    break;
                }
            }

            if(isSaddle) {
                System.out.println("Saddle Point found at ("+i+","+colIndex+") = " + rowMin);
                found = true;
            }
        }

        if(!found) {
            System.out.println("There is no Saddle Point");
        }
    }
}