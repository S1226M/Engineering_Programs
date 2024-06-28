import java.util.Scanner;

public class Swap_6_33 {
    int a;
    int b;
    int temp;
    public void read(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a : ");
        a=sc.nextInt();
        System.out.println("Enter b : ");
        b=sc.nextInt();
    }
    public void displaySwap(){
        temp = a;
        a = b;
        b= temp;
        System.out.println("a= "+a+", b= "+b);
    }
    public static void main(String[] args) {
        Swap_6_33 s = new Swap_6_33();
        s.read();
        s.displaySwap();
    }
}
