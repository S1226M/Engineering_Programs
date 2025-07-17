import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Starting Index");
        int start = sc.nextInt();
        System.out.println(("Enter the ending Index"));
        int End = sc.nextInt();

        for(int i=start ; i<= End ; i++){
            int count = 0;
            for(int j=1 ; j<=i ; j++){
                if(i%j==0){
                    count++;
                }
            }
            if(count == 2){
                System.out.print(i+" ");
            }
        }
    }
}
