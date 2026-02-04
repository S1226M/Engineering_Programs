import java.util.Scanner;

public class ChocolateOfferProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Moeny");
        int Money = sc.nextInt();
        System.out.println("Price of chocolate:");
        int PriceOfChocolate = sc.nextInt();
        System.out.println("How many Return Wraper To get one Chocolate:");
        int WraperReturnChocolate = sc.nextInt();
        int chocolate = Money / PriceOfChocolate;
        int Wraper = chocolate;
        while (Wraper >= 3) {
            int temp = Wraper / WraperReturnChocolate;
            chocolate += temp;
            Wraper += temp;
            Wraper -= temp * WraperReturnChocolate;
        }
        System.out.println(chocolate);
    }
}
