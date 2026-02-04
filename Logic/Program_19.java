import java.util.Scanner;

public class Program_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = 1;
        for(int i=1 ; i<=n ; i++){
            if(i%2 ==0){
                temp += n-1;
                for(int j=n ; j>0 ; j--){
                    System.out.print((temp--) + " ");
                }
                temp += n+1;
            }
            else{
                for(int j=1 ; j<=n ; j++){
                    System.out.print((temp++) + " ");
                }
            }
            System.out.println();
        } 
        sc.close();
    }
}
