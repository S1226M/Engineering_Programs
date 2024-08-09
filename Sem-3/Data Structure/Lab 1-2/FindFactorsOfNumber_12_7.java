import java.util.Scanner;

public class FindFactorsOfNumber_12_7 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            for(int i=1 ; i<=a ; i++){
                if(a%i==0){
                    System.out.print(" "+i);
                }
            }
        }
    }
}
