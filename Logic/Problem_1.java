import java.util.Scanner;

public class Problem_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        for(int i=1 ; i<=n ; i++){
            if(n%i == 0){
                count++;
                if(count > 2 ){
                    break;
                }
            }
        }
        if(count == 2){
            System.out.print("Number is Prime.");
        }
        else{
            System.out.println("Number is not Prime.");
        }
    }
}
