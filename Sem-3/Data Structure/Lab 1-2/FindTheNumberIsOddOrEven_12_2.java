import java.util.Scanner;

public class FindTheNumberIsOddOrEven_12_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number that we can check the given number is odd or even : ");
        int a = sc.nextInt();
        if(a%2==0){
            System.out.println("Given number is even");
        }
        else{
            System.out.println("Given number is odd");
        }
    }    
}
