import java.util.Scanner;

public class ReadeMatrixOfAnyOrderAndMultiplay_5_31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        int m1[][] = new int[row1][col1];
        for(int i=0;i<row1;i++){
            for(int j=0 ; j<col1 ; j++){
                m1[i][j] = sc.nextInt();
            }
        }
        int row2 = sc.nextInt();
        int col2 = sc.nextInt();
        int m2[][] = new int[row2][col2];
        for(int i=0;i<row2;i++){
            for(int j=0 ; j<col2 ; j++){
                m2[i][j] = sc.nextInt();
            }
        }
        int m3[][] = new int[row1][col2];
        for(int i=0;i<row1;i++){
            for(int j=0 ; j<col2 ; j++){
                for(int k=0;k<2;k++){
                    m3[i][j]+=m1[i][k]*m2[k][j];
                }
            }
        }
        for(int i=0;i<row1;i++){
            for(int j=0 ; j<col2 ;j++){
                System.out.print(m3[i][j]+" ");
            }
            System.out.println();
        }
    }    
}
