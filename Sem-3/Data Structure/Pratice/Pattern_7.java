import java.util.*;
public class Pattern_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i = a ; i>=1 ; i--){
            for(int k=a-i ; k>0 ; k--){
                System.out.print(" ");
            }
            for(int j=(2*i)-1 ; j>=1 ; j--){
                    System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 2 ; i<=a ; i++){
            for(int k=0 ; k<(a-i) ; k++){
                System.out.print(" ");
            }
            for(int j=1 ; j<=(2*i)-1 ; j++){
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
