import java.util.Scanner;

public class AdditionOf2by2Matrix_5_30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int m1[][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0 ; j<col ;j++){
                m1[i][j]=sc.nextInt();
            }
        }
        int m2[][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0 ; j<col ;j++){
                m2[i][j]=sc.nextInt();
            }
        }
        int m3[][] = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0 ; j<col ;j++){
                m3[i][j]=m2[i][j]+m1[i][j];
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0 ; j<col ;j++){
                System.out.print(m3[i][j]+" ");
            }
            System.out.println();
        }
    }    
}
